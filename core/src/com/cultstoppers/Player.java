package com.cultstoppers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

/**
 * Created by jose on 1/29/16.
 */
public class Player extends Entity{

    UserInterface ui;

    ArrayList<Weapon> bullets;
    TextureRegion texture;
    Weapon currentWeapon;
    boolean canShoot;
    String weaponT;
    public Player(){
        canShoot = true;
        x = 0;
        y = 0;
        health = 8;
        speed = 7;
        batch = new SpriteBatch();
        sprite = new Texture("Characters/CatspriteSheetV_01.png");
        spritesheet = new Texture("Characters/CatspriteSheetV_01.png");
        hitbox = new Rectangle(x,y,sprite.getWidth()/2,sprite.getHeight());
        walkFrames = TextureRegion.split(spritesheet, spritesheet.getWidth()/2, spritesheet.getHeight());
        ui = new UserInterface(health);
        animRight = new Animation(1f, walkFrames[0]);
        animLeft = new Animation(1f, walkFrames[0]);
        bullets = new ArrayList<Weapon>();

    }
    public void move(){
        hitbox.setPosition(x,y);
        if(Gdx.input.isKeyPressed(Input.Keys.NUM_1)){
            ui.weaponTexture=ui.shotgunTexture;
            weaponT="shotgun";
        }
        if(Gdx.input.isKeyPressed(Input.Keys.NUM_2)){
            ui.weaponTexture=ui.swordTexture;
            weaponT="sword";
        }
        if(Gdx.input.isKeyPressed(Input.Keys.NUM_3)){
            ui.weaponTexture=ui.machineTexture;
            weaponT="machinegun";
        }

        if(Gdx.input.isKeyPressed(Input.Keys.NUM_4)){
            ui.weaponTexture=ui.pistolTexture;
            weaponT="pistol";
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            y+=speed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            y-=speed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            x-=speed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            x += speed;
        }

        if(weaponT=="shotgun") {
            shotgunMove();
        }

        if(weaponT=="machinegun"){
            machineMove();
        }
        if(weaponT=="pistol"){
            pistolMove();
        }

        if(weaponT=="sword"){
            swordMove();
        }
        checkWall();
    }
    public void render(){
        ui.hit(health);
        stateTime += Gdx.graphics.getDeltaTime();
        texture = animRight.getKeyFrame(stateTime, true);
        for (int i = 0; i < bullets.size(); i++){
            bullets.get(i).update();
            if(bullets.get(i).isOutOfBounds()){
                bullets.remove(i);
            }
        }

        batch.begin();
        batch.draw(texture, x, y);//, sprite.getWidth()/4, sprite.getHeight()/4);
        batch.end();

    }
    public void renderUI(){
        ui.render();
    }
    public void checkWall(){
        if((x > Gdx.graphics.getWidth() - sprite.getWidth()/2)){
            x = Gdx.graphics.getWidth() - sprite.getWidth()/2;
        }else if (x < 0){
            x = 0;
        }
        if(y > Gdx.graphics.getHeight() - sprite.getHeight()){
            y = Gdx.graphics.getHeight() - sprite.getHeight();
        }else if (y < 0){
            y = 0;
        }
    }

    public void shotgunMove(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            bullets.add(new Shotgun(x+(spritesheet.getWidth()/4), y+(spritesheet.getHeight()/2), 'u'));
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            bullets.add(new Shotgun(x+(spritesheet.getWidth()/4), y+(spritesheet.getHeight()/2), 'd'));
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            bullets.add(new Shotgun(x+(spritesheet.getWidth()/4), y+(spritesheet.getHeight()/2), 'l'));
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            bullets.add(new Shotgun(x+(spritesheet.getWidth()/4), y+(spritesheet.getHeight()/2), 'r'));

        }
    }
    public void machineMove(){
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            bullets.add(new MachineGun(x+(spritesheet.getWidth()/4), y+(spritesheet.getHeight()/2), 'u'));
        }else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            bullets.add(new MachineGun(x+(spritesheet.getWidth()/4), y+(spritesheet.getHeight()/2), 'd'));
        }else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            bullets.add(new MachineGun(x+(spritesheet.getWidth()/4), y+(spritesheet.getHeight()/2), 'l'));
        }else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            bullets.add(new MachineGun(x+(spritesheet.getWidth()/4), y+(spritesheet.getHeight()/2), 'r'));
        }
    }
    public void pistolMove() {

    }
    public void swordMove(){

        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            bullets.add(new Sword(x+(spritesheet.getWidth()/4), y+(spritesheet.getHeight()/2), 'u'));
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            bullets.add(new Sword(x+(spritesheet.getWidth()/4), y+(spritesheet.getHeight()/2), 'd'));
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            bullets.add(new Sword(x+(spritesheet.getWidth()/4), y+(spritesheet.getHeight()/2), 'l'));
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            bullets.add(new Sword(x+(spritesheet.getWidth()/4), y+(spritesheet.getHeight()/2), 'r'));
        }
    }

    public void checkHit(Enemy e){
        for(int i = 0; i < e.bullets.size(); i++){
            if(e.bullets.get(i).hit(hitbox)){
                e.bullets.remove(i);
                health--;
            }
        }

    }
}

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

    String weaponT;
    public Player(){
        x = 0;
        y = 0;
        health = 8;
        speed = 5;
        batch = new SpriteBatch();
        sprite = new Texture("roshi.png");
        spritesheet = new Texture("roshisheet.png");
        hitbox = new Rectangle(x,y,sprite.getWidth(),sprite.getHeight());
        walkFrames = TextureRegion.split(spritesheet, spritesheet.getWidth()/7, spritesheet.getHeight()/2);
        ui = new UserInterface(health);
        animRight = new Animation(1f, walkFrames[0]);
        animLeft = new Animation(1f, walkFrames[1]);
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

        if(Gdx.input.isKeyJustPressed(Input.Keys.K)) {
            ui.hit();
        }
        checkWall();
    }
    public void render(){
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
        ui.render();
    }

    public void checkWall(){
        if((x > Gdx.graphics.getWidth() - sprite.getWidth()/4)){
            x = Gdx.graphics.getWidth() - sprite.getWidth()/4;
        }else if (x < 0){
            x = 0;
        }
        if(y > Gdx.graphics.getHeight() - sprite.getHeight()/4){
            y = Gdx.graphics.getHeight() - sprite.getHeight()/4;
        }else if (y < 0){
            y = 0;
        }
    }
    public void updateHealth(int dmg) {

    }

    public void shotgunMove(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            bullets.add(new Shotgun(x, y, 'u'));
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            bullets.add(new Shotgun(x, y, 'd'));
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            bullets.add(new Shotgun(x, y, 'l'));
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            bullets.add(new Shotgun(x, y, 'r'));

        }
    }
    public void machineMove(){
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            bullets.add(new MachineGun(x, y, 'u'));
        }else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            bullets.add(new MachineGun(x, y, 'd'));
        }else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            bullets.add(new MachineGun(x, y, 'l'));
        }else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            bullets.add(new MachineGun(x, y, 'r'));

        }
    }
    public void pistolMove(){

    }
}

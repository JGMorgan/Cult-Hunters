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
    boolean dir[];
    UserInterface ui;

    ArrayList<Weapon> bullets;
    TextureRegion texture;
    Weapon currentWeapon;
    boolean canShoot;
    String weaponT;
    public Player(){
        canShoot = true;
        dir = new boolean[]{false, false, false, false};//up down left right
        x = 0;
        y = 0;
        health = 200;
        speed = 7;
        batch = new SpriteBatch();
        //sprite = new Texture("Characters/CatspriteSheetV_01.png");
        spritesheet = new Texture("Characters/CatWalkSheet.png");
        hitbox = new Rectangle(x,y,spritesheet.getWidth()/5,spritesheet.getHeight()/4);
        walkFrames = TextureRegion.split(spritesheet, spritesheet.getWidth()/5, spritesheet.getHeight()/4);
        ui = new UserInterface(health);
        animUpRight = new Animation(0.2f, walkFrames[3]);
        animUpLeft = new Animation(0.2f, walkFrames[1]);
        animDownRight = new Animation(0.2f, walkFrames[2]);
        animDownLeft = new Animation(0.2f, walkFrames[0]);
        bullets = new ArrayList<Weapon>();

    }
    public void move(){
        hitbox.setPosition(x, y);
        stateTime += Gdx.graphics.getDeltaTime();
        if(dir[0]){
            texture = animUpLeft.getKeyFrame(0, true);
        }else{
            texture = animDownLeft.getKeyFrame(0, true);
        }

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
            dir[0] = true;
            dir[1] = false;
            if(dir[2]){
                texture = animUpLeft.getKeyFrame(stateTime, true);
            }else{
                texture = animUpRight.getKeyFrame(stateTime, true);
            }
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.S)){
            y-=speed;
            dir[1] = true;
            dir[0] = false;
            if(dir[2]){
                texture = animDownLeft.getKeyFrame(stateTime, true);
            }else{
                texture = animDownRight.getKeyFrame(stateTime, true);
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            x-=speed;
            dir[2] = true;
            dir[3] = false;
            if(dir[0]){
                texture = animUpLeft.getKeyFrame(stateTime, true);
            }else {
                texture = animDownLeft.getKeyFrame(stateTime, true);
            }
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            x += speed;
            dir[3] = true;
            dir[2] = false;
            if(dir[0]){
                texture = animUpRight.getKeyFrame(stateTime, true);
            }else {
                texture = animDownRight.getKeyFrame(stateTime, true);
            }
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
        if((x > Gdx.graphics.getWidth() - spritesheet.getWidth()/5)){
            x = Gdx.graphics.getWidth() - spritesheet.getWidth()/5;
        }else if (x < 0){
            x = 0;
        }
        if(y > Gdx.graphics.getHeight() - spritesheet.getHeight()/4){
            y = Gdx.graphics.getHeight() - spritesheet.getHeight()/4;
        }else if (y < 0){
            y = 0;
        }
    }

    public void shotgunMove(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            bullets.add(new Shotgun(x+(spritesheet.getWidth()/10), y+(spritesheet.getHeight()/8), 'u'));
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            bullets.add(new Shotgun(x+(spritesheet.getWidth()/10), y+(spritesheet.getHeight()/8), 'd'));
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            bullets.add(new Shotgun(x+(spritesheet.getWidth()/10), y+(spritesheet.getHeight()/8), 'l'));
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            bullets.add(new Shotgun(x+(spritesheet.getWidth()/10), y+(spritesheet.getHeight()/8), 'r'));

        }
    }
    public void machineMove(){
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            bullets.add(new MachineGun(x+(spritesheet.getWidth()/10), y+(spritesheet.getHeight()/8), 'u'));
        }else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            bullets.add(new MachineGun(x+(spritesheet.getWidth()/10), y+(spritesheet.getHeight()/8), 'd'));
        }else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            bullets.add(new MachineGun(x+(spritesheet.getWidth()/10), y+(spritesheet.getHeight()/8), 'l'));
        }else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            bullets.add(new MachineGun(x+(spritesheet.getWidth()/10), y+(spritesheet.getHeight()/8), 'r'));
        }
    }
    public void pistolMove() {

    }
    public void swordMove(){

        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            bullets.add(new Sword(x+(spritesheet.getWidth()/10), y+(spritesheet.getHeight()/8), 'u'));
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            bullets.add(new Sword(x+(spritesheet.getWidth()/10), y+(spritesheet.getHeight()/8), 'd'));
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            bullets.add(new Sword(x+(spritesheet.getWidth()/10), y+(spritesheet.getHeight()/8), 'l'));
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            bullets.add(new Sword(x+(spritesheet.getWidth()/10), y+(spritesheet.getHeight()/8), 'r'));
        }
    }

    public void checkHit(Enemy e){
        for(int i = 0; i < e.bullets.size(); i++){
            if(e.bullets.get(i).hit(hitbox)){
                health-=e.bullets.get(i).damage;
                e.bullets.remove(i);
                health--;
            }
        }

    }
}

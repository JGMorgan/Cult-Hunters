package com.cultstoppers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

/**
 * Created by jose on 1/30/16.
 */
public class Boss extends Enemy {
    Random bossType=new Random();
    int BossType;
    TextureRegion texture;
    boolean goingUp = true;
    public Boss(){
        x = 0;
        y = 0;
        stateTime=0;
        health = 10;
        speed = 7;
        sprite = new Texture("Characters/CatspriteSheetV_01.png");
        spritesheet = new Texture("Characters/ZombieDogSheet.png");
        hitbox = new Rectangle(x,y,spritesheet.getWidth()/7,spritesheet.getHeight()/3);
        walkFrames = TextureRegion.split(spritesheet, spritesheet.getWidth() / 7, spritesheet.getHeight() / 3);
        animDownLeft = new Animation(0.8f, walkFrames[0]);
        animDownRight = new Animation(0.8f, walkFrames[1]);
        animUpLeft = new Animation(0.8f, walkFrames[2]);
        texture = animUpLeft.getKeyFrame(0, true);
    }

    public void checkHit(Player p){
        hitbox.setPosition(x, y);
        for(int i = 0; i < p.bullets.size(); i++){
            if(p.bullets.get(i).hit(hitbox)){
                health-=p.bullets.get(i).damage;
                p.bullets.remove(i);
            }
        }

    }

    public void render(){

        stateTime += Gdx.graphics.getDeltaTime();

        batch.begin();
        batch.draw(texture, x, y, texture.getRegionWidth(), texture.getRegionHeight());
        batch.end();
    }


    public void move(Player p){
        super.move(p);
        texture = animDownLeft.getKeyFrame(0, true);
        if(dir == 'u'){
            texture = animDownLeft.getKeyFrame(stateTime, true);
        }else if(dir == 'd'){
            texture = animDownRight.getKeyFrame(stateTime, true);
        }else if(dir == 'l'){
            texture = animDownLeft.getKeyFrame(stateTime, true);
        }else if(dir == 'r'){
            texture = animDownRight.getKeyFrame(stateTime, true);
        }

    }

    public void checkWall(){
        if((x > Gdx.graphics.getWidth() - texture.getRegionWidth())){
            x = Gdx.graphics.getWidth() - texture.getRegionWidth();
        }else if (x < 0){
            x = 0;
        }
        if(y > Gdx.graphics.getHeight() - texture.getRegionHeight()){
            y = Gdx.graphics.getHeight() - texture.getRegionHeight();
            goingUp = false;
        }else if (y < 0){
            y = 0;
            goingUp = true;
        }
    }

}

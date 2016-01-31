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
    public Boss(){
        x = 0;
        y = 0;
        health = 10;
        sprite = new Texture("Characters/CatspriteSheetV_01.png");
        spritesheet = new Texture("Characters/CatspriteSheetV_01.png");
        hitbox = new Rectangle(x,y,sprite.getWidth()/2,sprite.getHeight());
        walkFrames = TextureRegion.split(spritesheet, spritesheet.getWidth() / 2, spritesheet.getHeight());
        animRight = new Animation(1f, walkFrames[0]);
        animLeft = new Animation(1f, walkFrames[0]);
    }
    public void render(){

        stateTime += Gdx.graphics.getDeltaTime();
        texture = animRight.getKeyFrame(stateTime, true);
        batch.begin();
        batch.draw(texture, x, y, sprite.getWidth()/2, sprite.getHeight());
        batch.end();
    }

    /*
    public void move(){
        hitbox.setPosition(x,y);
        BossType=bossType.nextInt(4);
        switch(BossType){
            case 1: bullets.add(new Shotgun(x,y,dir));
                break;
            case 2:bullets.add(new Sword(x,y,dir));
                break;
            case 3:bullets.add(new MachineGun(x,y,dir));
                break;
            case 4:bullets.add(new Pistol(x,y,dir));
                break;
        }
    }
    */
}

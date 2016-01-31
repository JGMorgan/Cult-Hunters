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
        health = 10;
        speed = 7;
        sprite = new Texture("Characters/CatspriteSheetV_01.png");
        spritesheet = new Texture("Characters/CatWalkSheet.png");
        hitbox = new Rectangle(x,y,sprite.getWidth()/2,sprite.getHeight());
        walkFrames = TextureRegion.split(spritesheet, spritesheet.getWidth() / 5, spritesheet.getHeight() / 4);
        animDownLeft = new Animation(0.2f, walkFrames[0]);
        animDownRight = new Animation(0.2f, walkFrames[2]);
        animUpLeft = new Animation(0.2f, walkFrames[1]);
        animUpRight = new Animation(0.2f, walkFrames[3]);
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
        texture = animDownLeft.getKeyFrame(0, true);
        batch.begin();
        batch.draw(texture, x, y, sprite.getWidth()/2, sprite.getHeight());
        batch.end();
    }


    public void move(){

        hitbox.setPosition(x, y);

        if(goingUp)
            y += speed;
        else
            y -= speed;

        checkWall();
    }

    public void checkWall(){
        if((x > Gdx.graphics.getWidth() - sprite.getWidth()/2)){
            x = Gdx.graphics.getWidth() - sprite.getWidth()/2;
        }else if (x < 0){
            x = 0;
        }
        if(y > Gdx.graphics.getHeight() - sprite.getHeight()){
            y = Gdx.graphics.getHeight() - sprite.getHeight();
            goingUp = false;
        }else if (y < 0){
            y = 0;
            goingUp = true;
        }
    }

}

package com.cultstoppers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import java.lang.Math;

/**
 * Created by jose on 1/29/16.
 */
public class Shotgun extends Weapon{
    int speed;
    int x1,x2,x3,x4;
    int y1,y2,y3,y4;
//    Rectangle hitbox2;
//    Rectangle hitbox3;
//    Rectangle hitbox4;
//    Rectangle hitbox5;

    public Shotgun(int x, int y, char dir, char entity){
        stateTime=0;
        WeaponType="shotgun";
        batch = new SpriteBatch();
        if(entity == 'p') {
            sprite = new Texture("Fire_Bullet.png");
        }else{
            sprite = new Texture("GreenFire_Bullet.png");
        }
        animFrames = TextureRegion.split(sprite, sprite.getWidth() / 2, sprite.getHeight()/4);
        animUp = new Animation(0.2f, animFrames[3]);
        animDown = new Animation(0.2f, animFrames[2]);
        animLeft = new Animation(0.2f, animFrames[0]);
        animRight = new Animation(0.2f, animFrames[1]);
        speed = 5;
        damage = 1;
        initX = x;
        initY = y;
        this.dir = dir;
        this.x = x;
        this.x1 = x;
        this.x2 = x;
        this.x3 = x;
        this.x4 = x;
        this.y = y;
        this.y1 = y;
        this.y2 = y;
        this.y3 = y;
        this.y4 = y;
        hitbox = new Rectangle(this.x,this.y,sprite.getWidth()/2,sprite.getHeight()/4);
        hitbox2 = new Rectangle(this.x1,this.y1,sprite.getWidth()/2,sprite.getHeight()/4);
        hitbox3 = new Rectangle(this.x2,this.y2,sprite.getWidth()/2,sprite.getHeight()/4);
        hitbox4 = new Rectangle(this.x3,this.y3,sprite.getWidth()/2,sprite.getHeight()/4);
        hitbox5 = new Rectangle(this.x4,this.y4,sprite.getWidth()/2,sprite.getHeight()/4);
    }

    @Override
    public void update() {
        stateTime += Gdx.graphics.getDeltaTime();
        hitbox.setPosition(x,y);

        hitbox2.setPosition(x1,y1);

        hitbox3.setPosition(x2,y2);

        hitbox4.setPosition(x3,y3);

        hitbox5.setPosition(x4,y4);

        if(dir == 'r') {
            texture = animRight.getKeyFrame(stateTime, true);
            x += speed;
            x1 += Math.cos(3.1415 / 12) * speed;
            x2 += Math.cos(3.1415 / 6) * speed;
            x3 += Math.cos(-3.1415 / 12) * speed;
            x4 += Math.cos(-3.1415 / 6) * speed;
            y1 += Math.sin(3.1415 / 12) * speed;
            y2 += Math.sin(3.1415 / 6) * speed;
            y3 += Math.sin(-3.1415 / 12) * speed;
            y4 += Math.sin(-3.1415 / 6) * speed;
        }
        else if(dir == 'l') {
            texture = animLeft.getKeyFrame(stateTime, true);
            x -= speed;
            x1 -= Math.cos(3.1415 / 12) * speed;
            x2 -= Math.cos(3.1415 / 6) * speed;
            x3 -= Math.cos(-3.1415 / 12) * speed;
            x4 -= Math.cos(-3.1415 / 6) * speed;
            y1 += Math.sin(3.1415 / 12) * speed;
            y2 += Math.sin(3.1415 / 6) * speed;
            y3 += Math.sin(-3.1415 / 12) * speed;
            y4 += Math.sin(-3.1415 / 6) * speed;
        }
        else if(dir == 'u') {
            texture = animUp.getKeyFrame(stateTime, true);
            y += speed;
            y1 += Math.cos(3.1415 / 12) * speed;
            y2 += Math.cos(3.1415 / 6) * speed;
            y3 += Math.cos(-3.1415 / 12) * speed;
            y4 += Math.cos(-3.1415 / 6) * speed;
            x1 += Math.sin(3.1415 / 12) * speed;
            x2 += Math.sin(3.1415 / 6) * speed;
            x3 += Math.sin(-3.1415 / 12) * speed;
            x4 += Math.sin(-3.1415 / 6) * speed;
        }
        else if(dir == 'd') {
            texture = animDown.getKeyFrame(stateTime, true);
            y -= speed;
            y1 -= Math.cos(3.1415 / 12) * speed;
            y2 -= Math.cos(3.1415 / 6) * speed;
            y3 -= Math.cos(-3.1415 / 12) * speed;
            y4 -= Math.cos(-3.1415 / 6) * speed;
            x1 += Math.sin(3.1415 / 12) * speed;
            x2 += Math.sin(3.1415 / 6) * speed;
            x3 += Math.sin(-3.1415 / 12) * speed;
            x4 += Math.sin(-3.1415 / 6) * speed;
        }
        batch.begin();
        batch.draw(texture, x, y, texture.getRegionWidth(), texture.getRegionHeight());
        batch.draw(texture, x1, y1, texture.getRegionWidth(), texture.getRegionHeight());
        batch.draw(texture, x2, y2, texture.getRegionWidth(), texture.getRegionHeight());
        batch.draw(texture, x3, y3, texture.getRegionWidth(), texture.getRegionHeight());
        batch.draw(texture, x4, y4, texture.getRegionWidth(), texture.getRegionHeight());
        batch.end();
    }

    public boolean isOutOfBounds(){
        return (x > initX + Gdx.graphics.getWidth()/5) ||
                (x < initX - Gdx.graphics.getWidth()/5) ||
                (y > initY + Gdx.graphics.getWidth()/5) ||
                (y < initY - Gdx.graphics.getWidth()/5);
    }
}

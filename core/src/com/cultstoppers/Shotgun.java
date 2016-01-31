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

    public Shotgun(int x, int y, char dir){
        stateTime=0;
        WeaponType="shotgun";
        batch = new SpriteBatch();
        sprite = new Texture("Fire_Bullet.png");
        animFrames = TextureRegion.split(sprite, sprite.getWidth() / 2, sprite.getHeight());
        anim = new Animation(0.2f, animFrames[0]);
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
        hitbox = new Rectangle(this.x,this.y,sprite.getWidth()/4,sprite.getHeight()/2);
        hitbox2 = new Rectangle(this.x1,this.y1,sprite.getWidth()/4,sprite.getHeight()/2);
        hitbox3 = new Rectangle(this.x2,this.y2,sprite.getWidth()/4,sprite.getHeight()/2);
        hitbox4 = new Rectangle(this.x3,this.y3,sprite.getWidth()/4,sprite.getHeight()/2);
        hitbox5 = new Rectangle(this.x4,this.y4,sprite.getWidth()/4,sprite.getHeight()/2);
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
        texture = anim.getKeyFrame(stateTime, true);
        batch.begin();
        batch.draw(texture, x, y, texture.getRegionWidth()/2, texture.getRegionHeight()/2);
        batch.draw(texture, x1, y1, texture.getRegionWidth()/2, texture.getRegionHeight()/2);
        batch.draw(texture, x2, y2, texture.getRegionWidth()/2, texture.getRegionHeight()/2);
        batch.draw(texture, x3, y3, texture.getRegionWidth()/2, texture.getRegionHeight()/2);
        batch.draw(texture, x4, y4, texture.getRegionWidth()/2, texture.getRegionHeight()/2);
        batch.end();
    }

    public boolean isOutOfBounds(){
        return (x > initX + Gdx.graphics.getWidth()/5) ||
                (x < initX - Gdx.graphics.getWidth()/5) ||
                (y > initY + Gdx.graphics.getWidth()/5) ||
                (y < initY - Gdx.graphics.getWidth()/5);
    }
}

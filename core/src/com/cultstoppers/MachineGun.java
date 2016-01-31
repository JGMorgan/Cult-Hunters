package com.cultstoppers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

/**
 * Created by jose on 1/30/16.
 */
public class MachineGun extends Weapon{
    int speed;
    Random r;
    int random;
    public MachineGun(int x, int y, char dir){
        stateTime=0;
        r = new Random();
        random = r.nextInt(3);
        batch = new SpriteBatch();
        sprite = new Texture("Fire_Bullet.png");
        animFrames = TextureRegion.split(sprite, sprite.getWidth() / 2, sprite.getHeight());
        anim = new Animation(0.2f, animFrames[0]);
        speed = 10;
        damage = 1;
        this.dir = dir;
        initX = x;
        initY = y;
        this.x = x;
        this.y = y;
        hitbox = new Rectangle(this.x,this.y,sprite.getWidth()/8,sprite.getHeight()/4);
    }

    @Override
    public void update() {
        stateTime += Gdx.graphics.getDeltaTime();
        hitbox.setPosition(x,y);
        if (dir == 'u'){
            y+=speed;
            if (random == 0){
                x-=Math.floor(Math.cos(((11*3.1415)/16)*speed));
            }else if (random == 1){
                x+=Math.floor(Math.cos(((11*3.1415)/16)*speed));
            }
        }else if (dir == 'd'){
            y-=speed;
            if (random == 0){
                x-=Math.floor(Math.cos(((11*3.1415)/16)*speed));
            }else if (random == 1){
                x+=Math.floor(Math.cos(((11*3.1415)/16)*speed));
            }
        }else if (dir == 'l'){
            x-=speed;
            if (random == 0){
                y-=Math.floor(Math.cos(((11*3.1415)/16)*speed));
            }else if (random == 1){
                y+=Math.floor(Math.cos(((11*3.1415)/16)*speed));
            }
        }else if (dir == 'r'){
            x+=speed;
            if (random == 0){
                y-=Math.floor(Math.cos(((11 * 3.1415) / 16) * speed));
            }else if (random == 1){
                y+=Math.floor(Math.cos(((11 * 3.1415) / 16) * speed));
            }
        }
        texture = anim.getKeyFrame(stateTime, true);
        batch.begin();
        batch.draw(texture, x, y, texture.getRegionWidth()/4, texture.getRegionHeight()/4);
        batch.end();
    }
    public boolean isOutOfBounds(){
        return (x > initX + Gdx.graphics.getWidth()/3) ||
                (x < initX - Gdx.graphics.getWidth()/3) ||
                (y > initY + Gdx.graphics.getWidth()/3) ||
                (y < initY - Gdx.graphics.getWidth()/3);
    }
}

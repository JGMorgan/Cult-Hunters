package com.cultstoppers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by jose on 1/29/16.
 */
public class Pistol extends Weapon {
    int speed;
    public Pistol(int x, int y, char dir){
        stateTime=0;
        batch = new SpriteBatch();
        sprite = new Texture("Fire_Bullet.png");
        animFrames = TextureRegion.split(sprite, sprite.getWidth() / 2, sprite.getHeight());
        anim = new Animation(0.2f, animFrames[0]);
        speed = 5;
        damage = 1;
        this.dir = dir;
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
        }else if (dir == 'd'){
            y-=speed;
        }else if (dir == 'l'){
            x-=speed;
        }else if (dir == 'r'){
            x+=speed;
        }
        texture = anim.getKeyFrame(stateTime, true);
        batch.begin();
        batch.draw(texture, x, y, texture.getRegionWidth()/2, texture.getRegionHeight()/2);
        batch.end();
    }
}

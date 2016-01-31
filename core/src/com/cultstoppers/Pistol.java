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
    public Pistol(int x, int y, char dir, char entity){
        stateTime=0;
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
            texture = animUp.getKeyFrame(stateTime, true);
            y+=speed;
        }else if (dir == 'd'){
            texture = animDown.getKeyFrame(stateTime, true);
            y-=speed;
        }else if (dir == 'l'){
            texture = animLeft.getKeyFrame(stateTime, true);
            x-=speed;
        }else if (dir == 'r'){
            texture = animRight.getKeyFrame(stateTime, true);
            x+=speed;
        }
        batch.begin();
        batch.draw(texture, x, y, texture.getRegionWidth()/2, texture.getRegionHeight()/2);
        batch.end();
    }
}

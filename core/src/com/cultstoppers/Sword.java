package com.cultstoppers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Leon on 1/30/2016.
 */
public class Sword extends Weapon {
    int speed;
    public Sword(int x, int y, char dir){
        batch = new SpriteBatch();
        speed=10;
        sprite = new Texture("ScratchActionSheet.png");
        animFrames = TextureRegion.split(sprite, sprite.getWidth() / 3, sprite.getHeight()/4);
        animUp = new Animation(0.05f, animFrames[3]);
        animDown = new Animation(0.05f, animFrames[2]);
        animLeft = new Animation(0.05f, animFrames[0]);
        animRight = new Animation(0.05f, animFrames[1]);
        stateTime = 0f;
        damage=15;
        initX = x;
        initY = y;
        this.x=x;
        this.y=y;
        this.dir=dir;
        hitbox = new Rectangle(this.x,this.y,sprite.getWidth()/6,sprite.getHeight()/8);

    }

    public void update(){
        int offsetx = 0;
        int offsety = 0;
        stateTime+=Gdx.graphics.getDeltaTime();
        hitbox.setPosition(x,y);
        if (dir == 'u'){
            offsety = 4*speed;
            texture = animUp.getKeyFrame(stateTime, true);
        }else if (dir == 'd'){
            offsety = 4*(-speed);
            texture = animDown.getKeyFrame(stateTime, true);
        }else if (dir == 'l'){
            offsetx = 4*(-speed);
            texture = animLeft.getKeyFrame(stateTime, true);
        }else if (dir == 'r'){
            offsetx = 4*speed;
            texture = animRight.getKeyFrame(stateTime, true);
        }

        batch.begin();
        batch.draw(texture, x+offsetx, y+offsety, sprite.getWidth()/6, sprite.getHeight()/8);
        batch.end();

    };

    public boolean isOutOfBounds(){
        return stateTime > .15f;
    }
}

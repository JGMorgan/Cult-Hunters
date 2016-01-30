package com.cultstoppers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Leon on 1/30/2016.
 */
public class Sword extends Weapon {
    int speed;
    public Sword(int x, int y, char dir){
        batch = new SpriteBatch();
        speed=10;
        sprite = new Texture("lightsaber.png");
        damage=9001;
        initX = x;
        initY = y;
        this.x=x;
        this.y=y;
        this.dir=dir;
        hitbox = new Rectangle(this.x,this.y,sprite.getWidth(),sprite.getHeight());

    }

    public void update(){
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

        batch.begin();
        batch.draw(sprite, x, y);
        batch.end();

    };

    public boolean isOutOfBounds(){
        return (x > initX + Gdx.graphics.getWidth()/15) ||
                (x < initX - Gdx.graphics.getWidth()/15) ||
                (y > initY + Gdx.graphics.getWidth()/15) ||
                (y < initY - Gdx.graphics.getWidth()/15);
    }
}

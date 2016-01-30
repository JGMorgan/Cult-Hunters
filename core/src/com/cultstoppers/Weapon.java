package com.cultstoppers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by jose on 1/29/16.
 */
public abstract class Weapon {
    int x,y,initX,initY;
    int damage;
    Texture sprite;
    SpriteBatch batch;
    Rectangle hitbox;

    public abstract void update();

    public boolean isOutOfBounds(){
        return (x > Gdx.graphics.getWidth() * 1.5) ||
                (x < -(Gdx.graphics.getWidth() * 1.5)) ||
                (y > Gdx.graphics.getHeight() * 1.5) ||
                (y < -(Gdx.graphics.getHeight() * 1.5));
    }

}

package com.cultstoppers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by jose on 1/29/16.
 */
public class Enemy extends Entity{
    public Enemy(){
        x = 0;
        y = 0;
        health = 1;
        speed = 2;
        batch = new SpriteBatch();
        sprite = new Texture("megaman.png");
        hitbox = new Rectangle(x,y,sprite.getWidth(),sprite.getHeight());
    }

    public void move(){
        
    }
}

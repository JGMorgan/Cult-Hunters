package com.cultstoppers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

/**
 * Created by jose on 1/29/16.
 */
public class Enemy extends Entity{
    public Enemy(){
        Random r = new Random();
        x = r.nextInt(Gdx.graphics.getWidth());
        y = r.nextInt(Gdx.graphics.getHeight());
        health = 1;
        speed = 2;
        batch = new SpriteBatch();
        sprite = new Texture("megaman.png");
        hitbox = new Rectangle(x,y,sprite.getWidth(),sprite.getHeight());
    }

    public void move(Player p){

        
    }

    public void render(){
        batch.begin();
        batch.draw(sprite, x, y, sprite.getWidth() / 4, sprite.getHeight() / 4);
        batch.end();
    }
}

package com.cultstoppers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by jose on 1/29/16.
 */
public class Player extends Entity{
    public Player(){
        x = 0;
        y = 0;
        health = 1;
        speed = 5;
        batch = new SpriteBatch();
        sprite = new Texture("badlogic.jpg");
    }
    public void move(){
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            y+=speed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            y-=speed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            x-=speed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            x += speed;
        }
    }
    public void render(){
        batch.begin();
        batch.draw(sprite, x, y);
        batch.end();
    }
}

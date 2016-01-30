package com.cultstoppers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

/**
 * Created by jose on 1/29/16.
 */
public class Player extends Entity{

    UserInterface ui;

    ArrayList<Weapon> bullets;

    public Player(){
        x = 0;
        y = 0;
        health = 8;
        speed = 5;
        batch = new SpriteBatch();
        sprite = new Texture("roshi.png");
        hitbox = new Rectangle(x,y,sprite.getWidth(),sprite.getHeight());

        ui = new UserInterface();

        bullets = new ArrayList<Weapon>();

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
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            bullets.add(new Shotgun(x,y));
        }
    }
    public void render(){
        for (int i = 0; i < bullets.size(); i++){
            bullets.get(i).update();
            if(bullets.get(i).isOutOfBounds()){
                bullets.remove(i);
            }

        }
        batch.begin();
        batch.draw(sprite, x, y);
        batch.end();
        ui.render();
    }

    public void updateHealth(int dmg) {

    }
}

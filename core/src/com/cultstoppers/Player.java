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

        ui = new UserInterface(health);


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
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            //bullets.add(new Shotgun(x, y, 'u'));
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            //bullets.add(new Shotgun(x, y, 'd'));
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            bullets.add(new Shotgun(x, y, 'l'));
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            bullets.add(new Shotgun(x, y, 'r'));
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.K)) {
            ui.hit();
        }
        checkWall();
    }
    public void render(){
        for (int i = 0; i < bullets.size(); i++){
            bullets.get(i).update();
            if(bullets.get(i).isOutOfBounds()){
                bullets.remove(i);
            }

        }
        batch.begin();
        batch.draw(sprite, x, y, sprite.getWidth()/4, sprite.getHeight()/4);
        batch.end();
        ui.render();
    }

    public void checkWall(){
        if((x > Gdx.graphics.getWidth() - sprite.getWidth()/4)){
            x = Gdx.graphics.getWidth() - sprite.getWidth()/4;
        }else if (x < 0){
            x = 0;
        }
        if(y > Gdx.graphics.getHeight() - sprite.getHeight()/4){
            y = Gdx.graphics.getHeight() - sprite.getHeight()/4;
        }else if (y < 0){
            y = 0;
        }
    }
    public void updateHealth(int dmg) {

    }
}

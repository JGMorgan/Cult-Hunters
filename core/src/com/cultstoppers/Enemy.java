package com.cultstoppers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jose on 1/29/16.
 */
public class Enemy extends Entity{
    public Enemy(int i){
        Random r = new Random();
        x = r.nextInt(Gdx.graphics.getWidth());
        y = r.nextInt(Gdx.graphics.getHeight());
        health = 1;
        speed = i%3+1;
        batch = new SpriteBatch();
        sprite = new Texture("megaman.png");
        hitbox = new Rectangle(x,y,sprite.getWidth(),sprite.getHeight());
    }
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

    public void move(Player p, ArrayList<Enemy> enemies,int i){
        int tempX =p.x - x;
        int tempY = p.y - y;

        for(int j=0; j < enemies.size(); j++){
//            if (enemies.get(j) != enemies.get(i)) {
//                if((x < (enemies.get(j).x + sprite.getWidth()) && (y < (enemies.get(j).y + sprite.getHeight()) || (y+sprite.getHeight()) > enemies.get(j).y)))
//                    x = enemies.get(j).x + (sprite.getWidth() + 1);
//                else if (((x+sprite.getWidth()) > enemies.get(j).x) && (y < (enemies.get(j).y + sprite.getHeight()) || y > enemies.get(j).y))
//                    x = x-2;
//                if((y < (enemies.get(j).y + sprite.getHeight()) && (x < (enemies.get(j).x + sprite.getWidth()) || (x+sprite.getWidth()) > enemies.get(j).x)))
//                    y = enemies.get(j).y + (sprite.getHeight() + 1);
//                else if (((y+sprite.getHeight()) > enemies.get(j).y) && (x < (enemies.get(j).x + sprite.getWidth()) || x > enemies.get(j).x))
//                    y = y-2;
//            }
        }
        if (tempX > 0) {
            x += speed;
        } else if (tempX < 0) {
            x -= speed;
        }
        if (tempY < 0) {
            y -= speed;
        } else if (tempY > 0) {
            y += speed;
        }
        checkWall();
    }

    public void render(){
        batch.begin();
        batch.draw(sprite, x, y, sprite.getWidth() / 4, sprite.getHeight() / 4);
        batch.end();
    }

    public boolean isDead(){
        return health <= 0;
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
}

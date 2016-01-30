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
    Random r;
    int random;
    public Enemy(int i){
        r = new Random();
        random = 0;
        x = r.nextInt(Gdx.graphics.getWidth());
        y = r.nextInt(Gdx.graphics.getHeight());
        health = 1;
        speed = i%3+1;
        batch = new SpriteBatch();
        stateTime = 0f;
        sprite = new Texture("megaman.png");
        hitbox = new Rectangle(x,y,sprite.getWidth()/4,sprite.getHeight()/4);
    }
    public Enemy(){
        r = new Random();
        random = 0;
        x = r.nextInt(Gdx.graphics.getWidth());
        y = r.nextInt(Gdx.graphics.getHeight());
        health = 1;
        speed = 2;
        stateTime = 1f;
        batch = new SpriteBatch();
        sprite = new Texture("megaman.png");
        hitbox = new Rectangle(x,y,sprite.getWidth()/4,sprite.getHeight()/4);
    }

    public void move(Player p, ArrayList<Enemy> enemies,int i){
        hitbox.setPosition(x,y);
        stateTime += Gdx.graphics.getDeltaTime();
        checkHit(p);
        int tempX =p.x - x;
        int tempY = p.y - y;

        for(int j=0; j < enemies.size(); j++){
            /**
             * Attempt to make enemies not collide with one another
             */
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
        if(speed == 3) {
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
        }else if(speed == 2 || speed == 1){

            if(Math.floor(stateTime)%2==0){
                random = r.nextInt(5);
                stateTime = 1f;
            }
            if(random==0){
                //x += speed;
            }else if(random==1){
                x -= speed;
            }else if(random==2){
                y -= speed;
            }else if(random==3){
                y += speed;
            }else if(random==4){
                x += speed;
            }
        }
        checkWall();
    }

    public void checkHit(Player p){
        for(int i = 0; i < p.bullets.size(); i++){
            if(p.bullets.get(i).hit(hitbox)){
                health--;
            }
        }

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

package com.cultstoppers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jose on 1/29/16.
 */
public class Enemy extends Entity{
    char dir;
    ArrayList<Weapon> bullets;
    Random r;
    int random;
    TextureRegion texture;

    float stateTime2;
    public Enemy(int i){
        r = new Random();
        random = 0;
        x = r.nextInt(Gdx.graphics.getWidth());
        y = r.nextInt(Gdx.graphics.getHeight());
        health = 1;
        speed = i%3+1;
        dir = 'u';
        batch = new SpriteBatch();
        bullets = new ArrayList<Weapon>();
        stateTime = 0f;
        stateTime2 = 0f;
        spritesheet = new Texture("Characters/Vampfrog_Sheet.png");
        hitbox = new Rectangle(x,y,spritesheet.getWidth()/4,spritesheet.getHeight()/2);
        walkFrames = TextureRegion.split(spritesheet, spritesheet.getWidth() / 2, spritesheet.getHeight());
        animUpLeft = new Animation(0.2f, walkFrames[0]);
    }
    public Enemy(){
        r = new Random();
        random = 0;
        x = r.nextInt(Gdx.graphics.getWidth());
        y = r.nextInt(Gdx.graphics.getHeight());
        health = 1;
        speed = 2;
        batch = new SpriteBatch();
        bullets = new ArrayList<Weapon>();
        stateTime = 0f;
        stateTime2 = 0f;
    }

    public void move(Player p){
        hitbox.setPosition(x,y);
        stateTime += Gdx.graphics.getDeltaTime();
        checkHit(p);
        int tempX =p.x - x;
        int tempY = p.y - y;

        stateTime2 += Gdx.graphics.getDeltaTime();

//        for(int j=0; j < enemies.size(); j++){
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
 //       }
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
            if(Math.abs(tempX) > Math.abs(tempY)) {
                if (tempX > 0)
                    dir='r';
                else
                    dir='l';
            } else {
                if (tempY < 0)
                    dir='d';
                else if (tempY > 0)
                    dir='u';
            }


        }else if(speed == 2 || speed == 1 || speed > 5) {
            if (Math.floor(stateTime) % 2 == 0) {
                random = r.nextInt(5);
                stateTime = 1f;
            }
            if (random == 0) {
                //x += speed;
            } else if (random == 1) {
                x -= speed;
                if(Math.abs(tempX) > Math.abs(tempY)) {
                    if (tempX > 0)
                        dir='r';
                    else
                        dir='l';
                } else {
                    if (tempY < 0)
                        dir='d';
                    else if (tempY > 0)
                        dir='u';
                }
            } else if (random == 2) {
                y -= speed;
                if(Math.abs(tempX) > Math.abs(tempY)) {
                    if (tempX > 0)
                        dir='r';
                    else
                        dir='l';
                } else {
                    if (tempY < 0)
                        dir='d';
                    else if (tempY > 0)
                        dir='u';
                }
            } else if (random == 3) {
                y += speed;
                if(Math.abs(tempX) > Math.abs(tempY)) {
                    if (tempX > 0)
                        dir='r';
                    else
                        dir='l';
                } else {
                    if (tempY < 0)
                        dir='d';
                    else if (tempY > 0)
                        dir='u';
                }
            } else if (random == 4) {
                x += speed;
                if(Math.abs(tempX) > Math.abs(tempY)) {
                    if (tempX > 0)
                        dir='r';
                    else
                        dir='l';
                } else {
                    if (tempY < 0)
                        dir='d';
                    else if (tempY > 0)
                        dir='u';
                }
            }
        }
        weaponChoice(speed, dir, stateTime2);
        checkWall();
    }

    public void checkHit(Player p){
        for(int i = 0; i < p.bullets.size(); i++){
            if(p.bullets.get(i).hit(hitbox)){
                health-=p.bullets.get(i).damage;
            }
        }

    }
    public void render(){
        texture = animUpLeft.getKeyFrame(stateTime, true);
        batch.begin();
        batch.draw(texture, x, y, texture.getRegionWidth() / 2, texture.getRegionHeight() / 2);
        batch.end();

    }

    public boolean isDead(){
        return health <= 0;
    }

    public void checkWall(){
        if((x > Gdx.graphics.getWidth() - spritesheet.getWidth()/4)){
            x = Gdx.graphics.getWidth() - spritesheet.getWidth()/4;
        }else if (x < 0){
            x = 0;
        }
        if(y > Gdx.graphics.getHeight() - spritesheet.getHeight()/2){
            y = Gdx.graphics.getHeight() - spritesheet.getHeight()/2;
        }else if (y < 0){
            y = 0;
        }
    }

    public void weaponChoice(int speed,char dir,float stateTime2) {
        if(stateTime2 > 1) {
            int random2 = r.nextInt(5);
            this.stateTime2 = 0f;
            if (speed >= 3) {
                if(random2%2==0) {
                    bullets.add(new Shotgun(x+spritesheet.getWidth()/8, y+spritesheet.getHeight()/4, dir, 'e'));
                }
            } else if (speed == 2) {
                if(random2%2==0) {
                    bullets.add(new Pistol(x+spritesheet.getWidth()/8, y+spritesheet.getHeight()/4, dir, 'e'));
                }
            } else if (speed == 1) {
                for(int i = 0; i < random2; i++){
                    bullets.add(new MachineGun(x+spritesheet.getWidth()/8, y+spritesheet.getHeight()/4,dir, 'e'));
                }
            }
        }
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).update();
            if (bullets.get(i).isOutOfBounds()) {
                bullets.remove(i);
            }

        }

    }
}

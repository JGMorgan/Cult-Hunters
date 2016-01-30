package com.cultstoppers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

/**
 * Created by jose on 1/30/16.
 */
public class MachineGun extends Weapon{
    int speed;
    Random r;
    int random;
    public MachineGun(int x, int y, char dir){
        r = new Random();
        random = r.nextInt(3);
        batch = new SpriteBatch();
        sprite = new Texture("bullet.png");
        speed = 10;
        damage = 1;
        this.dir = dir;
        this.x = x;
        this.y = y;
        hitbox = new Rectangle(this.x,this.y,sprite.getWidth(),sprite.getHeight());
    }

    @Override
    public void update() {
        hitbox.setPosition(x,y);
        if (dir == 'u'){
            y+=speed;
            if (random == 0){
                x-=Math.floor(Math.cos(((11*3.1415)/16)*speed));
            }else if (random == 1){
                x+=Math.floor(Math.cos(((11*3.1415)/16)*speed));
            }
        }else if (dir == 'd'){
            y-=speed;
            if (random == 0){
                x-=Math.floor(Math.cos(((11*3.1415)/16)*speed));
            }else if (random == 1){
                x+=Math.floor(Math.cos(((11*3.1415)/16)*speed));
            }
        }else if (dir == 'l'){
            x-=speed;
            if (random == 0){
                y-=Math.floor(Math.cos(((11*3.1415)/16)*speed));
            }else if (random == 1){
                y+=Math.floor(Math.cos(((11*3.1415)/16)*speed));
            }
        }else if (dir == 'r'){
            x+=speed;
            if (random == 0){
                y-=Math.floor(Math.cos(((11 * 3.1415) / 16) * speed));
            }else if (random == 1){
                y+=Math.floor(Math.cos(((11 * 3.1415) / 16) * speed));
            }
        }
        batch.begin();
        batch.draw(sprite, x, y);
        batch.end();
    }
}

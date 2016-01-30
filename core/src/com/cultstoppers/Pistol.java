package com.cultstoppers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by jose on 1/29/16.
 */
public class Pistol extends Weapon {
    int speed;
    public Pistol(int x, int y, char dir){
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
        x+=speed;
        batch.begin();
        batch.draw(sprite, x, y);
        batch.end();
    }
}

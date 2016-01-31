package com.cultstoppers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Leon on 1/31/2016.
 */
public class Altar extends Entity {

    public Altar(){
        batch=new SpriteBatch();
        sprite=new Texture("Ritualshrine.png");
        health=100;
        x = 0;
        y = 0;
        hitbox = new Rectangle(x,y,sprite.getWidth()/5,sprite.getHeight()/5);
    }
    public void render(){
        batch.begin();
        batch.draw(sprite, x, y, sprite.getWidth()/5, sprite.getHeight()/5);
        batch.end();
    }

    public void checkHit(Player p){
        hitbox.setPosition(x, y);
        for(int i = 0; i < p.bullets.size(); i++){
            if(p.bullets.get(i).hit(hitbox)){
                health-=p.bullets.get(i).damage;
                p.bullets.remove(i);
            }
        }

    }

    public boolean isDead(){
        return health <= 0;
    }

}

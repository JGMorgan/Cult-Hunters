package com.cultstoppers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by jose on 1/29/16.
 */
public abstract class Weapon {
    int x,y,initX,initY;
    char dir;
    int damage;
    Texture sprite;
    SpriteBatch batch;
    Rectangle hitbox;
    Rectangle hitbox2;
    Rectangle hitbox3;
    Rectangle hitbox4;
    Rectangle hitbox5;
    String WeaponType;
    public abstract void update();

    public boolean isOutOfBounds(){
        return (x > Gdx.graphics.getWidth() * 1.5) ||
                (x < -(Gdx.graphics.getWidth() * 1.5)) ||
                (y > Gdx.graphics.getHeight() * 1.5) ||
                (y < -(Gdx.graphics.getHeight() * 1.5));
    }

    public boolean hit(Rectangle hitbox){
        if((this.hitbox2 != null||this.hitbox3!= null||this.hitbox4!= null||this.hitbox5!= null)){
        if((hitbox.overlaps(this.hitbox)) || (hitbox.overlaps(this.hitbox2)) || (hitbox.overlaps(this.hitbox3)) || (hitbox.overlaps(this.hitbox4)) || (hitbox.overlaps(this.hitbox5))){
            return true;
        }else return false;
        }else if(hitbox.overlaps(this.hitbox)){
            return true;
        }
        else return false;
    }

}

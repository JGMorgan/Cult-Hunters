package com.cultstoppers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by jose on 1/29/16.
 */
public class Entity {
    int x,y,speed,health;
    Texture sprite;
    Texture spritesheet;
    TextureRegion[][] walkFrames;
    SpriteBatch batch;
    Rectangle hitbox;
    Animation animUpRight, animUpLeft, animDownLeft, animDownRight;
    float stateTime;
}

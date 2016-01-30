package com.cultstoppers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * Created by jose on 1/29/16.
 */
public class Player extends Entity{
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
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            x+=speed;
        }
    }
}

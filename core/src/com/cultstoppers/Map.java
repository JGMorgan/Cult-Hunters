package com.cultstoppers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by jose on 1/30/16.
 */
public class Map {
    Texture tilesheet;
    TextureRegion[] tiles;
    SpriteBatch batch;
    public Map(){

    }
    public void render(){
        batch.begin();
        //batch.draw(texture, x, y);
        batch.end();
    }
}

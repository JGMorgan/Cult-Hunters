package com.cultstoppers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Random;

/**
 * Created by jose on 1/30/16.
 */
public class Map {
    Texture tilesheet;
    TextureRegion[] tiles;
    SpriteBatch batch;
    Random r;
    public Map(){
        r = new Random();
        tilesheet = new Texture("GroundTileStripArray.png");
        TextureRegion tmp [][] = TextureRegion.split(tilesheet, tilesheet.getWidth()/7, 1);
        for(int i = 0; i < 7; i++){
            tiles[i]=tmp[i][0];
        }
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){

            }
        }
    }
    public void render(){
        batch.begin();
        for(int i = 0; i < tiles.length; i++) {
            batch.draw(tiles[i], ((i)+1),(i+1));
        }
        batch.end();
    }
}

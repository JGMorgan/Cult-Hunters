package com.cultstoppers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Random;

/**
 * Created by jose on 1/30/16.
 */
public class Map {
    Texture tilesheet;
    TextureRegion[][] tiles;
    SpriteBatch batch;
    Random r;
    public Map(){
        r = new Random();
        batch = new SpriteBatch();
        tiles = new TextureRegion [4][3];
        tilesheet = new Texture(Gdx.files.internal("Ground_Tiles/GroundTileStripArray.png"));
        TextureRegion tmp [][] = TextureRegion.split(tilesheet, tilesheet.getWidth()/7, tilesheet.getHeight());
        for(int i = 0; i < 4; i++){
            for (int j = 0; j < 3; j++){
                if(tiles[i][j]==null) {
                    int rand = r.nextInt(7);
                    tiles[i][j] = tmp[0][rand];
                    //if (rand == 0) {
                        //if(i==0){

                      //  }
                    //}
                }
            }
        }
    }
    public void render() {
        batch.begin();
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[i].length; j++){
                batch.draw(tiles[i][j], i * (Gdx.graphics.getWidth() / 4), j * (Gdx.graphics.getHeight() / 3), Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight()/3);
            }
        }
        batch.end();
    }
}

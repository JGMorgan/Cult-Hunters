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
        tilesheet = new Texture(("Ground_Tiles/GroundTileStripArray.png"));
        TextureRegion tmp [][] = TextureRegion.split(tilesheet, tilesheet.getWidth()/7, tilesheet.getHeight());
        int rand1 = r.nextInt(4);
        int rand2 = r.nextInt(3);
        tiles[rand1][rand2] = tmp[0][0];
        if (rand1 != 0) {//LT
            tiles[rand1 - 1][rand2] = tmp[0][2];
        }
        if (rand1 != 3) {//RT
            tiles[rand1 + 1][rand2] = tmp[0][4];
        }
        if (rand2 != 0) {//DT
            tiles[rand1][rand2 - 1] = tmp[0][1];
        }
        if (rand2 != 2) {//UT
            tiles[rand1][rand2 + 1] = tmp[0][3];
        }
        for(int i = 0; i < 4; i++){
            for (int j = 0; j < 3; j++){
                if(tiles[i][j]==null) {
                    int rand = r.nextInt(2)+5;
                    tiles[i][j] = tmp[0][rand];
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

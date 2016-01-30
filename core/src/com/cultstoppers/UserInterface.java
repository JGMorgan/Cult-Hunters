package com.cultstoppers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import java.util.ArrayList;
/**
 * Created by andresmoser on 1/29/16.
 */
public class UserInterface{
    int healthX, healthY, numHealth = 5, roomName, roomNum;
    Texture healthIcon = new Texture("heart.png");
    SpriteBatch batch = new SpriteBatch();
    ArrayList<Texture> healthBar = new ArrayList<>();


    public UserInterface(){
        healthX = Gdx.graphics.getWidth() / 30;
        healthY = Gdx.graphics.getHeight() - 50;
        for(int i = 0; i < numHealth; i++)
            healthBar.add(healthIcon);

    }

    public void render() {
        batch.begin();
        for(int i = 0; i < numHealth; i++)
            batch.draw(healthBar.get(i), (healthX*(i+1)), healthY);
        batch.end();
    }
}

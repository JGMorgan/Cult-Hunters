package com.cultstoppers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import java.util.ArrayList;
/**
 * Created by andresmoser on 1/29/16.
 */
public class UserInterface{
    int healthX, healthY, numHealth, roomName, roomNum, weaponX,weaponY;
    Texture healthIcon = new Texture("heart.png");
    SpriteBatch batch = new SpriteBatch();
    ArrayList<Texture> healthBar = new ArrayList<Texture>();
    Texture shotgunTexture = new Texture("Shotgun.png");
    Texture swordTexture = new Texture("swords.png");
    Texture machineTexture = new Texture("machine.png");
    Texture pistolTexture = new Texture("gun.png");
    Texture weaponTexture=new Texture("blank.png");
    Weapon playerWeapon;

    public UserInterface(int health){
        numHealth = health;
        healthX = Gdx.graphics.getWidth() / 30;
        healthY = Gdx.graphics.getHeight() - 50;
        weaponX = Gdx.graphics.getWidth() / 40;
        weaponY = Gdx.graphics.getHeight() - 60 - healthX;
        for(int i = 0; i < numHealth; i++) {
            healthBar.add(healthIcon);

        }
    }

    public void render() {
        batch.begin();
        for(int i = 0; i < numHealth; i++)
            batch.draw(healthBar.get(i), (healthX*(i+1)), healthY);
        batch.end();
        batch.begin();
            batch.draw(weaponTexture,weaponX,weaponY);
        batch.end();
    }

    public void hit(){
        healthBar.remove(healthBar.size()-1);
        numHealth--;
    }
}

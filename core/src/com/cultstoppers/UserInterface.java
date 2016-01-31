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
    Texture healthIcon = new Texture("UI/Heart-01.png");
    SpriteBatch batch = new SpriteBatch();
    ArrayList<Texture> healthBar = new ArrayList<Texture>();
    Texture shotgunTexture = new Texture("Fire_Bullet Triple.png");
    Texture swordTexture = new Texture("ScratchAction.png");
    Texture machineTexture = new Texture("Long_FireBulletSingle.png");
    Texture pistolTexture = new Texture("FireBulletSingle.png");
    Texture weaponTexture=new Texture("blank.png");
    Weapon playerWeapon;

    public UserInterface(int health){
        numHealth = health;
        healthX = Gdx.graphics.getWidth() / 30;
        healthY = Gdx.graphics.getHeight() - 50;
        weaponX = Gdx.graphics.getWidth() / 40;
        weaponY = Gdx.graphics.getHeight() - 70 - healthX;
        for(int i = 0; i < numHealth; i++) {
            healthBar.add(healthIcon);

        }
    }

    public void render() {
        batch.begin();
        for(int i = 0; i < numHealth; i++)
            batch.draw(healthBar.get(i), (healthX*(i+1)), healthY, healthIcon.getWidth()/20,healthIcon.getHeight()/20);
        batch.end();
        batch.begin();
            batch.draw(weaponTexture, weaponX, weaponY,machineTexture.getWidth()/6, machineTexture.getHeight()/2);
        batch.end();
    }

    public void hit(int health){
        if(health<0){return;}
        for(int i = 1; i <= numHealth - health; i++){
            healthBar.remove(healthBar.size()-1);
        }

        this.numHealth = health;
    }
}

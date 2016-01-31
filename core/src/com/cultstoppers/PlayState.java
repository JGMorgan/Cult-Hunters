package com.cultstoppers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Created by jose on 1/30/16.
 */
public class PlayState extends State{
    Player p;
    Map m;
    ArrayList<Enemy> enemies;
    boolean pause = false;
    Music music;
    Texture vignette;
    SpriteBatch batch;
    public PlayState(){
        p = new Player();
        m = new Map();
        enemies = new ArrayList<Enemy>();
        for(int i = 0; i < 5; i++){
            enemies.add(new Enemy(i));
        }
        music = Gdx.audio.newMusic(Gdx.files.internal("audio/ggjbattle.mp3"));
        vignette = new Texture("Vignette.png");
        music.play();
        music.setVolume(.5f);
        music.setLooping(true);
        batch = new SpriteBatch();
    }

    public void render() {

        if (pause) {
            music.pause();
        } else {
            m.render();
            for (int i = 0; i < enemies.size(); i++) {
                enemies.get(i).render();
                enemies.get(i).move(p, enemies, i);
                if (enemies.get(i).isDead()) {
                    enemies.remove(i);
                }

            }
        }

        p.move();
        p.render();
        batch.begin();
        batch.draw(vignette, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
        }
    }

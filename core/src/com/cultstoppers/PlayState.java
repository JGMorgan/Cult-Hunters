package com.cultstoppers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

import java.util.ArrayList;

/**
 * Created by jose on 1/30/16.
 */
public class PlayState extends State{
    Player p;
    ArrayList<Enemy> enemies;
    boolean pause = false;
    Music music;
    public PlayState(){
        p = new Player();
        enemies = new ArrayList<Enemy>();
        for(int i = 0; i < 5; i++){
            enemies.add(new Enemy(i));
        }
        music = Gdx.audio.newMusic(Gdx.files.internal("audio/ggjbattle.mp3"));

        music.play();
        music.setVolume(.5f);
        music.setLooping(true);
    }
    public void render(){
        if(pause) {
            music.pause();
        } else {
            for (int i = 0; i < enemies.size(); i++) {
                enemies.get(i).render();
                enemies.get(i).move(p, enemies, i);
                if (enemies.get(i).isDead()) {
                    enemies.remove(i);
                }
            }
            p.move();
            p.render();
        }

    }
}

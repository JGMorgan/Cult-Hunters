package com.cultstoppers;

import java.util.ArrayList;

/**
 * Created by jose on 1/30/16.
 */
public class PlayState extends State{
    Player p;
    ArrayList<Enemy> enemies;
    public PlayState(){
        p = new Player();
        enemies = new ArrayList<Enemy>();
        for(int i = 0; i < 5; i++){
            enemies.add(new Enemy(i));
        }
    }
    public void render(){
        for(int i = 0; i < enemies.size(); i++){
            enemies.get(i).render();
            enemies.get(i).move(p, enemies,i);
            if(enemies.get(i).isDead()){
                enemies.remove(i);
            }
        }
        p.move();
        p.render();
    }
}

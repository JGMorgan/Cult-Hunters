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
            enemies.add(new Enemy());
        }
    }
    public void render(){
        for(Enemy e : enemies){
            e.render();
            e.move(p);
        }
        p.move();
        p.render();
    }
}

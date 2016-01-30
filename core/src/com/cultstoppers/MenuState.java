package com.cultstoppers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by jose on 1/30/16.
 */
public class MenuState extends State {

    Texture menu;
    SpriteBatch batch;
    boolean play;
    boolean confirm;//when character is confirmed change play state

    public MenuState(){
        play = false;
        confirm = false;
    }

    public void render() {
        if(play){
            //if play or start button is hit then switch to character select screen
        }
    }

    public boolean startGame(){
        return confirm;//character confirmed so change state
    }

}

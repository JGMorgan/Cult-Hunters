package com.cultstoppers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
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
        menu = new Texture("TitleScreen.png");
        batch = new SpriteBatch();
        music = Gdx.audio.newMusic(Gdx.files.internal("audio/ggjtitle.mp3"));
        music.play();
        music.setVolume(.5f);
        music.setLooping(true);
    }

    public void render() {
        mainMenuInput();
        batch.begin();
        batch.draw(menu, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
        if(play){
            //if play or start button is hit then switch to character select screen
        }
    }

    public void mainMenuInput(){
        if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){
            play = true;
            confirm = true;
        }
    }
    public boolean changeState(){
        return confirm;//character confirmed so change state
    }

}

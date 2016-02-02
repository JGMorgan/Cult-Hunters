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

    float stateTime;
    Texture menu;
    SpriteBatch batch;
    boolean play;
    boolean confirm;//when character is confirmed change play state
    boolean ready;
    public MenuState(){
        play = false;
        confirm = false;
        ready = false;
        menu = new Texture(Gdx.files.internal("TitleScreen.png"));
        batch = new SpriteBatch();
        music = Gdx.audio.newMusic(Gdx.files.internal("audio/ggjtitle.mp3"));
        music.play();
        music.setVolume(.5f);
        music.setLooping(true);
    }

    public void render() {
        if(play){
            if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){
                confirm = true;
                stateTime = 0f;
                menu = new Texture("UI/Howto.png");
                play = false;

            }
            batch.begin();
            batch.draw(menu, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            batch.end();
        }else if(confirm && stateTime <= 3) {
            stateTime+=Gdx.graphics.getDeltaTime();
            batch.begin();
            batch.draw(menu, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            batch.end();
        }else if(stateTime>3){
            ready = true;
        }else {
            if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){
                play = true;
                stateTime = 0f;
                menu = new Texture("UI/CharacterSelection-01.png");
            }
            batch.begin();
            batch.draw(menu, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            batch.end();
        }

    }

    public boolean changeState(){
        return ready;//character confirmed so change state
    }

}

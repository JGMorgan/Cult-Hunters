package com.cultstoppers;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {
	State state;
	char stateType;
    SpriteBatch batch;
    Texture texture;
    boolean credits;
	@Override
	public void create () {
        state = new MenuState();
		stateType = 'm';
        batch = new SpriteBatch();
        texture = new Texture("UI/CreditsPage.png");
        credits = true;

    }

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(state.changeState()){

			if(stateType == 'm'){
                state.music.dispose();
				state = new PlayState();
                stateType = 'p';
			}else {
                if (credits) {
                    if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
                        credits = false;
                    }
                    batch.begin();
                    batch.draw(texture,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
                    batch.end();
                }else {
                    state.music.dispose();
                    state = new MenuState();
                    stateType = 'm';
                }
			}
		}
		if(state.changeState()){
            if (credits) {
                if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
                    credits = false;
                }
                batch.begin();
                batch.draw(texture,0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
                batch.end();
            }else {
                state.music.dispose();
                state = new MenuState();
                stateType = 'm';
            }
		}else
        state.render();
	}

}

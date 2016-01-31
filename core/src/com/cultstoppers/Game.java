package com.cultstoppers;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {
	State state;
	char stateType;
	@Override
	public void create () {
        state = new MenuState();
		stateType = 'm';
    }

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(state.changeState()){
			if(stateType == 'm'){
				state = new PlayState();
                stateType = 'p';
			}else {
				state = new MenuState();
                stateType = 'm';
			}
		}
        state.render();
	}

}

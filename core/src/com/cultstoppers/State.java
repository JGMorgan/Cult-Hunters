package com.cultstoppers;

import com.badlogic.gdx.audio.Music;

/**
 * Created by jose on 1/30/16.
 */
public abstract class State {
    Music music;
    public abstract void render();
    public abstract boolean changeState();
}
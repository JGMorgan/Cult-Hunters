package com.cultstoppers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jose on 1/30/16.
 */
public class PlayState extends State{
    Random altarGen=new Random();
    Boss boss;
    Altar altar;
    Player p;
    int bossCount = 0;
    Map m;
    ArrayList<Enemy> enemies;
    boolean pause = false;
    Texture vignette;
    SpriteBatch batch;
    private BitmapFont font;
    int mapCount=0;

        public PlayState(){
            p = new Player();
            font = new BitmapFont();
            m = new Map();
            boss = new Boss();
            enemies = new ArrayList<Enemy>();
            for(int i = 0; i < 5; i++){
                enemies.add(new Enemy(i));
            }
            music = Gdx.audio.newMusic(Gdx.files.internal("audio/ggjbattle.mp3"));
            music.setVolume(.5f);
            music.setLooping(true);
            music.play();
            bossMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/ggjboss.mp3"));
            bossMusic.setVolume(.5f);
            bossMusic.setLooping(true);
            vignette = new Texture("Vignette.png");
            batch = new SpriteBatch();
        }

        public void render() {


            if (pause) {
                music.pause();
            } else {
                m.render();
                for (int i = 0; i < enemies.size(); i++) {
                    p.checkHit(enemies.get(i));
                    enemies.get(i).render();
                    enemies.get(i).move(p);
                    if (enemies.get(i).isDead()) {
                        enemies.remove(i);
                    }
                }

            }
            p.checkHit(boss);
            p.move();
            p.render();
            if(mapCount==4){
                if(altar !=null) {
                    music.pause();
                    bossMusic.play();
                    altar.render();
                    boss.render();
                    boss.move(p);
                    altar.checkHit(p);
                    if (altar.isDead()) {
                        altar = null;
                        mapCount=0;
                        bossCount++;
                    }
                }

            }
            batch.begin();
            font.setColor(1,1,1,1);
            batch.draw(vignette, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            font.draw(batch, "Boss kill count: " + bossCount, Gdx.graphics.getWidth() * 0.9f, Gdx.graphics.getHeight() - 5);

            batch.end();
            p.renderUI();
            if ((enemies.size() == 0 && altar == null) && ((p.x + p.texture.getRegionWidth()/2) >= (Gdx.graphics.getWidth()) || ((p.y + p.texture.getRegionHeight()/2) >= (Gdx.graphics.getHeight())))) {
                if ((p.x + p.texture.getRegionWidth()/2) >= (Gdx.graphics.getWidth())){
                    p.x = 0;
                }else{
                    p.y = 0;
                }
                mapCount=mapCount+1;
                mapFinish();

                if(mapCount%4==0){
                    int altarCorner;
                    altarCorner=altarGen.nextInt(4)+1;
                    enemies.add(boss);

                    altar = new Altar();
                    switch(altarCorner){
                        case 1:altar.y=400;
                            altar.x=225;
                            boss.y = 250;
                            boss.x = 75;
                            break;
                        case 2:altar.y=350;
                            altar.x=225;
                            boss.y = 200;
                            boss.x = 75;
                            break;
                        case 3:altar.x=700;
                            altar.y=250;
                            boss.y = 100;
                            boss.x = 450;
                            break;
                        case 4:altar.x=400;
                            altar.y=250;
                            boss.y = 100;
                            boss.x = 250;
                            break;
                    }
                    //mapCount=0;
                } else {
                    if(bossMusic.isPlaying()){
                        bossMusic.dispose();
                        music.play();
                    }
                }
            }
        }
        @Override
        public boolean changeState() {
            if(p.health<=0){
                return true;
            }else return false;
        }

        public void mapFinish(){



            m=new Map();
            for(int i = 0; i < 5; i++){
                enemies.add(new Enemy(i));
            }

        }

    }


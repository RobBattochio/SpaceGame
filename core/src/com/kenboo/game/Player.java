package com.kenboo.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;

/**
 * Created by kenbo on 1/28/2017.
 */


public class Player extends Actor {
    Sprite sprite;
    Texture texture;
    //store the parent stage to access it
    Stage stage;


    public Player(Stage stage){
        texture = new Texture(Gdx.files.internal("spaceship.png"));
        sprite = new Sprite(texture);
        sprite.setOrigin(sprite.getWidth()/2,sprite.getHeight()/2);

        setTouchable(Touchable.enabled);

        setBounds(0,0,sprite.getWidth(),sprite.getHeight());
        this.stage = stage;
        addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
    }
    @Override
    public void draw(Batch batch, float parentAlpha){
        sprite.draw(batch);
    }

    public void act(float delta){

    }

    public void handleControls(float mouseX, float mouseY){
        float rotation = MathUtils.atan2(mouseY - sprite.getOriginY(),mouseX -sprite.getOriginX())*MathUtils.radiansToDegrees;
        sprite.setRotation(rotation);

    }


}

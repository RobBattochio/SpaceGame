package com.kenboo.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by kenbo on 1/28/2017.
 */

public class MainStage extends Stage {
    Vector3 touchVector;

    //have the player variable easy to access
    Player player;

    public MainStage(Viewport vport){
        super(vport);
        player = new Player(this);
        addActor(player);

        touchVector = new Vector3();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        getCamera().unproject(touchVector.set(screenX,screenY,0));

        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        getCamera().unproject(touchVector.set(screenX,screenY,0));
        player.handleControls(touchVector.x, touchVector.y);
        return super.touchDragged(screenX, screenY, pointer);
    }

    //This function moves the camera so it is centered with the space ship
    public void moveCamera(){
        getCamera().position.set(getActors().first().getOriginX(),getActors().first().getOriginY(),0);

    }

}

package com.kenboo.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class MainGame extends ApplicationAdapter {


	MainStage mainStage;
	@Override
	public void create () {
        //set the stage to be the input processor

		mainStage = new MainStage(new FitViewport(1920,1080));
        Gdx.input.setInputProcessor(mainStage);


        }

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mainStage.moveCamera();
        mainStage.act();
		mainStage.draw();
	}
	
	@Override
	public void dispose () {

	}

}

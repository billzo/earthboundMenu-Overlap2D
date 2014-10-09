package com.killercerealgames.menuTest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class EarthboundMenu_Overlap2D extends ApplicationAdapter {
	
	private GameStage stage;
	
	@Override
	public void create () {
		
		stage = new GameStage();
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		
	}
	
	public void dispose() {
		stage.dispose();
	}
	
}

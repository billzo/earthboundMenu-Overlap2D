package com.killercerealgames.menuTest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.uwsoft.editor.renderer.SceneLoader;
import com.uwsoft.editor.renderer.resources.ResourceManager;

public class GameStage extends Stage {

	private ResourceManager resourceManager;
	private MenuScreenScript menuScript;
	
	public GameStage() {
		super();
		Gdx.input.setInputProcessor(this);
		
		resourceManager = new ResourceManager();
			
		resourceManager.initAllResources();
		
		initMenu();
		
	}
	
	private void initMenu() {
		clear();
		
		SceneLoader menuLoader = new SceneLoader(resourceManager);
		
		menuLoader.loadScene("MainScene");
		
		menuScript = new MenuScreenScript(this);
		
		menuLoader.sceneActor.addScript(menuScript);
		
		addActor(menuLoader.sceneActor);
		
	}
	
	public void dispose() {
		menuScript.dispose();
	}
	
}









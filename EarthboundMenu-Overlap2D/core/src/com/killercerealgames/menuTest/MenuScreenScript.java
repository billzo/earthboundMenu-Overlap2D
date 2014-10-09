package com.killercerealgames.menuTest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.uwsoft.editor.renderer.actor.CompositeItem;
import com.uwsoft.editor.renderer.actor.ImageItem;
import com.uwsoft.editor.renderer.script.IScript;

public class MenuScreenScript implements IScript{

	public ImageItem pointer;
	
	private CompositeItem menu;
	
	private Menu currentMenu;
	private Menu fileSelectMenu;
	private Menu speedSelectMenu;
	private Menu soundSelectMenu;
	private Menu flavorSelectMenu;
	
	private Long lastTime;
	
	private Music music;
	private Sound sound1;
	private Sound sound2;
	private Sound click;
	
	public MenuScreenScript(GameStage gameStage) {
	}
	
	@Override
	public void init(CompositeItem item) {
		menu = item;
		
		
		lastTime = System.currentTimeMillis();
		
		music = Gdx.audio.newMusic(Gdx.files.internal("Select_a_File.mp3"));
		music.play();
		music.setVolume(0.55f);
		sound1 = Gdx.audio.newSound(Gdx.files.internal("curshoriz.wav"));
		sound2 = Gdx.audio.newSound(Gdx.files.internal("cursverti.wav"));
		click = Gdx.audio.newSound(Gdx.files.internal("click.wav"));
		
		
		fileSelectMenu = new Menu(menu.getCompositeById("fileSelectMenu"), 3, "file");
		currentMenu = fileSelectMenu;
		
		speedSelectMenu = new Menu(menu.getCompositeById("speedSelectMenu"), 3, "speed");
		speedSelectMenu.setVisible(false);
		soundSelectMenu = new Menu(menu.getCompositeById("soundSelectMenu"), 2, "sound");
		soundSelectMenu.setVisible(false);
		flavorSelectMenu = new Menu(menu.getCompositeById("flavorSelectMenu"), 5, "flavor");
		flavorSelectMenu.setVisible(false);

		pointer = fileSelectMenu.getMenuPointer();
		pointer.scaleBy(0.15f);

	}

	@Override
	public void dispose() {
		music.dispose();
		sound1.dispose();
		sound2.dispose();
		click.dispose();
		
	}

	@Override
	public void act(float delta) {
		
		if (System.currentTimeMillis() > lastTime + 200) {
			resizePointer();
			lastTime = System.currentTimeMillis();
		}
	
		if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {
			click.play(0.5f);
			currentMenu.movePointer("DOWN");
		}
		else if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
			click.play(0.5f);
			currentMenu.movePointer("UP");
		}
		else if (Gdx.input.isKeyJustPressed(Input.Keys.A) || Gdx.input.isKeyJustPressed(Input.Keys.D)) {
			sound2.play(-0.75f);
		}
		else if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
			sound2.play(0.5f);
			changeMenuForward();		
		}
		else if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
			sound1.play();
			changeMenuBackward();
		}
		
	}
	
	private void changeMenuForward() {
		if (currentMenu.equals(fileSelectMenu)) {
			currentMenu.selectItem();
			currentMenu = speedSelectMenu;
			enactVisualChangesInMenuFoward();
		}
		else if (currentMenu.equals(speedSelectMenu)) {
			currentMenu.selectItem();
			currentMenu = soundSelectMenu;
			enactVisualChangesInMenuFoward();
		}
		else if (currentMenu.equals(soundSelectMenu)) {
			currentMenu.selectItem();
			currentMenu = flavorSelectMenu;
			enactVisualChangesInMenuFoward();
		}
		
	}
	
	private void changeMenuBackward() {
		if (currentMenu.equals(speedSelectMenu)) {
			hideCurrentMenu();
			currentMenu = fileSelectMenu;
			currentMenu.deselectItem();
			getPreviousMenuFocus();
		}
		else if (currentMenu.equals(soundSelectMenu)) {
			hideCurrentMenu();
			currentMenu = speedSelectMenu;
			currentMenu.deselectItem();
			getPreviousMenuFocus();
		}
		else if (currentMenu.equals(flavorSelectMenu)) {
			hideCurrentMenu();
			currentMenu = soundSelectMenu;
			currentMenu.deselectItem();
			getPreviousMenuFocus();
		}
	}

	private void resizePointer() {
		if (pointer.getScaleX() <= 0.65) {
			pointer.scaleBy(0.50f);
			pointer.setPosition(pointer.getX() - 3, pointer.getY() - 2);
		} else {
			pointer.scaleBy(-0.50f);
			pointer.setPosition(pointer.getX() + 3, pointer.getY() + 2);
		}
	}
	
	private void enactVisualChangesInMenuFoward() {
		pointer.setVisible(false);
		currentMenu.setVisible(true);
		pointer = currentMenu.getMenuPointer();
		pointer.setVisible(true);
	}
	private void hideCurrentMenu() {
		pointer.setVisible(false);
		currentMenu.setVisible(false);
	}
	private void getPreviousMenuFocus() {
		pointer = currentMenu.getMenuPointer();
		pointer.setVisible(true);
	}
	
	
}

package com.killercerealgames.menuTest;

import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.uwsoft.editor.renderer.actor.CompositeItem;
import com.uwsoft.editor.renderer.actor.ImageItem;

public class Menu {

	private ArrayList<Label> labels;
	private CompositeItem menuItem;
	private ImageItem pointer;
	private int numberOfSelectAbleItems;
	private String name;
	private int currentlySelectedItem = 0;
	private ImageItem rectangle;
	
	public Menu(CompositeItem menuItem, int numberOfSelectAbleItems, String name) {
		this.menuItem = menuItem;
		labels  = new ArrayList<Label>();
		this.numberOfSelectAbleItems = numberOfSelectAbleItems;
		this.name = name;
		for (int i = 0; i < numberOfSelectAbleItems; i++) {
			labels.add(menuItem.getLabelById(this.name + (i + 1)));
		}
		pointer = menuItem.getImageById("pointer");
		rectangle = menuItem.getImageById("rectangle");
		rectangle.setVisible(false);
	}
	
	public void setVisible(boolean visible) {
		menuItem.setVisible(visible);
	}
	
	public ImageItem getMenuPointer() {
		return pointer;
	}
	
	public void movePointer(String direction) {
		if (direction.equals("UP")) {
			if (currentlySelectedItem == 0) {
				System.out.println(currentlySelectedItem);
			}
			else {
				currentlySelectedItem--;
				pointer.setPosition(pointer.getX(), labels.get(currentlySelectedItem).getY() + pointer.getHeight() / 2);
			}
		}
		else if (direction.equals("DOWN")) {
			if (currentlySelectedItem == numberOfSelectAbleItems - 1) {
			}
			else {
				currentlySelectedItem++;
				pointer.setPosition(pointer.getX(), labels.get(currentlySelectedItem).getY() + pointer.getHeight() / 2);
			}
		}
		
	}
	
	public void selectItem() {
		rectangle.setPosition(rectangle.getX(), labels.get(currentlySelectedItem).getY());
		rectangle.setVisible(true);
	}
	public void deselectItem() {
		rectangle.setVisible(false);
	}
	
}

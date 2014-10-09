package com.killercerealgames.menuTest.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.killercerealgames.menuTest.EarthboundMenu_Overlap2D;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 520;
		config.height = 500;
		new LwjglApplication(new EarthboundMenu_Overlap2D(), config);
	}
}

package com.hypermodel.games.engine.generator;

public interface GameProperties {
	public enum ProjectType {
		core,
		android,
		desktop,
		html,
		ios,
		iosmoe;
	} 
	public static final String launcherPostfix = "Launcher";
}

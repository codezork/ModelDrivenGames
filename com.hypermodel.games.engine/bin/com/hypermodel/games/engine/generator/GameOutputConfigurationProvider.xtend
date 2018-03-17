package com.hypermodel.games.engine.generator

import org.eclipse.xtext.generator.IOutputConfigurationProvider
import org.eclipse.xtext.generator.OutputConfiguration

class GameOutputConfigurationProvider implements IOutputConfigurationProvider {
	public static final String CORE = "core";
	override getOutputConfigurations() {
		var defaultOutput = new OutputConfiguration(CORE)
		defaultOutput.description = "Output Folder"
		defaultOutput.outputDirectory = "core"
		defaultOutput.overrideExistingResources= true
		defaultOutput.createOutputDirectory = true
		defaultOutput.cleanUpDerivedResources = true
		defaultOutput.setDerivedProperty = true
		return newHashSet(defaultOutput);
	}
}

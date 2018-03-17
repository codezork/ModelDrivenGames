package com.hypermodel.games.engine.generator;

import java.util.Set;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class GameOutputConfigurationProvider implements IOutputConfigurationProvider {
  public final static String CORE = "core";
  
  @Override
  public Set<OutputConfiguration> getOutputConfigurations() {
    OutputConfiguration defaultOutput = new OutputConfiguration(GameOutputConfigurationProvider.CORE);
    defaultOutput.setDescription("Output Folder");
    defaultOutput.setOutputDirectory("core");
    defaultOutput.setOverrideExistingResources(true);
    defaultOutput.setCreateOutputDirectory(true);
    defaultOutput.setCleanUpDerivedResources(true);
    defaultOutput.setSetDerivedProperty(true);
    return CollectionLiterals.<OutputConfiguration>newHashSet(defaultOutput);
  }
}

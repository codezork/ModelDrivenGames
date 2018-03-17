package com.hypermodel.games.engine.generator;

import javax.inject.Inject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.jvmmodel.JvmAnnotationReferenceBuilder;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class ExtendedJvmModelGenerator extends JvmModelGenerator {
  @Inject
  private JvmAnnotationReferenceBuilder.Factory annotationRefBuilderFactory;
  
  @Inject
  private JvmTypeReferenceBuilder.Factory typeRefBuilderFactory;
  
  @Extension
  protected JvmAnnotationReferenceBuilder _annotationTypesBuilder;
  
  @Extension
  protected JvmTypeReferenceBuilder _typeReferenceBuilder;
  
  public void setBuilder(final Resource resource) {
    this._annotationTypesBuilder = this.annotationRefBuilderFactory.create(resource.getResourceSet());
    this._typeReferenceBuilder = this.typeRefBuilderFactory.create(resource.getResourceSet());
  }
}

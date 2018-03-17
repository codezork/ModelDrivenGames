package com.hypermodel.games.engine.generator

import javax.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.eclipse.xtext.xbase.jvmmodel.JvmAnnotationReferenceBuilder
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder

class ExtendedJvmModelGenerator extends JvmModelGenerator {
	@Inject JvmAnnotationReferenceBuilder.Factory annotationRefBuilderFactory;
	@Inject JvmTypeReferenceBuilder.Factory typeRefBuilderFactory;
	
	@Extension protected JvmAnnotationReferenceBuilder _annotationTypesBuilder;
	@Extension protected JvmTypeReferenceBuilder _typeReferenceBuilder;
	
	def void setBuilder(Resource resource) {
			_annotationTypesBuilder = annotationRefBuilderFactory.create(resource.getResourceSet());
			_typeReferenceBuilder = typeRefBuilderFactory.create(resource.getResourceSet());
	}
		
}
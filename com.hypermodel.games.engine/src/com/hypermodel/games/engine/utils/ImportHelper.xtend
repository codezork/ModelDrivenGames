package com.hypermodel.games.engine.utils

import java.util.HashSet
import java.util.TreeSet
import javax.inject.Inject
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.MultiStatus
import org.eclipse.core.runtime.Status
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder

/**
 * <b>For the complete to-do-list support keyword information DSL editors <code>org.eclipse.osbp.xtext.basic.ui.BasicDSLUiModuleHelper</code></b>
 * <hr>
 * <ul>Import any required classes inside <code>{your-dsl-bundle}.generator.{your}DSLGenerator.createAppendable()</code> via <code>org.eclipse.osbp.xtext.basic.generator.BasicDslGeneratorUtils.addImportFor()</code>
 * <li>add the <code>BasicDslGrammarUtils</code> extension to <code>{your-dsl-bundle}.generator.{your}DSLGenerator</code>
 * <pre>
 * 	@Inject extension BasicDslGeneratorUtils
 * </pre>
 * </li>
 * <li>replace the sum of all calls of <code>addImportFor()</code>
 * <pre>
 * override createAppendable(EObject context, ImportManager importManager, GeneratorConfig config) {
 *     importManager.addImportFor(context.newTypeRef(typeof(ClassOne)).type)
 *     importManager.addImportFor(context.newTypeRef(typeof(ClassTwo)).type)
 *     [...etc...]
 *     super.createAppendable(context, importManager, config)
 * }
 * </pre>
 * with a <b>single call</b>
 * <pre>
 * override createAppendable(EObject context, ImportManager importManager, GeneratorConfig config) {
 *     addImportFor(importManager, _typeReferenceBuilder
 *         , ClassOne
 *         , ClassTwo
 *         [...etc...])
 *     super.createAppendable(context, importManager, config)
 * }
 * </pre>
 * </ul>
 */
class ImportHelper {
	def boolean addClasses(JvmModelGenerator modelGenerator, ImportManager importManager, JvmTypeReferenceBuilder typeReferenceBuilder, Object... classesToImport) {
		val CODE = IStatus.ERROR
		val PLUGINID = modelGenerator.class.canonicalName
		val MESSAGE = " could not be resolved. Add as required bundle or import package to MANIFEST.MF."
		var errors = new HashSet<IStatus>
		var classes = new TreeSet
		for (classToImport : classesToImport) {
			var className = null as String
			try {
				val tokens = ('''«classToImport»''').toString.split(" ")
				className = tokens.get(tokens.length-1)
				var jvmType = null as JvmType
				if	(typeReferenceBuilder !== null) {
					switch classToImport {
						Class<?>: {
							jvmType = typeReferenceBuilder.typeRef(classToImport).type
						}
						String: {
							jvmType = typeReferenceBuilder.typeRef(classToImport).type
						}
					}
				}
		        importManager.addImportFor(jvmType)
			}
			catch (NullPointerException npe) {
				classes.add(className)
				errors.add(new Status(CODE, PLUGINID, '''«classToImport» «MESSAGE»''', npe))
			}
			catch (Exception e) {
				classes.add(className)
				errors.add(new Status(CODE, PLUGINID, e.localizedMessage, e))
			}
		}
		if	(!errors.empty) {
			throw new CoreException(new MultiStatus(PLUGINID, CODE, errors, '''«classes.join(",\n")» «MESSAGE»''', null))
		}
		return true
    }
}

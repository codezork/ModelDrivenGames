package com.hypermodel.games.engine.utils;

import java.util.HashSet;
import java.util.TreeSet;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

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
@SuppressWarnings("all")
public class ImportHelper {
  public boolean addClasses(final JvmModelGenerator modelGenerator, final ImportManager importManager, final JvmTypeReferenceBuilder typeReferenceBuilder, final Object... classesToImport) {
    try {
      final int CODE = IStatus.ERROR;
      final String PLUGINID = modelGenerator.getClass().getCanonicalName();
      final String MESSAGE = " could not be resolved. Add as required bundle or import package to MANIFEST.MF.";
      HashSet<IStatus> errors = new HashSet<IStatus>();
      TreeSet<Object> classes = new TreeSet<Object>();
      for (final Object classToImport : classesToImport) {
        {
          String className = ((String) null);
          try {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append(classToImport);
            final String[] tokens = _builder.toString().split(" ");
            int _length = tokens.length;
            int _minus = (_length - 1);
            className = tokens[_minus];
            JvmType jvmType = ((JvmType) null);
            if ((typeReferenceBuilder != null)) {
              boolean _matched = false;
              if (classToImport instanceof Class) {
                _matched=true;
                jvmType = typeReferenceBuilder.typeRef(((Class<?>)classToImport)).getType();
              }
              if (!_matched) {
                if (classToImport instanceof String) {
                  _matched=true;
                  jvmType = typeReferenceBuilder.typeRef(((String)classToImport)).getType();
                }
              }
            }
            importManager.addImportFor(jvmType);
          } catch (final Throwable _t) {
            if (_t instanceof NullPointerException) {
              final NullPointerException npe = (NullPointerException)_t;
              classes.add(className);
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append(classToImport);
              _builder_1.append(" ");
              _builder_1.append(MESSAGE);
              Status _status = new Status(CODE, PLUGINID, _builder_1.toString(), npe);
              errors.add(_status);
            } else if (_t instanceof Exception) {
              final Exception e = (Exception)_t;
              classes.add(className);
              String _localizedMessage = e.getLocalizedMessage();
              Status _status_1 = new Status(CODE, PLUGINID, _localizedMessage, e);
              errors.add(_status_1);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
      }
      boolean _isEmpty = errors.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final HashSet<IStatus> _converted_errors = (HashSet<IStatus>)errors;
        StringConcatenation _builder = new StringConcatenation();
        String _join = IterableExtensions.join(classes, ",\n");
        _builder.append(_join);
        _builder.append(" ");
        _builder.append(MESSAGE);
        MultiStatus _multiStatus = new MultiStatus(PLUGINID, CODE, ((IStatus[])Conversions.unwrapArray(_converted_errors, IStatus.class)), _builder.toString(), null);
        throw new CoreException(_multiStatus);
      }
      return true;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

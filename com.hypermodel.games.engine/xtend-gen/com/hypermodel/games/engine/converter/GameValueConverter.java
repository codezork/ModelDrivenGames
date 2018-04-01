package com.hypermodel.games.engine.converter;

import com.google.inject.Singleton;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.xbase.conversion.XbaseValueConverterService;

@Singleton
@SuppressWarnings("all")
public class GameValueConverter extends XbaseValueConverterService {
  @ValueConverter(rule = "GameQualifiedNameWithWildCard")
  public IValueConverter<String> getQualifiedNameWithWildCard() {
    return this.getQualifiedNameValueConverter();
  }
}

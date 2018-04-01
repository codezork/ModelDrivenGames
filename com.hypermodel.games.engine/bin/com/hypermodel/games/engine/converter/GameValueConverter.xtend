package com.hypermodel.games.engine.converter

import org.eclipse.xtext.conversion.IValueConverter
import org.eclipse.xtext.conversion.ValueConverter
import org.eclipse.xtext.xbase.conversion.XbaseValueConverterService
import com.google.inject.Singleton

@Singleton
class GameValueConverter extends XbaseValueConverterService {

	@ValueConverter(rule = "GameQualifiedNameWithWildCard")
	def public IValueConverter<String> getQualifiedNameWithWildCard() {
		return getQualifiedNameValueConverter
	}
}
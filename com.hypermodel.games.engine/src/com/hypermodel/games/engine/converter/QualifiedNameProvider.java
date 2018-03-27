package com.hypermodel.games.engine.converter;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.scoping.XbaseQualifiedNameProvider;

import com.hypermodel.games.engine.gameDSL.GamePackage;
import com.hypermodel.games.engine.gameDSL.GameRoot;
import com.hypermodel.games.engine.gameDSL.GameScene;
import com.hypermodel.games.engine.gameDSL.GameScreen;
import com.hypermodel.games.engine.gameDSL.GameSprite;

@SuppressWarnings("restriction")
public class QualifiedNameProvider extends XbaseQualifiedNameProvider {

	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		if (obj instanceof GamePackage) {
			String fqn = ((GamePackage) obj).getName();
			return QualifiedName.create(fqn.split("\\."));
		}

		if (obj instanceof GameRoot) {
			GamePackage pkg = (GamePackage) obj.eContainer();
			String fqn = pkg.getName() + "." + ((GameRoot) obj).getName();
			return QualifiedName.create(fqn.split("\\."));
		}

		if (obj instanceof GameScreen) {
			GamePackage pkg = (GamePackage) obj.eContainer().eContainer();
			String fqn = pkg.getName() + ".screens." + ((GameScreen) obj).getName();
			return QualifiedName.create(fqn.split("\\."));
		}

		if (obj instanceof GameScene) {
			GamePackage pkg = (GamePackage) obj.eContainer().eContainer();
			String fqn = pkg.getName() + ".scenes." + ((GameScene) obj).getName();
			return QualifiedName.create(fqn.split("\\."));
		}

		if (obj instanceof GameSprite) {
			GamePackage pkg = (GamePackage) obj.eContainer().eContainer().eContainer();
			String fqn = pkg.getName() + ".sprites." + ((GameSprite) obj).getName();
			return QualifiedName.create(fqn.split("\\."));
		}

		return super.getFullyQualifiedName(obj);
	}
}

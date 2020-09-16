package mgsoft.fallingletters.engine.scene;

import mgsoft.fallingletters.common.Config;
import mgsoft.fallingletters.engine.Engine;
import mgsoft.fallingletters.engine.tickables.LettersTickable;
import mgsoft.fallingletters.scene.MainGameScene;

public class GameSceneFactory {
	
	public static GameScene getMainGameScene() {
		GamePane gamePane  = new GamePane(Config.ALTURA_TELA, Config.LARGURA_TELA, Config.COR_DE_FUNDO);
		GameScene gameScene = new MainGameScene(gamePane);
		
		LettersTickable fallingLettersTickable = new LettersTickable(gamePane);
		Engine.getInstance().getMasterClock().registraTickListener(fallingLettersTickable);
		gameScene.setRoot(gamePane);
		return gameScene;
	}

}

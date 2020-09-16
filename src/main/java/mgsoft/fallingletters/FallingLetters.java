package mgsoft.fallingletters;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import mgsoft.fallingletters.common.Config;
import mgsoft.fallingletters.engine.Engine;
import mgsoft.fallingletters.engine.scene.GamePane;
import mgsoft.fallingletters.engine.scene.GameScene;
import mgsoft.fallingletters.views.MenuView;

public class FallingLetters extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setResizable(false); 
		GameScene startScene = createStartMenuGameScene();
		primaryStage.setScene(startScene);
		Engine engine = Engine.getInstance();
		engine.setGameStage(primaryStage);
		engine.startGame();
		primaryStage.show();
		primaryStage.setTitle(Config.TITULO_JANELA);
	}
	
	private GameScene createStartMenuGameScene() {
		GamePane gamePane  = new GamePane(Config.ALTURA_TELA, Config.LARGURA_TELA, Config.COR_DE_FUNDO);
		GameScene gameScene = new GameScene(gamePane);
		MenuView menu = new MenuView();
		gamePane.getChildren().add(menu);
		menu.setVisible(true);
		return gameScene;
	}
	
    public static void main(String[] args) {
	    launch(args);
	}


}

package mgsoft.fallingletters.engine;

import java.util.ArrayList;
import java.util.List;

import javafx.stage.Stage;
import mgsoft.fallingletters.engine.scene.GamePane;
import mgsoft.fallingletters.engine.scene.GameScene;

public class Engine {
	
	private MasterClock masterClock;
	
	private GameScene scene;

	private Stage gameStage;
    
	private static Engine instance;
	
	private Engine() {}
	
	/**
	 * Singleton para a Engine
	 * @return Engine
	 */
	public static Engine getInstance() {
		if(instance == null) {
			instance = new Engine();
			instance.setMasterClock(createMasterClock());
			
		}
		return instance;
	}
	
	public void startGame() {
		startGameClock();
	}
	
	public void setGameScene(GameScene scene) {
		this.gameStage.setScene(scene);
		this.scene = scene;
	}
	
	public GameScene getGameScene() {
		return this.scene;
	}
	
	public GamePane getGamePane() {
		return (GamePane) this.scene.getRoot();
	}
	
	public MasterClock getMasterClock() {
		return this.masterClock;
	}
	
	private void startGameClock() {
		new Thread(new Runnable() {
			@Override
			public void run() {
	            masterClock.start();
			}
		}).run();
	}
	
	private static MasterClock createMasterClock() {
		MasterClock masterClock = new MasterClock();
		return masterClock;
	}
	
	private void setMasterClock(MasterClock masterClock) {
		this.masterClock = masterClock;
	}

	public Stage getGameStage() {
		return gameStage;
	}

	public void setGameStage(Stage gameStage) {
		this.gameStage = gameStage;
	}
}

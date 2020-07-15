package mgsoft.fallingletters.engine;

import java.util.ArrayList;
import java.util.List;

import mgsoft.fallingletters.engine.scene.GamePane;
import mgsoft.fallingletters.engine.scene.GameScene;

public class Engine {
	
	private MasterClock masterClock;
	
	private GameScene scene;
    
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
		this.scene = scene;
	}
	
	public GameScene getGameScene() {
		return this.scene;
	}
	
	public GamePane getGamePane() {
		return (GamePane) this.scene.getRoot();
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
		List<Tickable> tickListeners = new ArrayList<>();
		Registry.registerTickables(tickListeners);
		for(Tickable tickable : tickListeners) {
			masterClock.registraTickListener(tickable);
		}
		return masterClock;
	}
	
	private void setMasterClock(MasterClock masterClock) {
		this.masterClock = masterClock;
	}
}

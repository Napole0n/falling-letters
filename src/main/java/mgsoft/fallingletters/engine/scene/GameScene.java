package mgsoft.fallingletters.engine.scene;

import javafx.scene.Scene;

public class GameScene extends Scene{

	public GameScene(GamePane root) {
		super(root);
	}
	
	public GamePane getGamePane() {
		return (GamePane) this.getRoot();
	}
	
	public void start() {
	}
	
}

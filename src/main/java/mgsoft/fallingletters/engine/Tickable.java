package mgsoft.fallingletters.engine;

import mgsoft.fallingletters.engine.scene.GamePane;

public abstract class Tickable {
	
	private int tickCount = 0;
	private GamePane targetPane;
	
	public Tickable(GamePane pane) {
		this.setTargetPane(pane);
		this.setup();
	}
	
	public void tick() {
		tickCount++;
		if(tickCount == getTickFrequence()) {
			update();
			tickCount = 0;
		}
	}
	
	public abstract void setup();
	
	/**
	 * Retorna após quantos ticks sera executado o 'update'
	 * @return int
	 */
	protected abstract int getTickFrequence();
	
	public abstract void update();

	public GamePane getTargetPane() {
		return targetPane;
	}

	public void setTargetPane(GamePane targetPane) {
		this.targetPane = targetPane;
	}

}

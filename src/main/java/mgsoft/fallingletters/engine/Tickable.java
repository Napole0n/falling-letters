package mgsoft.fallingletters.engine;

public abstract class Tickable {
	
	private int tickCount = 0;
	
	public void tick() {
		tickCount++;
		if(tickCount == getTickFrequence()) {
			update();
			tickCount = 0;
		}
	}
	
	/**
	 * Retorna após quantos ticks sera executado o 'update'
	 * @return int
	 */
	protected abstract int getTickFrequence();
	
	public abstract void update();

}

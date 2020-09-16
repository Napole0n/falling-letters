package mgsoft.fallingletters.engine.tickables;

import mgsoft.fallingletters.engine.Tickable;
import mgsoft.fallingletters.engine.scene.GamePane;

public class TesteTick extends Tickable{
	public TesteTick(GamePane pane) {
		super(pane);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected int getTickFrequence() {
		return 50;
	}

	@Override
	public void update() {
     
	}

	@Override
	public void setup() {
		// TODO Auto-generated method stub
		
	}

}

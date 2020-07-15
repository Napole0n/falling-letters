package mgsoft.fallingletters.engine;

import java.util.List;

import mgsoft.fallingletters.engine.tickables.TesteTick;

public class Registry {
	
	public static void registerTickables(List<Tickable> tickables){
        tickables.add(new TesteTick());
	}

}

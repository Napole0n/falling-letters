package mgsoft.fallingletters.engine.tickables;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import mgsoft.fallingletters.engine.Tickable;
import mgsoft.fallingletters.engine.scene.GamePane;

public class ParticleTickable extends Tickable {

	private List<Node> particles;

	public ParticleTickable(GamePane pane) {
		super(pane);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setup() {
		particles = new ArrayList<Node>();
		for(int i=0; i< getParticleAmmount(); i++) {
			particles.add(getParticleSample());
		}
	}

	@Override
	protected int getTickFrequence() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public void update(long time) {
		// TODO Auto-generated method stub

	}
	
	public int getParticleAmmount() {
		return 10;
	}

	public Node getParticleSample() {
		return new Circle(getEmissionCenter().getX(), getEmissionCenter().getY(), 3, Color.BLACK);
	}

	public Point2D getEmissionCenter() {
		return new Point2D(0, 0);
	}

}

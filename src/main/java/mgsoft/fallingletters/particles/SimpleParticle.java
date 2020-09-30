package mgsoft.fallingletters.particles;

import java.util.concurrent.TimeUnit;

import javafx.application.Platform;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import mgsoft.fallingletters.engine.Engine;
import mgsoft.fallingletters.engine.Particle;

public class SimpleParticle extends Particle {
	
    private Node nodeToMove;
	private double angle;
	private double velocidade;
	private final double gravidade = -9.81;
	private long timeInit;
	private boolean initialized = false;
	private boolean running = false;
	private double x0;
	private double y0;
	private Dimension2D dim;
	double x, y = 0;

	public SimpleParticle(double angle, double velocity, double fromX, double fromY,
			Dimension2D dim) {
		super(fromX, fromY);
		nodeToMove = getNode();
		this.angle = angle;
		this.velocidade = velocity;
		this.y0 = fromY;
		this.x0 = fromX;
		this.dim = dim;
		Platform.runLater(new Runnable() {	
			@Override
			public void run() {
				Engine.getInstance().getGamePane().getChildren().add(nodeToMove);
			}
		});
	}
	
	@Override
	public void handle(long now) {
		if (!initialized) {
			timeInit = TimeUnit.MILLISECONDS.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
			initialized = true;
		}
		double t0;
		double vX = velocidade * (Math.cos(Math.toRadians(angle)));
		double vY = velocidade * (Math.sin(Math.toRadians(angle)));
		
		t0 = (((TimeUnit.MILLISECONDS.convert(now, TimeUnit.NANOSECONDS)) - timeInit) * 0.006);
		x = x0 + vX * t0;
		y = dim.getHeight() - (y0 + vY * t0 + 0.5 * gravidade * Math.pow(t0, 2));
		
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				nodeToMove.setTranslateX(x);
				nodeToMove.setTranslateY(y);
			}
		});
		
		if (y > dim.getHeight() && running) {
			stop();
		}

		if (!running) {
			running = true;
		}

	}

}

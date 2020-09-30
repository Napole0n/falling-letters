package mgsoft.fallingletters.engine;

import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public abstract class Particle extends AnimationTimer{

	private double x,y;
	
	public Particle(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Node getNode() {
		Color color;
		if(Math.random() * 100 <= 30) {
			color = Color.RED;
		}
		else {
			color = Color.BLACK;
		}
		return new Circle(this.x, this.y, 3, color);
	}
	
}

package mgsoft.fallingletters.engine.scene;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class GamePane extends Pane{
	
	public GamePane(double altura, double largura, Color corDeFundo) {
		super();
		this.setPrefSize(largura, altura);
		this.setBackground(new Background(new BackgroundFill(corDeFundo, null, null)));
	}

}

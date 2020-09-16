package mgsoft.fallingletters.engine.tickables;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.scene.text.Text;
import mgsoft.fallingletters.common.Config;
import mgsoft.fallingletters.engine.Tickable;
import mgsoft.fallingletters.engine.scene.GamePane;

public class LettersTickable extends Tickable {

	public LettersTickable(GamePane pane) {
		super(pane);
	}

	private List<Text> letters;
	private List<Text> activeLetters;

	@Override
	protected int getTickFrequence() {
		return 1;
	}

	@Override
	public void update() {
		if((int)(Math.random() * 100) <= 2){
			int pos = (int) (Math.random() * 26);
			Text letra = letters.get(pos);
			letra.setVisible(true);
			activeLetters.add(letra);
		}
		

		for (Text letraAtiva : activeLetters) {
			letraAtiva.setTranslateY(letraAtiva.getTranslateY() + Config.VELOCIDADE_LETRAS_BASE);
			if (letraAtiva.getTranslateY() >= Config.ALTURA_TELA) {
				Platform.runLater(new Runnable() {
					
					@Override
					public void run() {
						activeLetters.remove(letraAtiva);
						letraAtiva.setVisible(false);
						letraAtiva.setTranslateY(0);
						letters.add(letraAtiva);
					}
				});
			}
		}
	}

	@Override
	public void setup() {
		letters = new ArrayList<>();
		activeLetters = new ArrayList<>();

		for (int i = 65; i <= 90; i++) {
			Text letra = new Text();
			letra.setText(Character.toString((char) i));
			letra.setTranslateX(Math.random() * Config.LARGURA_TELA);
			letra.setTranslateY(0);
			letters.add(letra);
			this.getTargetPane().getChildren().add(letra);
			letra.setVisible(false);
		}

	}

}

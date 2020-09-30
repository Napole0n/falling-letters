package mgsoft.fallingletters.engine.tickables;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import mgsoft.fallingletters.common.Config;
import mgsoft.fallingletters.engine.Tickable;
import mgsoft.fallingletters.engine.scene.GamePane;
import mgsoft.fallingletters.particles.ExplosionParticleEmissor;

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
	public void update(long time) {

		if ((int) (Math.random() * 100) <= 2) {
			int pos = (int) (Math.random() * 26);
			if (!activeLetters.contains(letters.get(pos))) {
				Text letra = letters.get(pos);
				letra.setVisible(true);
				activeLetters.add(letra);
			}
		}

		for (Text letraAtiva : activeLetters) {
			Platform.runLater(moveLetra(letraAtiva));
			if (letraAtiva.getTranslateY() >= Config.ALTURA_TELA) {
				// Quando a letra bate na parte inferior da tela
				ExplosionParticleEmissor emissor = new ExplosionParticleEmissor(letraAtiva.getTranslateX(), letraAtiva.getTranslateY());
				emissor.emmit();
				Platform.runLater(resetLetra(letraAtiva));
			}
		}
		
	}

	private Runnable moveLetra(Text letra) {
		return new Runnable() {
			@Override
			public void run() {
				letra.setTranslateY(letra.getTranslateY() + Config.VELOCIDADE_LETRAS_BASE);
			}
		};
	}

	private Runnable resetLetra(Text letra) {
		return new Runnable() {
			@Override
			public void run() {
				activeLetters.remove(letra);
				letra.setVisible(false);
				letra.setTranslateY(0);
				letters.add(letra);
			}
		};
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

		handleInput();

	}

	private void handleInput() {
		this.getTargetPane().getScene().setOnKeyPressed(e -> {
			checkKeyPressed(e);
		});
	}

	private void checkKeyPressed(KeyEvent event) {
		for (Text letter : activeLetters) {
			if (letter.getText().toLowerCase().equals(event.getText().toLowerCase())) {
				Platform.runLater(resetLetra(letter));
			}
		}
	}

}

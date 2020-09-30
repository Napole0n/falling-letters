package mgsoft.fallingletters.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.AnimationTimer;
import mgsoft.fallingletters.common.Config;

/**
 * Classe responsável pelo controle do relógio do jogo, responsável por executar
 * repetidamente chamadas que disparam ações ou modificam a cena do jogo.
 * Extende AnimationTimer, que é uma classe do JavaFX que implementa uma arquitetura de 'Relogio'
 * onde dispara assim que for possível a função 'handle', passando o tempo atual em nanometros,
 * este é utilizado para calcular o tempo que se decorreu desde o ultimo Tick, o que é util
 * para a simulação de fisica e movimento, que variam em relação ao tempo
 * @author Murilo Goedert
 */
public class MasterClock extends AnimationTimer {

	private List<Tickable> tickListeners;

	private static long tempoControle = 0;
	private static int contadorTps = 0;
	private static double acumuladorDeTempo = 0;

	public MasterClock() {
		this.tickListeners = new ArrayList<>();
	}

	@Override
	public void handle(long agora) {
		// Tempo decorrido é igual ao tempo atual menos o ultimo tempo armazenado em tempoControle
		// Dividindo o resultado por 1.000.000, convertendo assim em milisegundos
		double tempoDecorrido = (agora - tempoControle) / 1e6;
		acumuladorDeTempo += tempoDecorrido;

	    tempoControle = agora;
        tick(agora);

		if (acumuladorDeTempo >= 1000) {
			printTps();
			contadorTps = 0;
			acumuladorDeTempo = 0;
		}
	}

	/**
	 * Executa um 'Tick' ou 'Ciclo' da engine
	 */
	private void tick(long time) {
		contadorTps++;
		for (Tickable tickable : this.tickListeners) {
			tickable.tick(time);
		}
	}

	private void printTps() {
		if (Config.ATIVA_CONTADOR_TPS) {
			Logger.getGlobal().log(Level.INFO, "TPS: " + contadorTps);
		}
	}

	/**
	 * Adiciona um objeto que tera sua função 'tick' disparada a cada tick 
	 * @param listener
	 */
	public void registraTickListener(Tickable listener) {
		this.tickListeners.add(listener);
	}

}

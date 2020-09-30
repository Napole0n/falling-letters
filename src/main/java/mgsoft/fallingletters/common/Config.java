package mgsoft.fallingletters.common;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class Config {
	
	/* Define se será logado o TPS (Ticks per Secound) no console. 
	 * O TPS é a quentidade de Ticks por segundo que estão sendo executados
	 * no MasterClock 
	 */
	public static final boolean ATIVA_CONTADOR_TPS = false;

	/**
	 * Define a Largura da Tela do Jogo
	 */
	public static final double LARGURA_TELA = 800d;
	
	/**
	 * Define a Altura da Tela do Jogo
	 */
	public static final double ALTURA_TELA = 600d;

	/**
	 * Cor de Fundo do jogo
	 */
	public static final Color COR_DE_FUNDO = Color.CADETBLUE;
	
	public static final Color COR_DE_FUNDO_MENUS = Color.rgb(0, 163, 136);
	
	
	/**
	 * Titulo da janela do Jogo
	 */
	public static final String TITULO_JANELA = "Falling Letters";
	
	// Configurações de Layout
	
	public static final CornerRadii RADII_LAYOUT_PADRAO = new CornerRadii(10);
	
	public static final Insets INSETS_LAYOUT_PADRAO = new Insets(1);
	
	public static final double VELOCIDADE_LETRAS_BASE = 2;

	
	/**
	 * Define o Background padrão dos menus
	 */
	public static final Background BACKGROUND_MENUS_PADRAO = new Background(new BackgroundFill(Config.COR_DE_FUNDO_MENUS, Config.RADII_LAYOUT_PADRAO , Config.INSETS_LAYOUT_PADRAO));


}

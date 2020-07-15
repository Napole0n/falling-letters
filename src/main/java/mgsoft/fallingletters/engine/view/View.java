package mgsoft.fallingletters.engine.view;

import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import mgsoft.fallingletters.common.Config;

public abstract class View extends Pane {

	private List<Node> componentes;
	private String viewName;

	public View(String name) {
		this.viewName = name;
		this.componentes = criaComponentes();
		carregaComponentes();
		redimensiona();
		setPosicao();
	    defineEstilo();
	    criaComportamentosEstiloComponentes();
	    super.setVisible(false);
	   }

	protected void defineEstilo() {
		this.setBackground(Config.BACKGROUND_MENUS_PADRAO);
		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, Config.RADII_LAYOUT_PADRAO, BorderWidths.DEFAULT)));
	}

	private void setPosicao() {
		double pontoX = 0;
		double pontoY = 0;

		if (getPontoCentro() != null) {
			Point2D pontoCentro = this.getPontoCentro();
			pontoX = pontoCentro.getX();
			pontoY = pontoCentro.getY();
			if (pontoX < 0 || pontoY < 0 || pontoX > Config.LARGURA_TELA || pontoY > Config.ALTURA_TELA) {
				System.err.println("View " + this.getClass().getName() + " inserida fora da Tela!");
			}
		}
		else {
			pontoX = (Config.LARGURA_TELA / 2) - (this.getPrefWidth() / 2);
			pontoY = (Config.ALTURA_TELA / 2) - (this.getPrefHeight() / 2);
		}

		this.setTranslateX(pontoX);
		this.setTranslateY(pontoY);
	}

	private void redimensiona() {
		int proporcaoAltura = getProporcaoAltura();
		int proporcaoLargura = getProporcaoLargura();

		double altura = proporcaoAltura * Config.ALTURA_TELA / 100;
		double largura = proporcaoLargura * Config.LARGURA_TELA / 100;

		this.setPrefWidth(largura);
		this.setPrefHeight(altura);
	}

	private void carregaComponentes() {
		for (Node node : componentes) {
			this.getChildren().add(node);
		}
	}
	
	private void criaComportamentosEstiloComponentes() {
		for(Node node : componentes) {
			if(node instanceof Button) {
				this.criaComportamentosEstiloBotao((Button)node);
			}
		}
	}
	
	protected void criaComportamentosEstiloBotao(Button button) {
		button.setOnMouseEntered(e -> {
			((Button) button).setTextFill(Color.WHITE);
			((Button) button).setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, Config.RADII_LAYOUT_PADRAO, BorderWidths.DEFAULT)));
		});
		
		button.setOnMouseExited(e -> {
			((Button) button).setTextFill(Color.BLACK);
			((Button) button).setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, Config.RADII_LAYOUT_PADRAO, BorderWidths.DEFAULT)));
		});
	}

	protected abstract List<Node> criaComponentes();

	protected abstract int getProporcaoAltura();

	protected abstract int getProporcaoLargura();

	protected Point2D getPontoCentro() {
		return null;
	}
	
	public List<Node> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<Node> componentes) {
		this.componentes = componentes;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}	

}

package mgsoft.fallingletters.views;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import mgsoft.fallingletters.common.Config;
import mgsoft.fallingletters.engine.view.View;

public class MenuView extends View{
	
	public MenuView() {
		super("menu_principal");
	}
	
	@Override
	protected List<Node> criaComponentes() {
		List<Node> componentes = new ArrayList<>();
		
		componentes.add(getStartGameOption());

		return componentes;
	}
	
	private Button getStartGameOption() {
		Button btn  = new Button("START");
		btn.setFont(new Font("Aclonica", 20));
		btn.setPrefSize(580, 60);
		btn.setLayoutX(29);
		btn.setLayoutY(40);
		btn.setTextFill(Color.BLACK);
		btn.setBackground(new Background(new BackgroundFill(Color.rgb(28, 185, 159), new CornerRadii(40), new Insets(3))));
		btn.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(15), BorderWidths.DEFAULT)));
		btn.setOnMouseClicked(e -> {
		    System.out.println("Clicou");
		});
		return btn;
	}

	@Override
	protected int getProporcaoAltura() {
		return 80;
	}

	@Override
	protected int getProporcaoLargura() {
		return 80;
	}

}

package clockIHM;

import clockController.ClockController;
import clockModel.ClockModel;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ClockViewLessMore extends ClockView {

	private String sign;
	
	public ClockViewLessMore(String label, ClockModel tm, ClockController tc, int posX, int posY, String sign) {
		super(label, tm, tc, posX, posY);
			this.sign = sign;
	}
	
	
	private HBox createButtons() {
		HBox hbox = new HBox(10);
		hbox.setStyle("-fx-background-color: BLUE;");
		hbox.setAlignment(Pos.BOTTOM_CENTER);
		Button button1000 = new Button(sign + "1000s");
		Button button100 = new Button(sign + "100s");
		Button button10 = new Button(sign + "10s");
		
		int factor = signToInt();
		
		button1000.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				myController.incSecond(factor*1000);
			}});
		button100.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				myController.incSecond(factor*100);
			}});
		button10.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				myController.incSecond(factor*10);
			}});

		hbox.getChildren().addAll(button1000, button100, button10);
		return hbox;
	}

	private int signToInt() {
		if (sign.equals("-")) {
			return -1;
		}
		return 1;
	}
	
	public BorderPane createContent() {
		BorderPane border = new BorderPane();
		border.setBottom(createButtons());
		Label text = new Label(this.myModel.toString());
		border.setTop(text);
		return border;
	}
	
	public void layout(Stage stage){
		stage.setScene(new Scene(createContent()));
		stage.show();
	}
	
	@Override 
	public void start (){
		layout(this);
	}

	@Override
	public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
		layout(this);
	}
}

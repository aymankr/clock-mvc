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

public class ClockViewLessMore extends ClockView {

	private final int factor;
	
	public ClockViewLessMore(String label, ClockModel tm, ClockController tc, int posX, int posY, int factor) {
		super(label, tm, tc, posX, posY);
			this.factor = factor;
	}
	
	
	private HBox createButtons() {
		HBox hbox = new HBox(10);
		hbox.setStyle("-fx-background-color: BLUE;");
		hbox.setAlignment(Pos.BOTTOM_CENTER);
		Button button1000 = factor == -1 ? new Button( "-1000s") : new Button("+1000s");
		Button button100 = factor == -1 ? new Button( "-100s") : new Button("+100s");
		Button button10 = factor == -1 ? new Button( "-10s") : new Button("+10s");
		
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
	
	private BorderPane createContent() {
		BorderPane border = new BorderPane();
		border.setBottom(createButtons());
		Label text = new Label(this.myModel.toString());
		border.setTop(text);
		return border;
	}
	
	protected void layout(){
		this.setScene(new Scene(createContent()));
		this.show();
	}
	
	@Override 
	public void start (){
		layout();
	}

	@Override
	public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
		layout();
	}
}

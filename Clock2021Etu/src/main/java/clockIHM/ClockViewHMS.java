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
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ClockViewHMS extends ClockView {
	private final int unite;
	private int time;

	public ClockViewHMS(String label, ClockModel tm, ClockController tc, int posX, int posY, int unite) {
		super(label, tm, tc, posX, posY);
		this.unite = unite;
		changeTime();
	}
	
	private void changeTime(){
		switch(unite){
		case 1 :
			time = myModel.getSecond();
			break;
		case 60 :
			time = myModel.getMinute();
			break;
		case 3600:
			time = myModel.getHour();
			break;
		default:
			time = -1;
		}
	}
	
	private HBox createButtons() {
		HBox hbox = new HBox(10);
		hbox.setStyle("-fx-background-color: BLUE;");
		hbox.setAlignment(Pos.BOTTOM_CENTER);
		
		Button buttonPlus = new Button("+");
		buttonPlus.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				incTime(1);
			}});
		Button buttonMoins = new Button("-");
		buttonMoins.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				incTime(-1);
			}});
		hbox.getChildren().addAll(buttonPlus, buttonMoins);
		return hbox;
	}
	
	private void incTime(int n){
		switch(unite){
		case 1 :
			myController.incSecond(n);
			break;
		case 60:
			myController.incMinute(n);
			break;
		case 3600:
			myController.incHour(n);
			break;
		}
	}
	
	private BorderPane createContent() {
		BorderPane border = new BorderPane();
		border.setBottom(createButtons());
		Label text = new Label(String.valueOf(time));
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
		changeTime();
		layout();
	}

}

package clockIHM;



import clockController.ClockController;
import clockModel.ClockModel;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;


public class ClockViewHMS extends ClockView {

	public ClockViewHMS(String label, ClockModel tm, ClockController tc, int posX, int posY) {
		super(label, tm, tc, posX, posY);
		HBox hbox = new HBox(10);
		hbox.setStyle("-fx-background-color: BLUE;");
		hbox.setAlignment(Pos.BOTTOM_CENTER);
		
		Button buttonPlus = new Button("+");
		buttonPlus.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//myModel.addHourObserver();
			});
	}

	@Override
	public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
		// TODO Auto-generated method stub
		
	}

}

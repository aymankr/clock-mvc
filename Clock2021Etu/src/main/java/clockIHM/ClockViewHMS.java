package clockIHM;

import clockController.ClockController;
import clockModel.ClockModel;
import javafx.beans.value.ObservableValue;


public class ClockViewHMS extends ClockView {

	public ClockViewHMS(String label, ClockModel tm, ClockController tc, int posX, int posY) {
		super(label, tm, tc, posX, posY);
				
	}

	@Override
	public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
		// TODO Auto-generated method stub
		
	}

}

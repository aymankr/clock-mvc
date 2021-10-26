package clockIHM;

import clockController.ClockController;
import clockModel.ClockModel;
import javafx.beans.value.ObservableValue;

public class ClockViewLess extends ClockView {

	public ClockViewLess(String label, ClockModel tm, ClockController tc, int posX, int posY) {
		super(label, tm, tc, posX, posY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
		// TODO Auto-generated method stub

	}

}

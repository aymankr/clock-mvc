package clockController;

import clockException.ClockException;
import clockModel.ClockModel;

public class ClockControllerH extends ClockControllerDecorator {

	public ClockControllerH (AClockController controller)  
		{super(controller);}

	@Override
	public void setHour(int hour) {
		System.out.println("ControllerH - setHour");
		int h = hour % ClockModel.MAX_HOUR;
		if (h < ClockModel.MIN_TIME){ 
			h = h + ClockModel.MAX_HOUR;
		}
		try {
			myController.getModel().setHour(h);
		}
		catch (ClockException e) { 
			System.err.println(e); 
		}
	}

	@Override
	public void incHour(int hour) {
		System.out.println("ControllerH - incHour");
		int hh = myController.getModel().getHour();
		setHour(hh+hour);
	}

}

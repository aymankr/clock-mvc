package clockController;

import clockException.ClockException;
import clockModel.ClockModel;

public class ClockControllerS extends ClockControllerDecorator {

	public ClockControllerS (AClockController controller)  	{super(controller);}

	@Override
	public void setSecond(int second){
		int s = second % ClockModel.MAX_MINSEC;
		if (second > 0) {
			int sm = second / ClockModel.MAX_MINSEC;
			if (sm > 0) {
				incMinute(sm);
			}
		} else if (second < 0) {
			if (s < ClockModel.MIN_TIME){
				s += ClockModel.MAX_MINSEC;
			} 
			float sm = second / (float) ClockModel.MAX_MINSEC;
			if (sm < 0) {
				incMinute((int)Math.floor(sm)); // On incrémente l'arrondi à l'inférieur du float sm.
			}
		}
		try {
			myController.getModel().setSecond(s);
		} catch (ClockException e) {
			System.err.println(e);
		}
	}
	
	@Override
	public void incSecond(int second){
		int s = myController.getModel().getSecond();
		this.setSecond(s + second);
	}
}

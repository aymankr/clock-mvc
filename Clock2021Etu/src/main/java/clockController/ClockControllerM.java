package clockController;

import clockException.ClockException;
import clockModel.ClockModel;

public class ClockControllerM extends ClockControllerDecorator {
	
	public ClockControllerM (AClockController controller)  {super(controller);}
	
	@Override
	public void setMinute(int minute){
		int m = minute % ClockModel.MAX_MINSEC;
		if (minute > 0){
			if (m < ClockModel.MIN_TIME){
	            m += ClockModel.MAX_MINSEC;
	        }
			int mh = minute/ClockModel.MAX_MINSEC;
	        if (mh > 0) incHour(mh);
		} else if (minute < 0){
			if (m < ClockModel.MIN_TIME){
	            m += ClockModel.MAX_MINSEC;
	        }
			float mh = minute/(float)ClockModel.MAX_MINSEC;
	        if (mh < 0) {
	        	incHour((int)Math.floor(mh));
	        }
		}
		try { 
            myController.getModel().setMinute(m);
        } catch (ClockException e) {
            System.err.println(e);
        } 
	}
	
	@Override
	public void incMinute(int minute){
		System.out.println("ControllerM - incMinute");
		int m = myController.getModel().getMinute();
        this.setMinute(m + minute); 
	}	
}

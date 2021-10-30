package clockController;

import clockException.ClockException;
import clockModel.ClockModel;

public class ClockControllerM extends ClockControllerDecorator {
	
	public ClockControllerM (AClockController controller)  {super(controller);}
	
	@Override
	public void setMinute(int minute){
		int m = minute % ClockModel.MAX_MINSEC;
        if (m < ClockModel.MIN_TIME){
            m += ClockModel.MAX_MINSEC;
            incHour(-1);
        }
        try { 
            myController.getModel().setMinute(m);
        } catch (Exception e) {
            System.out.println(e);
        } 
        int mh = minute/ClockModel.MAX_MINSEC;
        if (mh > 0) incHour(mh);
        System.out.println(myModel);
	}
	
	@Override
	public void incMinute(int minute){
		System.out.println("ControllerM - incMinute");
		int m = myController.getModel().getMinute();
        this.setMinute(m + minute); 
	}	
}

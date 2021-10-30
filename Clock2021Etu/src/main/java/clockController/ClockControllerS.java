package clockController;

import clockModel.ClockModel;

public class ClockControllerS extends ClockControllerDecorator {

	public ClockControllerS (AClockController controller)  	{super(controller);}

	@Override
	public void setSecond(int second){
		int s = second % ClockModel.MAX_MINSEC;
		if (s < ClockModel.MIN_TIME){
			s += ClockModel.MAX_MINSEC;
			incMinute(-1);
		} 
		if (second < 0 && s == ClockModel.MIN_TIME) {
			incMinute(-1);
		}
		try {
			myController.getModel().setSecond(s);
		} catch (Exception e) {
			System.out.println(e);
		}
		int sm = second / ClockModel.MAX_MINSEC;
		if (sm > 0) {
			incMinute(sm);
		} else if (sm < 0) incMinute(sm);
		System.out.println(myModel);
	}
	
	@Override
	public void incSecond(int second){
		int s = myController.getModel().getSecond();
		this.setSecond(s + second);
	}
}

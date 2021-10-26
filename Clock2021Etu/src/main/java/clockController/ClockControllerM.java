package clockController;


public class ClockControllerM extends ClockControllerDecorator {
	
	public ClockControllerM (AClockController controller)  {super(controller);}
	
	@Override
	public void setMinute(int minute){
		System.out.println("ControllerM - setMinute");
		//TODO
	}
	
	@Override
	public void incMinute(int minute){
		System.out.println("ControllerM - incMinute");
			//TODO
	}	
}

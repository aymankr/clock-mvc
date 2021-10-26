package clockController;


public class ClockControllerS extends ClockControllerDecorator {

	public ClockControllerS (AClockController controller)  	{super(controller);}

	@Override
	public void setSecond(int second){
		System.out.println("ControllerS - setSecond");
		//TODO
	}
	
	@Override
	public void incSecond(int second){
		System.out.println("ControllerS - incSecond");
		//TODO
	}
}

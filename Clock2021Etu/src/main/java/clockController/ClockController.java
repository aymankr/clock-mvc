package clockController;

import clockIHM.ClockView;
import clockIHM.ClockViewHMS;
import clockIHM.ClockViewLessMore;
import clockModel.ClockModel;

public class ClockController extends ClockControllerDecorator {
	
	public ClockController (ClockModel model)  
	{  
		super(model);
		AClockController cc1 = new ClockControllerEmpty(model);
		AClockController cc2 = new ClockControllerH(cc1);
		AClockController cc3 = new ClockControllerM(cc2);
		myController = new ClockControllerS(cc3);
		
	}

	public void start() {
		ClockView vh = new ClockViewHMS("Hour - Kachmar Leonelli", myModel, this, 200, 100, 3600);
			ClockView vm = 
				new ClockViewHMS("Minute - Kachmar Leonelli",myModel, this, 200, 200, 60);
			ClockView vs = 
				new ClockViewHMS("Seconde - Kachmar Leonelli", myModel, this, 200, 300, 1);
			
			ClockView va =	new ClockViewLessMore("Kachmar Leonelli - Less",myModel, this, 500, 100, "-");
			ClockView vmo =	new ClockViewLessMore("Kachmar Leonelli - More",myModel, this, 500, 300, "+");
			
			myModel.addHourObserver(vh);
			myModel.addMinuteObserver(vm);
			myModel.addSecondObserver(vs);
			
			myModel.addSecondObserver(va);
			myModel.addSecondObserver(vmo);
			
			vh.start(vh);
			vm.start(vm);
			vs.start(vs);
			va.start(va);
			vmo.start(vmo);
	}


}

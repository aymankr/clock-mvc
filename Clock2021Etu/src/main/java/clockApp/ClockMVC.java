package clockApp;


import clockController.ClockController;
import clockIHM.*;
import clockModel.ClockModel;
import javafx.application.Application;
import javafx.stage.Stage;


public class ClockMVC extends Application {
		@Override
		public void init () { }

		public static void main(String args[]) {	launch(args);	}
			
		@Override
		public void start(Stage stage) {
			ClockModel m = new ClockModel(10,0,0);
			ClockController c = new ClockController(m);
			c.start();
			// 5 fenetres a creer
			/*
			ClockView vh = 
				new ClockViewButtonHour("VOTRE_NOM - Hour", m, c, 200, 100);
			ClockView vm = 
				new ClockViewButtonMinute("VOTRE_NOM - Minute", m,c, 200, 200);
			ClockView vs = 
				new ClockViewButtonSecond("VOTRE_NOM - Second", m,c, 200, 300);	
			ClockView va =	new ClockViewLess("VOTRE_NOM - Less",m,c, 500, 100);
			ClockView vmo =	new ClockViewMore("VOTRE_NOM - More",m,c, 500, 300);
			*/
			
		}
}

public class Horloge {
    int secondes;
    int minutes;
    int heures;

    Horloge(int s){

    }
}

public class ClockException extends Exception {

}

public void setHour(int h) throws ClockException {
    if (h < ClockModel.MIN) throw new ClockException();
    if (h >= ClockModel.MAX_HEURE) throw new ClockException();
    this.minute.setValue(h);
}

public void setMinute (int m) throws ClockException {
    if (m < ClockModel.MIN) throw new ClockException();
    if (m >= ClockModel.MAX_MINSEC) throw new ClockException();
    this.minute.setValue(m);
}

public void setSecondes (int s) throws ClockException {
    if (s < ClockModel.MIN) throw new ClockException();
    if (s >= ClockModel.MAX_MINSEC) throw new ClockException();
    this.second.setValue(s);
}

public class ClockControllerH extends ClockControllerDecorator {
    public ClockControllerH(AClockController controller) { super(controller); }
    
    @Override
    public void setMinute(int minute){
        int m = minute % ClockModel.MAX_MINSEC;
        if (m < ClockModel.MAX_MINSEC){
            m += ClockModel.MAX_MINSEC;
        }
        try { 
            myController.getModel().setMinute(m);
        } catch (Exception e) {
            System.out.println(e);
        } 
        int mh = minute/ClockModel.MAX_MINSEC;
        if (mh > 0) incHour(mh);
    }

    @Override
    public void incMinute(int minute){
        int m = myController.getModel().getMinute();
        this.setMinute(m + minute); 
    } 
}



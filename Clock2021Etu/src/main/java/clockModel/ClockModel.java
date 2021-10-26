package clockModel;
import java.util.Observable;

import clockException.ClockException;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;

public class ClockModel  extends Observable {
	private final IntegerProperty hour = new SimpleIntegerProperty(0);
	private final IntegerProperty minute  = new SimpleIntegerProperty(0);
	private final IntegerProperty second  = new SimpleIntegerProperty(0);
	public static final int MAX_HOUR = 24;
	public static final int MAX_MINSEC = 60;
	public static final int MIN_TIME = 0;

	public ClockModel(int hour, int minute, int second) {
		super();
		this.hour.set(hour);
		this.minute.set(minute);
		this.second.set(second);  
		}
	
	public int getHour() {
		System.out.println("Model - getHour");
		return hour.get();
	}
	
	public void setHour(int hour) throws ClockException {
		System.out.println("Model - setHour");
		if (hour < ClockModel.MIN_TIME) throw new ClockException();
	    if (hour >= ClockModel.MAX_HOUR) throw new ClockException();
	    this.minute.setValue(hour);
	    }

	public int getMinute() {	
		System.out.println("Model - getMinute");
		return minute.get();	
	}
	
	public void setMinute(int minute) throws ClockException {
		System.out.println("Model - setMinute");
		if (minute < ClockModel.MIN_TIME) throw new ClockException();
	    if (minute >= ClockModel.MAX_MINSEC) throw new ClockException();
	    this.minute.setValue(minute);
	}
	
	public int getSecond()    {
		System.out.println("Model - getSecond");
		return second.get(); 
	}
	
	public void setSecond(int second) throws ClockException {
		System.out.println("Model - setSecond");
		if (second < ClockModel.MIN_TIME) throw new ClockException();
	    if (second >= ClockModel.MAX_MINSEC) throw new ClockException();
	    this.second.setValue(second);	}	
	
	public void addHourObserver(ChangeListener<Number> c1) {hour.addListener(c1);}
	public void addMinuteObserver(ChangeListener<Number> c1) {minute.addListener(c1);}
	public void addSecondObserver(ChangeListener<Number> c1) {second.addListener(c1);}
	
	
}

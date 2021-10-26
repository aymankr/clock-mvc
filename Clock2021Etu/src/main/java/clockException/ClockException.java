package clockException;

public class ClockException extends Exception {

	private static final long serialVersionUID = 1L;

	public ClockException (String m) {
		super(m);
	}
	public ClockException (){
		super("Le temps donné n'est pas valide.");
	}
}

public class ParseException extends Exception {

	public ParseException() {
		super("Leider ist bei der Eingabe der Programmoptionen ein Fehler aufgetreten.");
	}

	public ParseException(String msg) {
		super(msg);
	}
}
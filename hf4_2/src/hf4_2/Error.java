package hf4_2;

/**
 * The Class Error.
 */
public final class Error extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The info. */
	private String info;

	
	/**
	 * Instantiates a new error.
	 *
	 * @param a the a
	 */
	public Error(int a) {
		if (a == 1) {
			info = " ***** Nulla hosszu ertek az oldalra vagy a kor sugarara. *****";
		}
		if (a == 2) {
			info = " ***** Negativ ertek az oldalra vagy a sugarara. *****";
		}
		if (a == 3) {
			info = " ***** Haromszogegyenlotlenseg nem teljesul. *****";
		}
	}

	
	/**
	 * Except.
	 */
	public void except() {
		System.out.println("\nHiba("+ info + ")");
	}
}


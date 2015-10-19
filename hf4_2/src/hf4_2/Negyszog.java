package hf4_2;

/**
 * The Class Negyszog.
 */
public final class Negyszog extends Sokszogek implements KeruletSzamithato
{
	
	/** The Nev. */
	String Nev;
	
	/** The a. */
	int a;
	
	/** The b. */
	int b;
	
	/** The c. */
	int c;
	
	/** The d. */
	int d;

	/**
	 * Instantiates a new negyszog.
	 *
	 * @param nev the nev
	 * @param a the a
	 * @param b the b
	 * @param c the c
	 * @param d the d
	 * @throws Error the error
	 */
	public Negyszog(String nev, int a, int b, int c, int d) throws Error {

		if (a == 0 || b == 0 || c == 0 || d == 0) {
			throw new Error(1);
		}
		if (a < 0 || b < 0 || c < 0 || d < 0) {
			throw new Error(2);
		}

		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.Nev = nev;
	}

	/* (non-Javadoc)
	 * @see hf4.KeruletSzamithato#computeKerulet()
	 */
	public float computeKerulet() {
		return (a + b + c + d);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Negyszog [Nev=" + Nev + ", a=" + a + ", b=" + b + ", c=" + c
				+ ", d=" + d + ", Kerulet=" + computeKerulet() + "]";
	}

}

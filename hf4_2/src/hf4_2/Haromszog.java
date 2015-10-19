package hf4_2;

/**
 * The Class Haromszog.
 */
public final class Haromszog extends Sokszogek implements KeruletTeruletSzamithato 
{
	
	/** The Nev. */
	String Nev;
	
	/** The a. */
	int a;
	
	/** The b. */
	int b;
	
	/** The c. */
	int c;

	/**
	 * Instantiates a new haromszog.
	 *
	 * @param nev the nev
	 * @param a the a
	 * @param b the b
	 * @param c the c
	 * @throws Error the error
	 */
	public Haromszog(String nev, int a, int b, int c) throws Error {

		if (a == 0 || b == 0 || c == 0) {
			throw new Error(1);
		}
		if (a < 0 || b < 0 || c < 0) {
			throw new Error(2);
		}
		if (a + b < c || a + c < b || b + c < a) {
			throw new Error(3);
		}

		this.Nev = nev;
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/* (non-Javadoc)
	 * @see hf4.KeruletSzamithato#computeKerulet()
	 */
	public float computeKerulet() {
		return (a + b + c);
	}

    //Heron keplet
	/* (non-Javadoc)
     * @see hf4.KeruletTeruletSzamithato#computeTerulet()
     */
    public float computeTerulet() {
		float s = computeKerulet() / 2;
		float z = (float) Math.sqrt(s * (s - a) * (s - b) * (s - c));
		return z;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "H�romsz�g [N�v=" + Nev + ", a=" + a + ", b=" + b + ", c=" + c
				+ ", Ker�let=" + computeKerulet()
				+ ", Ter�let=" + computeTerulet() + "]";
	}

}

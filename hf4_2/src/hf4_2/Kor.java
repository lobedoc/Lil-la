package hf4_2;

/**
 * The Class Kor.
 */
public final class Kor extends Sokszogek implements KeruletTeruletSzamithato
{
	
	/** The s. */
	int s;
	
	/** The Nev. */
	String Nev;
	
	/**
	 * Instantiates a new kor.
	 *
	 * @param nev the nev
	 * @param s the s
	 * @throws Error the error
	 */
	public Kor(String nev, int s) throws Error {

		if (s == 0) {
			throw new Error(1);
		}
		if (s < 0) {
			throw new Error(2);
		}

		this.s = s;
		this.Nev = nev;
	}

	/* (non-Javadoc)
	 * @see hf4.KeruletSzamithato#computeKerulet()
	 */
	public float computeKerulet() {
		return (float) (2 * (s * Math.PI));
	}

	/* (non-Javadoc)
	 * @see hf4.KeruletTeruletSzamithato#computeTerulet()
	 */
	public float computeTerulet() {
		return (float) (((s * s) + Math.PI));
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Kor [s=" + s + ", Nev=" + Nev + ", Kerulet="
				+ computeKerulet() + ", Terulet=" + computeTerulet()
				+ "]";
	}


}

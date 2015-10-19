package hf4_2;



public class Main extends Gui
{
	private static final long serialVersionUID = 1L;

	public Main(String title) {
		super(title);
	}
	
	public static void main(String[] args) throws Error {
		new Gui("***** Sokszogek *****");
		
		Sokszogek[] sokszog = new Sokszogek[4];
		Kor[] kor = new Kor[3];
		
		try {
		sokszog[0] = new Haromszog("Horomszog", 3, 4, 5);
		System.out.println(sokszog[0]);
		} catch (Error s) {
			s.except();
		}
		System.out.println("\n");
		try {
			sokszog[2] = new Negyszog("Negyszog", 3, 4, 5, 9);
			System.out.println(sokszog[2]);
		} catch (Error s) {
			s.except();
		}
		System.out.println("\n");
		try {
			kor[0] = new Kor("Kor", 10);
			System.out.println(kor[0]);
		} catch (Error s) {
			s.except();
		}
		System.out.println("\n::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("\nKivetelkezeles teszt Haromszogre:");
		try {
			sokszog[1] = new Haromszog("Haromszog", 3, 0, 5);
			System.out.println(sokszog[1]);
			} catch (Error s) {
				s.except();
			}
		System.out.println("\nKivetelkezeles teszt Negyszegre:");
		try {
			sokszog[2] = new Negyszog("Negyszog", 0, 4, 5, 9);
			System.out.println(sokszog[2]);
		} catch (Error s) {
			s.except();
		}
		System.out.println("\nKivetelkezeles teszt Korre: ");
		try {
			kor[1] = new Kor("Kor", 0);
			System.out.println(kor[1]);
		} catch (Error s) {
			s.except();
		}
		
		
	}

}

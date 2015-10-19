package hf3;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player p1 = new Player("asd123", "Jamal Hassan");
		Player p2 = new Player("asd321", "Abdul Gersak");
		
		
		for(int i = 1; i != 10; i++)
		{
		System.out.println("A(z) " + i + "-dik" + " korben");	
		p1.throwShape().battle(p2.throwShape());
		System.out.println("Player 1: " + p1.getName() + ": " + Player.toCompare.get(0));
		System.out.println("Player 2: " + p2.getName() + ": " + Player.toCompare.get(1));
				
		
		Player.toCompare.clear();
		System.out.println("\n");
		}
		System.exit(0);
	}	
}

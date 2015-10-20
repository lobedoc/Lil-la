package hf6_2;

import hf6_2.Ingredients.Osszetevok;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		Olga piskota = new Olga();
		Masa krem = new Masa();
		Irina bevonat = new Irina();
		Thread t1 = new Thread(piskota);
		Thread t2 = new Thread(krem);
		Thread t3 = new Thread(bevonat);
		Ingredients.getRandom();
	
			t1.start();
			t2.start();
			t3.start();
			System.out.println(Ingredients.kihagy.get(0));



			
		
		//System.out.println("\nTorta kesz.");

	}

}

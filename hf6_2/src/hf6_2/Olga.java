package hf6_2;

import hf6_2.Ingredients.Osszetevok;

public class Olga implements Runnable {
	
	public void run() {
		
		//EnumSet<Ingredients.Osszetevok> cuccok = EnumSet.of(Ingredients.Osszetevok.TOJAS, Ingredients.Osszetevok.LISZT, Ingredients.Osszetevok.CUKOR, Ingredients.Osszetevok.SUTOPOR, Ingredients.Osszetevok.VAJ);
		Ingredients mixeli = new Ingredients();

		if(Osszetevok.TOJAS.getSzabad() == 0 && Osszetevok.LISZT.getSzabad() == 0 && Osszetevok.CUKOR.getSzabad() == 0 && Osszetevok.SUTOPOR.getSzabad() == 0 && Osszetevok.VAJ.getSzabad() == 0)
		{

			System.out.println("Olga varakozik az osszetevokre.");

		
		}
		else
		{
			Osszetevok.TOJAS.setSzabad(0);
			Osszetevok.LISZT.setSzabad(0);
			Osszetevok.CUKOR.setSzabad(0);
			Osszetevok.SUTOPOR.setSzabad(0);
			Osszetevok.VAJ.setSzabad(0);
			Ingredients.varakozik = 0;
			System.out.println("Olga kimeri a hozzavalokat.");
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Osszetevok.TOJAS.setSzabad(1);
			Osszetevok.LISZT.setSzabad(1);
			Osszetevok.CUKOR.setSzabad(1);
			Osszetevok.SUTOPOR.setSzabad(1);
			Osszetevok.VAJ.setSzabad(1);
			Ingredients.varakozik = 1;
			System.out.println("Olga visszarakja hozzavalokat.");
			
		}
		if(mixeli.szabade_mixer == 1)
		{
		mixeli.keszit(1);
		System.out.println("Olga a mixert hasznalja.");
		
		}
		else
		{
			System.out.println("Olga varakozik a mixerre");
		}

		System.out.println("Olga piskotaja kesz.");
		
	}

}

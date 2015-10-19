package hf6_2;

import hf6_2.Ingredients.Osszetevok;

public class Irina implements Runnable {

	public void run() {
	
	//EnumSet<Osszetevok> cuccok = EnumSet.of(Osszetevok.KAKAO, Osszetevok.CUKOR, Osszetevok.VIZ, Osszetevok.VAJ);
	//Ingredients mixeli = new Ingredients();
	while(Ingredients.varakozik != 1)
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	if(Osszetevok.KAKAO.getSzabad() == 0 && Osszetevok.CUKOR.getSzabad() == 0 && Osszetevok.VIZ.getSzabad() == 0 && Osszetevok.VAJ.getSzabad() == 0)
	{		

		System.out.println("Irina varakozik az osszetevokre.");

	
	
		
	}
	else
	{
		Osszetevok.KAKAO.setSzabad(0);
		Osszetevok.CUKOR.setSzabad(0);
		Osszetevok.VIZ.setSzabad(0);
		Osszetevok.VAJ.setSzabad(0);
		Ingredients.varakozik = 0;
		System.out.println("Irina kimeri a hozzavalokat.");
		
		
		Osszetevok.KAKAO.setSzabad(1);
		Osszetevok.CUKOR.setSzabad(1);
		Osszetevok.VIZ.setSzabad(1);
		Osszetevok.VAJ.setSzabad(1);
		Ingredients.varakozik = 1;
		System.out.println("Irina visszarakja hozzavalokat.");
		
	}
	
	System.out.println("Irina fedele kesz.");
		
		}
}  
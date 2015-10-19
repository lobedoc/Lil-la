package hf6_2;

import hf6_2.Ingredients.Osszetevok;

public class Masa implements Runnable {
	
public void run() {
	
	//EnumSet<Ingredients.Osszetevok> cuccok = EnumSet.of(Ingredients.Osszetevok.TEJSZIN, Ingredients.Osszetevok.EPER, Ingredients.Osszetevok.CUKOR, Ingredients.Osszetevok.ZSELATIN);
	Ingredients mixeli = new Ingredients();
	while(Ingredients.varakozik != 1)
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	if(Osszetevok.TEJSZIN.getSzabad() == 0 && Osszetevok.EPER.getSzabad() == 0 && Osszetevok.CUKOR.getSzabad() == 0 && Osszetevok.ZSELATIN.getSzabad() == 0)
	{

		System.out.println("Masa varakozik az osszetevokre.");

	
	
	}
	else
	{
		Osszetevok.TEJSZIN.setSzabad(0);
		Osszetevok.EPER.setSzabad(0);
		Osszetevok.CUKOR.setSzabad(0);
		Osszetevok.ZSELATIN.setSzabad(0);
		Ingredients.varakozik = 0;
		System.out.println("Masa kimeri a hozzavalokat.");
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Osszetevok.TEJSZIN.setSzabad(1);
		Osszetevok.EPER.setSzabad(1);
		Osszetevok.CUKOR.setSzabad(1);
		Osszetevok.ZSELATIN.setSzabad(1);
		Ingredients.varakozik = 1;
		System.out.println("Masa visszarakja hozzavalokat.");
	
	}
	if(mixeli.szabade_mixer == 1)
	{
	mixeli.keszit(1);
	System.out.println("Masa a mixert hasznalja.");
	}
	else
	{
		System.out.println("Masa var a mixerre.");
	}

	System.out.println("Masa kremje kesz.");
		
	}

}

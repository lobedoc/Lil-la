package hf6_2;

public class Ingredients {
	
	public volatile int szabade_mixer = 1;
	public static volatile int varakozik = 0;
	Ingredients()
	{
		//synchronized(this)
		{
	    this.setSzabad(szabade_mixer);
		}
	}
	public int getSzabad() {
	    return szabade_mixer;
	  }
	public void setSzabad(int szabade_mixer) {
		this.szabade_mixer = szabade_mixer;
	  }

	public enum Osszetevok 
	{ 
		TOJAS(1), LISZT(1), CUKOR(1), SUTOPOR(1), VAJ(1), TEJSZIN(1), EPER(1), ZSELATIN(1), KAKAO(1), VIZ(1); 
		
		protected volatile int szabad = 1;
		
		Osszetevok(int szabad) {
			//synchronized(this)
			{
		    	
		    this.setSzabad(szabad);
		    
			}
		  }
		public int getSzabad() {
		    return szabad;
		  }
		public void setSzabad(int szabad) {
			this.szabad = szabad;
		  }
	}

	public synchronized void keszit(int szabade_mix)
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		szabade_mix = 0;

	}
}

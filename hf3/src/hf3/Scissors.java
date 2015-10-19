package hf3;

public class Scissors extends Shape{
	public String name = "Scissors";
	public void battle(Shape other) {
		if(other.getName().equals(this.name))
		{
			System.out.println("Dontetlen");
		}
		else if(other.getName().equals("Stone")){
			System.out.println("Az Scissors vesztett");
		}
		else if(other.getName().equals("Paper"))
		{
			System.out.println("Az Scissors nyert");
		}
				
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}

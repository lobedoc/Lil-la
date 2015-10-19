package hf3;

public abstract class Shape {
	public String name = "Shape";
	public void battle(Shape other) {
		other.battle(this);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

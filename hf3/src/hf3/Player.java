package hf3;

import java.util.ArrayList;
import java.util.Random;

public class Player {
	private String ID = null;
	private String name = null;
	Rock rock = new Rock();
	Paper paper = new Paper();
	Scissors scissors = new Scissors();
	public static ArrayList<String> toCompare = new ArrayList<String>();
	private Shape choice;
	int index = 0;
	private ArrayList<Object> spc = new ArrayList<Object>();
			
	public Player(String ID, String name) {
		super();
		this.setID(ID);
		this.setName(name);
	}

	public Shape throwShape() {
		spc.add(rock);
		spc.add(paper);
		spc.add(scissors);
		Random rand = new Random();
		index = rand.nextInt(3);
		choice = (Shape) spc.get(index);
		toCompare.add(choice.getName().toString());
		return choice;		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

}

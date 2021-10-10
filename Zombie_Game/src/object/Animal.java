package object;

public class Animal extends Unit{

	public Item.itemType itype;

	public Animal(String name, int hp, int attack, int speed, Item.itemType itype) {
		super(name, hp, attack, speed);

		this.itype = itype;

	}
}
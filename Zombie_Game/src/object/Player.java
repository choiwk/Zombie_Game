package object;

import java.util.*;

import object.Item.itemType;

public class Player extends Unit{

	public ArrayList<Item> inventory = new ArrayList<Item>();
	public Item.itemType weapon;

	public Player(String name,int hp,int attack){
		super(name, hp, attack,0);

	}

	public void Player_info() {


		System.out.println();
		System.out.println("=============="+name+"의 정보=============");
		System.out.println();
		System.out.println(name+"의 생명력 : "+ hp);
		System.out.println("공격력 : " + attack);
		System.out.println("속도 : "+ speed);
		if(weapon == null) {
			System.out.println("장착된 무기 : 무기가 존재하지 않습니다.");
		}
		else {
			System.out.println("장착된 무기 : "+weapon+"");
		}
		if(weapon == weapon.나이프) {
			System.out.println("무기 공격력 : 15");
		}
		else if(weapon == weapon.Z_WEAPON)
			System.out.println("무기 공격력 : 30");
		System.out.println();
		System.out.println("=====================================");   	
	}

	public void printInventory() { //아이템이 증가한 만큼 index증가.
		int index=1;
		for(Item i:inventory) {
			System.out.println("[" + index + "]:" +i.itype);
			index++;
		}
	}

	public void attachWeapon(itemType weapon) {  //무기장착

		if(this.weapon != null) {

			if(this.weapon==Item.itemType.나이프) {
				this.attack -= 15;
				this.inventory.add(new Item(Item.itemType.나이프));
			}else if(this.weapon==Item.itemType.Z_WEAPON) {
				this.attack -= 30;
				this.inventory.add(new Item(Item.itemType.Z_WEAPON));
			}
		}
		this.weapon = weapon;
		updateWeapon();
	}

	private void updateWeapon() {

		if(weapon==Item.itemType.나이프) {
			this.attack += 15;
		}else if(weapon==Item.itemType.Z_WEAPON) {
			this.attack += 30;
		}

	}



}

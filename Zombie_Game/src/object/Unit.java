package object;

import java.util.*;

public class Unit {

	public static int SPEED_MAX = 101;

	public String name;
	public int hp;
	public int attack;
	public int speed;

	public Unit(String name,int hp,int attack,int speed) {
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		this.speed = speed;
	}
public void HP_info() {
	System.out.println();
	System.out.println(name+"의 생명력 : "+ hp );
	System.out.println();
}
	public void information() {
		System.out.println();
		System.out.println("=============="+name+"의 정보=============");
		System.out.println();
		System.out.println(name+"의 생명력 : "+ hp );
		System.out.println(name+"의 일반공격 : " + attack);
		System.out.println(name+"의 속도 : "+ speed);
		System.out.println();
		System.out.println("======================================");   	
	}
	
	public void normalizeMinusHP() {
		if(hp < 0) {
			hp = 0;
		}
	}

	public void attack(Unit u) {
		boolean retVal = u.be_damaged(this.attack);

		if(retVal) {
			System.out.println("공격에 성공하셨습니다");
		}
		else {
			System.out.println(u.name+"가 공격을 회피하였습니다");
		}
	
	}

	public boolean be_damaged (int attack){

		boolean val = new Random().nextInt(SPEED_MAX/(SPEED_MAX-this.speed))==0;// 100 -  20 = 얻어맞을 확률 : 80 
		if(val) { // 얻어맞았다!
			this.hp = this.hp - attack; // HP가 깎였다.
			return true; // 얻어맞은 사실을 알린다.
		}else return false; // 회피했다!
	}


	public boolean alive(){
		if(hp > 0) {
			return true;
		}
		return false;
	}
	

}

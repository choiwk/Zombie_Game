package action;

import java.util.Random; 
import java.util.Scanner;

import object.Animal;
import object.Enemy;
import object.Item;
import object.Player;
import object.Unit;
import object.Item.itemType;

public class Battle_Forest {
	
	private static final int NUM_OF_FOREST = 6;
	private static final int NUM_OF_ANIMAL = 4;
	private static int num_of_enemy_defeated = 0;

	public Battle_Forest(Player p){

		ItemController ic = new ItemController();
		Enemy e = null;
		Animal a = null;

		// 배틀 1

		while(p.alive()) {
			// 적 생성
			if(e == null || e.equals(null) || !e.alive() ) {
				// 적이 아직 생성되지 않았거나, 적이 죽었을 경우 새로 만들어준다.
				e = createRandomEnemy();
			}


			// 선택지 출력
			printOptions(e);

			// 사용자로부터 입력 받음 
			int sel;
			Scanner scanner = new Scanner(System.in);
			sel = scanner.nextInt();

			// 전투
			if(sel== 1) { if(!atomicBattle(p,e)) break;}
			// 사냥터로 이동
			
			else if(sel == 2) { 
				// 동물 생성
				if(a == null || !a.alive())  {
					// 동물이 아직 생성되지 않았거나, 동물이 죽었을 경우 새로 만들어준다.
					a = createRandomAnimal();
				}
				if(!atomcHunting(p,a)) break;}
			// 인벤토리 
			else if(sel==3) { ic.inventory(p); }
			// 사용자 정보 확인
			else if(sel == 4) { p.Player_info(); }
			// 상대방 정보 확인
			else if(sel == 5) { e.information(); }
			// 도망
			else if(sel== 6) { escape(e);
			}

			// 플레이어가 사망하면 프로그램 종료.
			if (!p.alive()) { break; }
		}
		return;
	}

	private boolean atomcHunting(Player p, Animal a) {
		// TODO Auto-generated method stub

		
		System.out.println("'"+a.name+"'를 사냥합니다.");
		p.attack(a);
		p.normalizeMinusHP();;

		// if 동물이 죽었나?
		if (!a.alive()) {
			System.out.println("'"+a.name+"'를 사냥하는데 성공하였습니다.");
			p.inventory.add(new Item(a.itype));
			return true;
		}

		// 적에게 공격당한다.
		System.out.println(p.name+"가 '"+a.name+"'에게 공격당합니다.");
		a.attack(p);
		a.normalizeMinusHP();

		// if-else 플레이어가 죽었나? 
		if (!p.alive()) {	
			System.out.println(p.name+"가 사망했습니다.");
			return false;
		}
		System.out.println();
		System.out.println("++ 상태 정보 ++" );
		System.out.println(		p.name+" HP :" +p.hp+"");
		System.out.println(		a.name+ "HP :" +a.hp+"");
		return true;
	}

	private void printOptions(Enemy e) {
		// TODO Auto-generated method stub
		System.out.println("📜📜📜📜📜📜📜📜📜📜📜📜📜 ⚔️ ☠︎ ⚔️ 📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜");
		System.out.println("📜 🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿📜");
		System.out.println("📜 🌳🌱| 1.좀비와 전투 | 2.동물사냥 | 3.인벤토리 | 4.생존자의 정보 | 5.'"+e.name+"'의 정보. | 6.도망가기🌿📜");
		System.out.println("📜 🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿📜");
		System.out.println("📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜");

	}

	private void escape(Enemy e) {
		// TODO Auto-generated method stub
		System.out.println("'"+e.name+"' 으로부터 도망쳤습니다.");
		System.out.println();
		e = null;

	}

	private Enemy createRandomEnemy() {

		Enemy e = null;
		Random rand = new Random();
		int random = rand.nextInt(NUM_OF_FOREST);
		
		if(random == 0) {
			System.out.println();
			System.out.println("     🎚 🎚 🎚 🎚 🎚 🎚 🎚 🎚");
			System.out.println("  🧟‍♂️ 🎚  남성좀비와 마주쳤습니다 🎚️");
			System.out.println("     🎚 🎚 🎚 🎚 🎚 🎚 🎚 🎚");
			System.out.println();
			e = new Enemy("남성좀비",100, 25, 40, Item.itemType.남성좀비_DNA,"",0); //여기서 생성

		}else if (random == 1) {
			System.out.println();
			System.out.println("    🎚 🎚 🎚 🎚 🎚 🎚 🎚 🎚");
			System.out.println(" 🧟‍♀️ 🎚  여성좀비와 마주쳤습니다 🎚️");
			System.out.println("    🎚 🎚 🎚 🎚 🎚 🎚 🎚 🎚");
			System.out.println();
			e = new Enemy("여성좀비",80, 15, 60, Item.itemType.여성좀비_DNA,"은신",10); //여기서 생성

		}else if (random == 2){
			System.out.println();
			System.out.println("   🎚 🎚 🎚 🎚 🎚 🎚 🎚 🎚");
			System.out.println(" ☣︎ 🎚  숙주좀비와 마주쳤습니다 🎚️");
			System.out.println("   🎚 🎚 🎚 🎚 🎚 🎚 🎚 🎚");
			System.out.println();
			e = new Enemy("숙주좀비",140, 30, 60, Item.itemType.숙주의_DNA,"핡퀴기",5); //여기서 생성

		}else if(random == 3) {
			System.out.println();
			System.out.println("     🎚 🎚 🎚 🎚 🎚 🎚 🎚 🎚");
			System.out.println("  🧟‍♂️ 🎚  남성좀비와 마주쳤습니다 🎚️");
			System.out.println("     🎚 🎚 🎚 🎚 🎚 🎚 🎚 🎚");
			System.out.println();
			e = new Enemy("남성좀비",100, 25, 40, Item.itemType.남성좀비_DNA,"물어뜯기",28); //여기서 생성

		
		}else if (random == 4){
			System.out.println();
			System.out.println("   🎚 🎚 🎚 🎚 🎚 🎚 🎚 🎚");
			System.out.println(" ☣︎ 🎚  숙주좀비와 마주쳤습니다 🎚️");
			System.out.println("   🎚 🎚 🎚 🎚 🎚 🎚 🎚 🎚");
			System.out.println();
			e = new Enemy("숙주좀비",140, 30, 60, Item.itemType.숙주의_DNA,"핡퀴기",5); //여기서 생성

		}
		else if (random == 5) {
		    System.out.println("   ‼️ ‼️ ‼️ ‼️   보스 출현  ‼️ ‼️ ‼️ ‼️ ️");
			System.out.println(" ☠︎ ‼️     보스 : 헌터와 마주쳤습니다      ‼️");
			 System.out.println("   ‼️ ‼️ ‼️ ‼️ ‼️️ ️‼️ ‼️ ‼️ ‼️ ‼️ ‼️️️️️");
			 System.out.println();
			e = new Enemy("헌터",180, 35, 55, Item.itemType.헌터의_피,"덮치기",20);

		}
		return e;
	}

	
	private Animal createRandomAnimal() {
		Animal a = null;
		Random rand = new Random();
		int random = rand.nextInt(NUM_OF_ANIMAL);

		if(random == 0) {
			System.out.println("맷돼지를 만났습니다.");
			a = new Animal ("멧돼지",80, 25, 15, Item.itemType.멧돼지의_송곳니); //여기서 생성

		}else if (random == 1) {
			System.out.println("사슴을 만났습니다.");
			a = new Animal("사슴",75, 5, 50, Item.itemType.사슴고기); //여기서 생성

		}else if (random == 2){
			System.out.println("뱀을 만났습니다.");
			a = new Animal("뱀",100, 15, 30, Item.itemType.뱀의_독); //여기서 생성

		}else if (random == 3) {
			System.out.println("토끼를 만났습니다");
			a = new Animal("토끼",30, 3, 58, Item.itemType.토끼고기);

		}
		return a;
	}

	public boolean atomicBattle(Player p, Enemy e) {

		// 적을 공격한다.
		System.out.println("          🗡      ");
		System.out.println("'"+e.name+"'를 공격합니다.");
		p.attack(e);
		p.normalizeMinusHP();

		// if-else 적이 죽었나?
		if (!e.alive()) {
			System.out.println("'"+e.name+"'를 해치웠습니다.");
			p.inventory.add(new Item(e.itype));
			num_of_enemy_defeated++;
			if(e.name.equals("헌터")) {
				System.out.println("STAGE 1 CLEAR : 숲에서 무사히 생존하셨습니다!");
				return false;
			}
		}
		// 적에게 공격당한다.
		System.out.println(p.name+"가 '"+e.name+"'에게 공격당합니다.");
		e.attack(p);
		e.normalizeMinusHP();
		boolean flag = true;
		int val = new Random().nextInt(3);
		if (val == 0 && e.hp <= 30) {
		
		e.보스스킬1(p);
		flag = false;
		 if (val == 1) {  }
		 else if (val == 2) { }
		else if (val == 3) { }
 		}
		// if-else 플레이어가 죽었나? 
		if (!p.alive()) {	
			System.out.println(p.name+"가 사망했습니다.");
			return false;
		}
		System.out.println();
		System.out.println("++ 상태 정보 ++" );
		System.out.println(		p.name+" HP :" +p.hp+"");
		System.out.println(		e.name+ "HP :" +e.hp+"");
		return true;
	}

}
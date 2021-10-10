package action;

import java.util.Random; 
import java.util.Scanner;

import object.Animal;
import object.Enemy;
import object.Item;
import object.Player;
import object.Unit;
import object.Item.itemType;

public class Battle {

	private static final int NUM_OF_ENEMY = 5;
	private static final int NUM_OF_ANIMAL = 4;
	private static int NUM_OF_ENEMY_DEFEATED = 0;

	public Battle(Player p){

		ItemController ic = new ItemController();
		Enemy e = null;
		Animal a = null;
		
		// 배틀 1

		while(p.alive()) {
			// 적 생성
			if(e == null || !e.alive()) {
				// 적이 아직 생성되지 않았거나, 적이 죽었을 경우 새로 만들어준다.
				a = createRandomAnimal();
				e = createRandomEnemy();
			}
			System.out.println("📜📜📜📜📜📜📜📜📜📜📜📜📜 ⚔️ ☠︎ ⚔️ 📜📜📜📜📜📜📜📜📜📜📜📜📜📜");
			System.out.println("📜 🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿📜");
			System.out.println("📜 🌳🌱| 1.전투 | 2.인벤토리 | 3.도망 | 4.생존자의 정보 | 5.'"+e.name+"'의 정보.🌿📜");
			System.out.println("📜 🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿🌱🌳🌿📜");
			System.out.println("📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜📜");

			int sel;
			Scanner scanner = new Scanner(System.in);
			sel = scanner.nextInt();

			// 전투
			if(sel== 1) { 

				// 적을 공격한다.
				System.out.println("'"+e.name+"'를 공격합니다.");
				p.attack(e);
				p.dead();

				// if-else 적이 죽었나?
				if (!e.alive()) {
					System.out.println("'"+e.name+"'를 해치웠습니다.");
					p.inventory.add(new Item(e.itype));
					NUM_OF_ENEMY_DEFEATED++;
					if(e.name.equals("헌터")) {
						System.out.println("STAGE 1 CLEAR : 숲에서 무사히 생존하셨습니다!");
						continue;
					}
				}

				// 적에게 공격당한다.
				System.out.println(p.name+"가 '"+e.name+"'에게 공격당합니다.");
				e.attack(p);
				e.dead();

				// if-else 플레이어가 죽었나? 
				if (!p.alive()) {	
					System.out.println(p.name+"가 사망했습니다.");
					break;
				}
				System.out.println();
				System.out.println("++ 상태 정보 ++" );
				System.out.println(		p.name+" HP :" +p.hp+"");
				System.out.println(		e.name+ "HP :" +e.hp+"");
				
			}

			// 인벤토리 
			else if(sel==2) {
				int input = 0;
				p.printInventory();
				System.out.println("어떤 아이템을 선택하시겠습니까? 조합:0 ");
				scanner = new Scanner(System.in);
				input = scanner.nextInt();
				Item sel_item = null, sel_item2 = null;

				if(input == 0) {

					System.out.println("어떤 아이템을 생성하시겠습니까?");
						System.out.println("-----------------무기----------------");
						System.out.println("[1] 나이프 = 뱀독 + 송곳니");
						System.out.println("[2] Z_Weapon = 나이프 + 헌터의 피");
						System.out.println("-----------------포션----------------");	
						System.out.println("[3] HP 포션 = 사슴고기 + 토끼고기");
						System.out.println("[4] 파워포션 = HP 포션 +  부머의 액체");
						System.out.println("---------------- DNA ----------------");
						System.out.println("[5] 좀비_DNA = 남성좀비_DNA + 여성좀비_DNA");
						System.out.println("[6] 백신_NA_항생제 = 좀비_DNA + 숙주의_DNA");
						System.out.println("[7] 백신_24_면역균 = 탱커_DNA + 위치_DNA");
						System.out.println( "[8] 백신 = 백신_NA_항생제 + 백신_24_면역균");
						System.out.println(" -----------------------------------");

					input = scanner.nextInt();

					// 아이템 제조
					
					if(input == 1) {
						ic.combinateItem(p, Item.itemType.뱀의_독, Item.itemType.멧돼지의_송곳니, Item.itemType.나이프);
					}else if(input == 3) {
						ic.combinateItem(p, Item.itemType.사슴고기, Item.itemType.토끼고기, Item.itemType.HP_포션);
					}else if(input == 2) {
						ic.combinateItem(p, Item.itemType.나이프, Item.itemType.헌터의_피, Item.itemType.Z_WEAPON);
					}else if (input == 4) {
						ic.combinateItem(p, Item.itemType.HP_포션, Item.itemType.부머의_액체, Item.itemType.파워_포션);
					}else if (input == 5) {
						ic.combinateItem(p, Item.itemType.남성좀비_DNA, Item.itemType.여성좀비_DNA, Item.itemType.좀비_DNA);
					}else if (input == 6) {
						ic.combinateItem(p, Item.itemType.좀비_DNA, Item.itemType.숙주의_DNA, Item.itemType.백신_NA_항생제);
					}else if (input == 7) {
						ic.combinateItem(p, Item.itemType.탱커_DNA, Item.itemType.위치_DNA, Item.itemType.백신_24_면역균);
					}else if (input == 8) {
						ic.combinateItem(p, Item.itemType.백신_NA_항생제, Item.itemType.백신_24_면역균, Item.itemType.백신);
					}
					// 재료

				}else if(!p.inventory.isEmpty()) {
					sel_item = p.inventory.get(input-1);
					System.out.println("선택된 아이템:"+sel_item.itype);

					// 플레이어 스탯에 관여하는 아이템류
					if(sel_item.itype == Item.itemType.사슴고기) {
						System.out.println("사용할 수 없습니다.");
						System.out.println("재료 : 사슴고기");

					}else if(sel_item.itype == Item.itemType.뱀의_독) {
						p.hp -= 20;
						System.out.println("재료 : 뱀의 독");

					}else if(sel_item.itype == Item.itemType.멧돼지의_송곳니) {
						System.out.println("사용할 수 없습니다.");
						System.out.println("재료 : 멧돼지의 송곳니");
						
					}else if(sel_item.itype == Item.itemType.토끼고기) {
						p.hp += 10;
						System.out.println("토끼고기를 사용하셨습니다 (+10)");

					}else if(sel_item.itype == Item.itemType.HP_포션) {
						p.inventory.remove(input-1);
						p.hp += 30;
						System.out.println("포션을 사용하셨습니다.(+30).");
						
					}else if(sel_item.itype == Item.itemType.부머의_액체) {
							System.out.println("(조합)아이템 : 사용할 수 없는 조합아이템 입니다.");
							System.out.println("+파워포션을 만들기 위한 재료.");
					
					}else if(sel_item.itype == Item.itemType.파워_포션) {
						p.inventory.remove(input-1);
						p.hp += 100;
						System.out.println("(고급)아이템 : '파워포션'을 사용하셨습니다.(+100).");
						
					}else if(sel_item.itype == Item.itemType.좀비_DNA) {
						System.out.println("(조합)아이템 : 사용할 수 없는 조합아이템 입니다.");
						System.out.println("+백신을 만들기 위한 재료.");
		
					}else if(sel_item.itype == Item.itemType.숙주의_DNA) {
						System.out.println("(조합)아이템 : 사용할 수 없는 조합아이템 입니다.");
						System.out.println("+백신을 만들기 위한 재료.");
						
					}else if(sel_item.itype == Item.itemType.백신_NA_항생제) {
							System.out.println("(조합)아이템 : 사용할 수 없는 조합아이템 입니다.");
							System.out.println("+백신을 만들기 위한 재료.");
			
					}else if(sel_item.itype == Item.itemType.탱커_DNA) {
						System.out.println("(조합)아이템 : 사용할 수 없는 조합아이템 입니다.");
						System.out.println("+백신을 만들기 위한 재료.");
		
					}else if(sel_item.itype == Item.itemType.위치_DNA) {
						System.out.println("(조합)아이템 : 사용할 수 없는 조합아이템 입니다.");
						System.out.println("+백신을 만들기 위한 재료.");
		
					}else if(sel_item.itype == Item.itemType.백신_NA_항생제) {
						System.out.println("(조합)아이템 : 사용할 수 없는 조합아이템 입니다.");
						System.out.println("+백신을 만들기 위한 재료.");
		
					}else if(sel_item.itype == Item.itemType.백신) {
						System.out.println("게임을 끝낼 수 있는 백신입니다");
						System.out.println("+백신을 만들기 위한 재료.");
		
					}
					
					// 무기 장착류
					else if(sel_item.itype == Item.itemType.나이프) {
						p.inventory.remove(input-1);
						p.attachWeapon(Item.itemType.나이프);
						System.out.println(sel_item.itype + "를 장착하여 공격력이 대폭 상승하였습니다(+15).");
					}
					else if(sel_item.itype == Item.itemType.Z_WEAPON) {
						p.inventory.remove(input-1);
						p.attachWeapon(Item.itemType.Z_WEAPON);
						System.out.println(sel_item.itype + "를 장착하여 공격력이 대폭 상승하였습니다(+30).");
					}
				}
			}

			// 도망
			else if(sel==3) {
				System.out.println("'"+e.name+"' 으로부터 도망쳤습니다.");
				System.out.println();
				e = null;
			}
		 
			else if(sel == 4) {
				p.Player_info();
			}
			
			else if(sel == 5) {
				e.information();
			}
			
			
			// 플레이어가 사망하면 프로그램 종료.
			if (!p.alive()) {
				break;
			}
		}
		return;
	}
	
	private Enemy createRandomEnemy() {

		Enemy e = null;
		Random rand = new Random();
		int random = rand.nextInt(NUM_OF_ENEMY);

		if(random == 0) {
			System.out.println("남성좀비와 마주쳤습니다");
			System.out.println();
			e = new Enemy("남성좀비",100, 25, 40, Item.itemType.남성좀비_DNA); //여기서 생성

		}else if (random == 1) {
			System.out.println("여성좀비와 마주쳤습니다");
			System.out.println();
			e = new Enemy("여성좀비",80, 15, 60, Item.itemType.여성좀비_DNA); //여기서 생성

		}else if (random == 2){
			System.out.println("!! 숙주좀비와 마주쳤습니다 !!");
			System.out.println();
			e = new Enemy("숙주좀비",140, 35, 60, Item.itemType.숙주의_DNA); //여기서 생성
			
		}else if (random == 3) {
			System.out.println("헌터를 만났습니다.");
			e = new Enemy("헌터",300, 30, 30, Item.itemType.헌터의_피);
			
		}else if (random == 4) {
			System.out.println("부머를 만났습니다");
			e = new Enemy("부머",50, 60, 0, Item.itemType.부머의_액체);
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

	
	

}

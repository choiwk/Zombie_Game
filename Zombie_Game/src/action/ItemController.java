package action;

import java.util.Scanner;

import object.Item;
import object.Player;

public class ItemController {
	
	ItemController(){ }

	public boolean combinateItem(Player p, Item.itemType material1, Item.itemType material2, Item.itemType result) {

		int index = 0, item1 = 0, item2 = 0;
				
		// 아이템을 전부 탐색하면서, 해당 두 아이템이 있는지를 검사한다.
		for(Item item: p.inventory) {
			if(item.itype == material1) { item1 = index; }
			if(item.itype == material2) { item2 = index; }
		
			index++;
		}
		
		if(item1 != 0 && item2 != 0) { // 두개의 아이템 모두 찾으면 조합한다.
			// 조합한 아이템들을 삭제한다.

			System.out.println("item1:"+item1+" item2:"+item2);
			p.inventory.remove(item1);
			
			if(item1 < item2)
				p.inventory.remove(item2-1);
			else
				p.inventory.remove(item2);
			
			// 조합된 결과물을 리스트에 추가한다.
			p.inventory.add(new Item(result));
			System.out.println(result+"가 완성되었습니다.");
			return true;
		}else {
			System.out.println("조합할 재료가 부족합니다.");
			return false;
		}
	}

	public void inventory(Player p) {
		// TODO Auto-generated method stub
		int input = 0;
		p.printInventory();
		System.out.println("[0] 아이템 조합하기 ");
		Scanner scanner = new Scanner(System.in);
		input = scanner.nextInt();
		Item sel_item = null, sel_item2 = null;

		if(input == 0) {

			 System.out.println("어떤 아이템을 생성하시겠습니까?");
				System.out.println("⚔️ ⚔️ ⚔️ ⚔️ ⚔️ ⚔️️ ️무기 ️⚔️ ⚔️ ⚔️ ⚔️ ⚔️️");
				System.out.println("⚔️ [1] 나이프 = 뱀의 독 + 멧돼지의 송곳니    ⚔️");	
				System.out.println("⚔️ [2] 노루의 창 = 나이프 + 노루의 뿔 1     ⚔️");
				System.out.println("⚔️ [3] Z_Weapon = 노루의 창 + 헌터의 피   ⚔️");
				System.out.println("⚔️ ⚔️ ⚔️ ⚔️ ⚔️ ⚔️ ⚔️ ⚔️ ⚔️ ⚔️ ⚔️ ⚔️ ⚔️");
				System.out.println();
				System.out.println("🍼 🍼 🍼 🍼 🍼 🍼  포션  🍼 🍼 🍼 🍼 🍼");	
				System.out.println("🍼 [4] HP 포션 = 사슴고기 + 토끼고기       🍼");
				System.out.println("🍼 [5] 파워포션 = HP 포션 +  부머의 액체    🍼");
				System.out.println("🍼 🍼 🍼 🍼 🍼 🍼 🍼 🍼 🍼 🍼 🍼 🍼 🍼");
				System.out.println();
				System.out.println("💉 🧬 💉 🧬 💉 🧬 DNA 💉 🧬 💉 🧬 💉 🧬");
				System.out.println("🧬 [6] 좀비_DNA = 남성좀비_DNA + 여성좀비_DNA🧬");
				System.out.println("💉 [7] 백신_NA_항생제 = 좀비_DNA + 숙주의_DNA💉");
				System.out.println("🧬 [8] 백신_24_면역균 = 탱커_DNA + 위치_DNA  🧬");
				System.out.println("💉 [9] 백신 = 백신_NA_항생제 + 백신_24_면역균 💉");
				System.out.println("🧬 💉 🧬 💉 🧬 💉 🧬 💉 🧬 💉 🧬 💉 🧬💉");

			input = scanner.nextInt();

			// 아이템 제조
			
			if(input == 1) {
				combinateItem(p, Item.itemType.뱀의_독, Item.itemType.멧돼지의_송곳니, Item.itemType.나이프);
			}else if(input == 3) {
				combinateItem(p, Item.itemType.사슴고기, Item.itemType.토끼고기, Item.itemType.HP_포션);
			}else if(input == 2) {
				combinateItem(p, Item.itemType.나이프, Item.itemType.헌터의_피, Item.itemType.Z_WEAPON);
			}else if (input == 4) {
				combinateItem(p, Item.itemType.HP_포션, Item.itemType.부머의_액체, Item.itemType.파워_포션);
			}else if (input == 5) {
				combinateItem(p, Item.itemType.남성좀비_DNA, Item.itemType.여성좀비_DNA, Item.itemType.좀비_DNA);
			}else if (input == 6) {
				combinateItem(p, Item.itemType.좀비_DNA, Item.itemType.숙주의_DNA, Item.itemType.백신_NA_항생제);
			}else if (input == 7) {
				combinateItem(p, Item.itemType.탱커_DNA, Item.itemType.위치_DNA, Item.itemType.백신_24_면역균);
			}else if (input == 8) {
				combinateItem(p, Item.itemType.백신_NA_항생제, Item.itemType.백신_24_면역균, Item.itemType.백신);
			}
			// 재료

		}else if(!p.inventory.isEmpty()) {
			useItem(p, input);
			
		}
		
	}

	private void useItem(Player p, int input) {
		// TODO Auto-generated method stub
		Item sel_item = p.inventory.get(input-1);
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

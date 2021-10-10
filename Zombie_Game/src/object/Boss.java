package object;
import object.Item.itemType;

public class Boss extends Enemy{

	String skill;
	int skill_d;
	
	public Boss(String name, int hp, int attack, int speed, itemType itype, String skill,int skill_d) {
		super(name, hp, attack, speed, itype, skill, skill_d);
		this.skill = skill;
		this.skill_d = skill_d;
	}

	void 보스정보() {
		System.out.println();
		System.out.println("=============="+name+"의 정보=============");
		System.out.println();
		System.out.println(name+"의 생명력 : "+ hp );
		System.out.println(name+"의 일반공격 : " + attack);
		System.out.println(name+"의 속도 : "+ speed);
		System.out.println();
		System.out.println(name+"의 스킬 :"+ skill);
		System.out.println(name+"의 스킬데미지 :"+ skill_d);
		System.out.println();
		System.out.println("=====================================");   	
	}

	void 보스공격 (Player p) {

		System.out.println();
		System.out.println(name+"가 생존자를 공격하였습니다!");
		p.hp -= attack;
	}

	public void 보스스킬1 (Player p) {
		System.out.println();
		System.out.println(name+" 이(가)"+skill+"을(를) 사용하였습니다!");
		System.out.println(name+"가 생존자를 공격하였습니다!");
		p.hp -= attack;
	}
	 

	public void 연타(Player p) {
		p.hp -= 10;
		System.out.println("위치의 연타공격");
		System.out.println(p.hp);
	}

	/*void 랜덤값() {
		Random random = new Random();
		System.out.println(random.nextInt(10));
		Boss. = random.nextInt(10);
	} */


	public void 연타공격(Player p) {  // 위치스킬

		while(p.hp > 30) {
			if(Math.random() < 0.8) {
				p.hp -= 8;
				System.out.println("데미지 -8");
				System.out.println(p.hp+ "의 HP : "+p.hp);
				if(Math.random() < 0.7) {
					p.hp -= 10;
					System.out.println("데미지 -10");
					System.out.println(p.name+"의 HP : "+p.hp);
				}
			} 

			else {
				System.out.println("위치의 공격에서 벗어나셨습니다!");
				break;
			}
		}
	}
}

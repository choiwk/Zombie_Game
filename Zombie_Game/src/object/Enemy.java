package object;

public class Enemy extends Unit{
	
	String skill;
	int skill_d;
	public Item.itemType itype;

	public Enemy(String name,int hp, int attack, int speed, Item.itemType itype,String skill,int skill_d) {

		super(name,hp,attack,speed);
		this.skill = skill;
		this.skill_d = skill_d;
		this.itype = itype;


	}

	public void 보스스킬1(Player p) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println(name+"가 '"+this.skill+"' 을(를) 사용하였습니다!");
		p.hp -= this.skill_d;
		System.out.println("스킬데미지 : "+skill_d);
	}

	
	
    
}

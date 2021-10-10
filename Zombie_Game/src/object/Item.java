package object;

public class Item {

	public enum itemType{
		사슴고기,
		뱀의_독,
		멧돼지의_송곳니,
		토끼고기,
		노루의_뿔,
		
		남성좀비_DNA,
		여성좀비_DNA,
		좀비_DNA,
		숙주의_DNA,	
		
		//Boss 의 아이템
		헌터의_피,
		부머의_액체,
		탱커_DNA,
		위치_DNA,
		
		나이프,
		노루의_창,
		HP_포션,
		
		파워_포션,
		Z_WEAPON,
		
		백신_NA_항생제, 
		백신_24_면역균,
		
		백신
	}
	
	public itemType itype;
	
	public Item(itemType itype){
		this.itype = itype;
		
	}
	
	
}

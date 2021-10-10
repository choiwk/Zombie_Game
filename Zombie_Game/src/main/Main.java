package main;

import action.Battle_Cave;
import action.Battle_Forest;
import action.Battle_Road;
import object.*;

public class Main {

	public static void main(String[] args) {

		Player p1 = new Player("생존자", 10000, 40);
		Main main = new Main();
		// 맵
		Battle_Forest forest = new Battle_Forest(p1);
		Battle_Cave cave = new Battle_Cave(p1);
		Battle_Road road = new Battle_Road(p1);

		아이템_글 글 = new 아이템_글();

	}
}

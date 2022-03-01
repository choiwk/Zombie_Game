# Zombie_Game
2020년 java로 Console 게임을 개발하였습니다.

<br/>

### 구조도
```html
├── action
│   ├── Battle_Cave.java
│   ├── Battle_Forest.java
│   ├── Battle_Road.java
│   └── ItemController.java
├── main
│   └── Main.java
└── object
    ├── Animal.java
    ├── Boss.java
    ├── Enemy.java
    ├── Item.java
    ├── Player.java
    ├── Unit.java
    └── 아이템_글.java
```

## 게임 설명
- 플레이어는 좀비를 처치하고 좀비에게 아이템을 흭득하고 최종적으로 백신을 만들어서 마지막 스테이지까지 살아남아야 합니다.
- 좀비를 처치하고 여러 스테이지(숲, 동굴, 다리)를 무사히 통과하고 도착 지점으로 무사히 귀환하세요.
- 스테이지마다 다양한 보스 좀비들을 만날 수 있습니다. (확률적으로 나타나지 않을 수 있음) 랜덤 한 좀비를 쓰러트려 아이템을 흭득합니다.

### 🧟‍♂️ 좀비
일반적인 좀비는 남, 여로 구분되어 있습니다.
보스 좀비는 5종류가 있습니다. 보스 좀비에 따라 특유 특성 기술을 보유하고 있습니다.
모든 좀비는 가지고 있는 회피 확률로 플레이어의 공격을 피할 수 있습니다.
모든 좀비의 능력치는 모두 다릅니다.

### 🧩 게임 흐름
이동 중 랜덤 한 수의 좀비와 마주칩니다. 좀비를 처치하면 아이템을 흭득할 수 있습니다.
아이템을 제조하여 체력 회복 포션과 무기를 제조하고 더 강한 보스 좀비를 위한 대비를 하여야 합니다.

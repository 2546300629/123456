package cn.com.offcn.day04;

import java.util.Scanner;

public class GameStart {
    public static void main(String[] args) {
        Player p1 = createPlayer();
        while(p1.getName().equals("")) {
            System.out.println("玩家1创建角色不合法");
            p1 = createPlayer();
        }
        Player p2 = createPlayer();
        while (p2.getName().equals("") || p2.getName().equals(p1.getName())) {
            System.out.println("玩家2创建角色不合法");
            p2 = createPlayer();
        }
        int turn = 1;
        int max = 0;
        Map map = new Map();
        map.createMap();
        while(max < 100) {
            System.out.println();
            System.out.println("玩家1的位置为" + p1.getLocal() +"玩家2的位置为" + p2.getLocal());
            Game.gameOn(turn,p1,p2,map);
            int local1 = p1.getLocal();
            int local2 = p2.getLocal();
            if (local1 > local2) {
                max = local1;
            }else {
                max = local2;
            }
            turn++;
        }
        if (p1.getLocal() > p2.getLocal()) {
            System.out.println("恭喜玩家" + p1.getName() +"获得胜利");
        }else{
            System.out.println("恭喜玩家" + p2.getName() +"获得胜利");
        }
    }

    public static Player createPlayer () {
        System.out.println("请创建你的角色");
        System.out.println("##################################");
        System.out.println("1.麦克   2.卡森");
        PlayEnum play2 = PlayEnum.A;
        PlayEnum play1 = PlayEnum.B;
        Scanner sc = new Scanner(System.in);
        int i = 0;
        try {
            i = sc.nextInt();
        } catch (Exception e) {
            System.out.println("请选择系统中存在的角色进行创建");
            createPlayer();
        }
        if (i == 1) {
            System.out.println("创建角色：" + play1.name());
            Player p1 = new Player(play1.name(), 0);
            System.out.println(p1.getName());
            return p1;
        }else if (i == 2){
            return new Player(play2.name(),0);
        } else {
            System.out.println("创建失败");
            return new Player("",0);
        }
    }
}

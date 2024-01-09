package cn.com.offcn.day04;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    //对局更新
    public static void gameOn(int turn, Player p1, Player p2, Map map) {
        int i;  //  当前玩家移动之后的位置
        String event;   //  当前玩家触发的事件
        System.out.println();
        System.out.print("请输入任意key来掷骰子：");
        Scanner sc = new Scanner(System.in);
        //  当前对局数为单数
        if (turn == 1 || turn % 2 != 0) {
            if (turn > 1) {
                System.out.println();
                System.out.println("现在由玩家1：" + p1.getName() + "投骰子");
            }
            sc.next();
            i = movePlayer(p1.getName(), p1.getLocal());    //  玩家1开始移动
            p1.setLocal(i); //  更新玩家1的位置
            map.showMap(i, p2.getLocal());   //  显示更新后的角色站位
            System.out.println();   //  换行
            setEvent(turn, p1, p2, map, i);
        } else {
            System.out.println();
            System.out.println("现在由玩家2：" + p2.getName() + "投骰子");
            sc.next();
            i = movePlayer(p2.getName(), p2.getLocal());    //  玩家2开始移动
            p2.setLocal(i); //  更新玩家2的角色位置
            map.showMap(p1.getLocal(), i);   //  更新角色站位
            setEvent(turn, p2, p1, map, i);
        }
    }

    private static void setEvent(int turn, Player p1, Player p2, Map map, int i) {
        String event;
        event = locationCheck(i);   //  更新玩家1是否触发事件
        switch (event) {
            case "luck":
                runLuck(p1, p2, map);
                break;
            case "land":
                runLand(p1);
                break;
            case "pause":
                System.out.println("玩家" + p1.getName() + "的回合被跳过");
                turn++;
                gameOn(turn, p2, p1, map);
                break;
            case "time":
                System.out.println("玩家" + p1.getName() + "不小心进入了时空隧道");
                int local = p1.getLocal() + 5;
                p1.setLocal(local);
                break;
            default:
                System.out.println("无事发生");
                break;
        }
        turn++;
    }

    //  更新角色位置
    public static int movePlayer(String pname, int address) {
        Random random = new Random();
        int index = random.nextInt(6) + 1;
        System.out.println(pname + "掷骰子结果为" + index);
        index += address;
        return index;
    }

    //判断玩家脚下是否触发效果
    public static String locationCheck(int address) {
        int[] luckyTurn = {6, 23, 40, 55, 69, 83}; //幸运轮盘
        int[] landMine = {5, 13, 17, 33, 38, 50, 64, 80, 94};   //地雷位置
        int[] pause = {9, 27, 60, 93};         //暂停
        int[] timeTunnel = {20, 25, 45, 63, 72, 88, 90};   //时空隧道
        //幸运轮盘检查
        int isLuck = Arrays.binarySearch(luckyTurn, address);
        int isLand = Arrays.binarySearch(landMine, address);
        int isPause = Arrays.binarySearch(pause, address);
        int isTime = Arrays.binarySearch(timeTunnel, address);
        if (isLuck >= 0) {
            return "luck";
        } else if (isLand >= 0) {
            return "land";
        } else if (isPause >= 0) {
            return "pause";
        } else if (isTime >= 0) {
            return "time";
        } else {
            return "";
        }
    }

    //处理幸运轮盘效果
    public static void runLuck(Player p1, Player p2, Map map) {
        String name1 = p1.getName();
        String name2 = p2.getName();
        System.out.println("恭喜玩家：" + name1 + "踩中幸运轮盘！！！！！！");
        System.out.println("/////////////////////////////////////");
        System.out.println("请选择你的奖励：   1.交换位置   2.轰炸");
        Scanner sc = new Scanner(System.in);
        try {
            int reward = sc.nextInt();
            if (reward == 1) {  //  交换位置
                System.out.println("玩家交换位置,当前玩家1位置为" + p1.getLocal() + "玩家2位置为" + p2.getLocal());
                int local = p1.getLocal();
                p1.setLocal(p2.getLocal());
                p2.setLocal(local);
                System.out.println("交换位置后玩家1位置为" + p1.getLocal() + "玩家2位置为" + p2.getLocal());
                map.showMap(p1.getLocal(), p2.getLocal());
            } else if (reward == 2) {   //  选择轰炸
                System.out.println("恭喜玩家：" + name2 + "被送回起点！！！");
                p2.setLocal(0);
            }
        } catch (Exception e) {
            System.out.println("您输入的选项有误，请重新输入");
            runLuck(p1, p2, map);
//            throw new RuntimeException(e);
        }
    }

    //  处理地雷效果
    public static void runLand(Player p1) {
        System.out.println("恭喜玩家：" + p1.getName() + "踩中地雷并成功被送回起点！！！");
        p1.setLocal(0);
    }
}

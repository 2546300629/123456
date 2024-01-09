package cn.com.offcn.day05;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Atm {
    private ArrayList<Banned> list = new ArrayList<>();

    //  测试
    public static void main(String[] args) {
        Atm atm = new Atm();
        atm.login("0230", 5);

    }

    //  初始化银行用户
    static ArrayList<Card> cardArrayList = new ArrayList<Card>();

    static {
        cardArrayList.add(new Card("0101", "Adam", "111111", GenderEnum.MALE, "美国建设银行伊甸分行", 23.4));
        cardArrayList.add(new Card("0100", "Eve", "000000", GenderEnum.FEMAE, "美国建设银行伊甸分行", 54.02));
        cardArrayList.add(new Card("6661", "嬴政", "888888", GenderEnum.MALE, "中国人民银行西安分行", 10000));
        cardArrayList.add(new Card("2220", "田大锤", "222222", GenderEnum.FEMAE, "中国人民银行翻斗总行", 12));
        cardArrayList.add(new Card("3331", "陈冠希", "123456", GenderEnum.MALE, "中国建设银行北京分行", 300));
        cardArrayList.add(new Card("2221", "坂本 银时", "010010", GenderEnum.MALE, "日本国独立银行歌舞伎分行", 50));
        cardArrayList.add(new Card("3001", "雅木茶", "1000000", GenderEnum.MALE, "日本国龙珠银行沙漠分行", 5));
        cardArrayList.add(new Card("0230", "Taylor Swift", "198912", GenderEnum.FEMAE, "美国音乐银行德莱克分行", 250.3));
    }


    public void loginFild(String uid, int count) {
        System.out.println("您还有" + count + "次机会," + count + "次登录失败后将冻结您的账户");
        if (count > 0) {
            login(uid, count);
        } else {
            Calendar now = Calendar.getInstance();
            this.list.add(new Banned(uid, now));
            System.out.println("由于您多次登录失败，系统已将您的账户自动冻结");
            login("", 5);
        }

    }

    //  显示登录页面
    public void login(String uid, int loginCount) {
        if (uid.equals("")) {
            System.out.println("未检测到您的银行卡，请手动输入您的卡号");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            uid = s;
        }
//        在冻结列表中寻找冻结账户
        for (Banned ban : this.list) {
            if (ban.getUid().equals(uid)) { //  如果找到对应用户
                Calendar calendar = Calendar.getInstance();
                String time = "" + calendar.get(Calendar.YEAR) + calendar.get(Calendar.MONTH) + calendar.get(Calendar.DAY_OF_MONTH);
                Calendar calendar1 = ban.getTime();
                String time1 = "" + calendar1.get(Calendar.YEAR) + calendar1.get(Calendar.MONTH) + calendar1.get(Calendar.DAY_OF_MONTH);
                if (time.equals(time1)) {
                    System.out.println("您的账户已被冻结，请明天再来");
                    login("", loginCount);
                }
            }
        }
        Card target = getTarget(uid);

        if (target.getUid().equals("")) {   //  系统中未找到对应用户
            System.out.println("您的卡号有误请检查您的卡号");
            //  弹出银行卡
            login("", 5);
        }

        System.out.println("$欢迎使用中公ATM机，请在下方输入您的登录信息$");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.print("请输入您的密码：");
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();

//        判断用户是否登录成功
        if (password.equals(target.getPassword())) {
            chooseEvent(target);    //  登录成功，进入选择业务页面
        } else {
            loginCount--;
            System.out.println("您输入的密码有误请重新输入，系统将在您第" + loginCount + "次登录失败后将您的账户冻结");
            loginFild(uid, loginCount);
        }
    }

    //    通过卡号寻找对应用户
    private Card getTarget(String uid) {
        Card target = new Card();   //  用于存储查询到的用户信息
        //        在系统中寻找对应用户
        for (Card card : cardArrayList) {
            if (card.getUid().equals(uid)) {
                target = card;
            }
        }
        return target;
    }

    //    判断用户性别与姓氏并返回欢迎语
    public String WellCome(Card card) {
        StringBuilder name = new StringBuilder();   //  用于存储最终返回的结果
        String uname = card.getUname(); //  用于存储用户的姓名
        GenderEnum gender = card.getGender();   //  获取用户性别
        //  获取用户的姓
        Pattern pattern = Pattern.compile("^[u9fa5_a-zA-Z]");   //  判断是否为英文名字
        Matcher matcher = pattern.matcher(uname);
        if (matcher.lookingAt()) {  //  英文用户
            if (uname.indexOf(" ") > 0) {   //  英文用户名有姓
                uname = uname.substring(0, uname.indexOf(" "));
                name.append(uname);
            } else {
                name.append(uname);
            }
        } else {    //  中文用户
            if (uname.indexOf(" ") > 0) {   //  中文用户名有空格
                uname = uname.substring(0, uname.indexOf(" "));
                name.append(uname);
            } else {
                uname = uname.substring(0, 1);
                name.append(uname);
            }
        }
        return "欢迎" + name + gender.getName() + "使用中公ATM";
    }

    //    用户选择要办理的业务
    public void chooseEvent(Card user) {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$" + "\n" + WellCome(user) + "\n" + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("请选择您要进行的业务:");
        System.out.println("1.查询余额      2.存款    3.取款    4.转账    0.退卡");
        Scanner sc = new Scanner(System.in);
        try {
            int event = sc.nextInt();
            switch (event) {
                case 1:     //  查询余额业务
                    System.out.println("执行查询业务");
                    System.out.println("你的余额为" + user.getMoney());
                    eventOver(user);
                    break;
                case 2:     //  存款业务
                    System.out.println("执行存款业务");
                    savingMoney(user);
                    eventOver(user);
                    break;
                case 3:     //  取款业务
                    System.out.println("执行取款业务");
                    Withdrawal(user);
                    eventOver(user);
                    break;
                case 4:     //  转账业务
                    System.out.println("执行转账业务");
                    transfer(user);
                    eventOver(user);
                    break;
                case 0:     //  退卡
                    System.out.println("退卡成功，请取走您的银行卡");
                    login("", 5);
                    break;
                default:
                    System.out.println("！！！本系统暂未开发此业务！！！");
                    chooseEvent(user);
                    break;
            }
        } catch (Exception e) {
            System.out.println("请选择系统中存在的业务进行办理");
            chooseEvent(user);
        }
    }

    //    执行存款业务
    public Card savingMoney(Card user) {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("请输入您的存款金额（退出请输入'0'）:");
        Scanner sc = new Scanner(System.in);
        try {
            double saving = sc.nextDouble();
//            金额的正则表达式
            Pattern pattern = Pattern.compile("(^[1-9](\\d+)?(\\.\\d{1,2})?$)|(^0$)|(^\\d\\.\\d{1,2}$)");
            Matcher matcher = pattern.matcher(saving + "");
            if (matcher.lookingAt()) {
                double save = user.getMoney() + saving;
                user.setMoney(save);
            } else {
                System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
                System.out.println("你的金额输入有误请重新输入格式如：100.00 这种格式的数值");
                System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
                savingMoney(user);
            }
        } catch (Exception e) {
            System.out.println("请输入正确的金额格式");
            savingMoney(user);
        }
        return user;
    }

    //    执行取款业务
    public Card Withdrawal(Card user) {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("您当前账户的余额为" + user.getMoney());
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("请输入您的要取出的金额（退出请输入'0'）:");
        Scanner sc = new Scanner(System.in);
        try {
            double taking = sc.nextDouble();
//            金额的正则表达式
            Pattern pattern = Pattern.compile("(^[1-9](\\d+)?(\\.\\d{1,2})?$)|(^0$)|(^\\d\\.\\d{1,2}$)");
            Matcher matcher = pattern.matcher(taking + "");
            if (matcher.lookingAt()) {
                double take = user.getMoney() - taking;
                if (pattern.matcher(take + "").lookingAt()) {
                    user.setMoney(take);
                    System.out.println("取款业务成功，您当前的账户余额为:" + user.getMoney());
                } else {
                    System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
                    System.out.println("对不起您的余额不足（" + user.getMoney() + "）");
                    System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
                    Withdrawal(user);
                }
            } else {
                System.out.println("你的金额输入有误请重新输入格式如：100.00 这种格式的数值");
                Withdrawal(user);
            }
        } catch (Exception e) {
            System.out.println("请输入系统中规定的输入格式");
            Withdrawal(user);
        }
        return user;
    }

    //    执行转账业务
    private void transfer(Card user) {
        System.out.println("!!!!!!!!!!!!谨防诈骗!!!!!!!!!!!!!!!");
        System.out.println("$$$$$$$$$$转账业务$$$$$$$$$$");
        System.out.println("请输入您要转入的卡号：");
        System.out.print("(输入0返回)");
        Scanner sc = new Scanner(System.in);
        String card = sc.nextLine();
        if (card.equals("0")) {
            chooseEvent(user);
        } else {
            Pattern isOk = Pattern.compile("^(yes|y|no|n)");
            Pattern pattern = Pattern.compile("[0-9]{3}(0|1)$");
            Matcher matcher = pattern.matcher(card);
            if (matcher.lookingAt()) {
                Card target = getTarget(card);
                if (target.getUname().equals("")) {
                    System.out.println("!!!!!!!!!!!!谨防诈骗!!!!!!!!!!!!!!!");
                    System.out.println("系统中不存在您输入的卡号，请确认您的转账对象存在于中公ATM机中");
                    transfer(user);
                } else if (target.getUid().equals(user.getUid())) {  //  转账对象为本卡
                    System.out.println("不支持本卡内转账，请重新选择您的转账对象");
                    transfer(user);
                } else {
                    System.out.println("请输入您要转出的金额：");
                    double money = sc.nextDouble();
                    if (cheakDouble(money)) {
                        transferImpl(user, isOk, target, money);
                    }
                }
            } else {
                System.out.println("您输入的卡号不符合格式请重新输入");
                transfer(user);
            }
        }

    }

    //    转账
    private void transferImpl(Card user, Pattern isOk, Card target, double money) {
        Scanner sc = new Scanner(System.in);
        while (money >= user.getMoney()) {
            System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
            System.out.println("对不起您的余额不足（" + user.getMoney() + "）请重新确认您的转账金额");
            System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
            try {
                money = sc.nextDouble();
            } catch (Exception e) {
                System.out.println("请输入正确的金额格式");
            }
        }
//                    计算手续费
        double premium = premiumComput(user.getOpenBank(), target.getOpenBank());
        double finalmoney = money * premium + money;
        while (finalmoney >= user.getMoney()) {
            System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
            System.out.println("对不起您的余额不足以支持此次转账（" + user.getMoney() + "）请重新确认您的转账金额");
            System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
            try {
                money = sc.nextDouble();
            } catch (Exception e) {
                System.out.println("请输入正确的金额格式");
            }
            finalmoney = money * premium + money;
        }
        System.out.println("!!!!!!!!!!!!谨防诈骗!!!!!!!!!!!!!!!");
        System.out.println("此次转账需要收取您" + premium + "元手续费请问您是否同意本次转账？（yes/no或y/n）");
        String check = sc.nextLine();

        boolean b = isOk.matcher(check).lookingAt();
        while (!b) {
            System.out.println("!!!!!!!!!!!!谨防诈骗!!!!!!!!!!!!!!!");
            System.out.println("请输入yes/no或以y/n表示同意与不同意本次转账");
            sc.nextLine();
            b = isOk.matcher(check).lookingAt();
        }
        if (check.startsWith("y")) {
            double balance1 = user.getMoney() - finalmoney;
            double balance2 = target.getMoney();
            user.setMoney(balance1);
            target.setMoney(balance2 + money);
        } else {
            System.out.println("本次转账结束");
        }
        System.out.println("您是否需要继续转账？（yes/no或y/n）");
        String goon = sc.nextLine();
        boolean b1 = isOk.matcher(goon).lookingAt();
        while (!b1) {
            System.out.println("!!!!!!!!!!!!谨防诈骗!!!!!!!!!!!!!!!");
            System.out.println("请输入yes/no或以y/n表示继续或停止向" + target.getUid() + "转账");
            sc.nextLine();
            b1 = isOk.matcher(goon).lookingAt();
        }
        if (goon.startsWith("y")) {
            System.out.println("请输入您要转出的金额：");
            money = sc.nextDouble();
            transferImpl(user, isOk, target, money);
        } else {
            transfer(user);
        }
    }

    //    检查输入的金额是否为正确金额
    public boolean cheakDouble(double money) {
        Pattern pattern = Pattern.compile("(^[1-9](\\d+)?(\\.\\d{1,2})?$)|(^0$)|(^\\d\\.\\d{1,2}$)");
        Matcher matcher = pattern.matcher(money + "");
        return matcher.lookingAt();
    }

    //    手续费计算器
    /*
     * 国内转账
     *   同行转账不需手续费
     *   不同行同区转账收取10%手续费
     *   不同行不同区转账收取12%手续费
     * 国外转账
     *   国外转账计算货币汇率并收取手续费
     * */
    private double premiumComput(String local, String target) {
//        String country1 = local.substring(0, local.indexOf("国") + 1);
//        String country2 = target.substring(0, target.indexOf("国") + 1);
//        if (country1.equals(country2)) {    //  同国转账
//            判断是否为同一家银行
        String bank1 = local.substring(0, local.indexOf("银行") + 2);
        String bank2 = target.substring(0, target.indexOf("银行") + 2);
        if (bank1.equals(bank2)) {
            return 0.0;     //  同行之间不收取手续费
        } else {
//                判断是否是同一区县的银行
            String zone1 = local.substring(local.indexOf("银行") + 3);
            String zone2 = target.substring(target.indexOf("银行") + 3);
            if (zone1.equals(zone2)) {
                return 0.10;    //  收取10%手续费
            } else {
                return 0.12;    //  收取12%手续费
            }
        }
//        } else {    //  国外转账    ATM中显示人民币储蓄
////            计算汇率：1美元 = 7.14人民币 = 144.80日元
//            double realmoney = 0;
//            switch (country1) {
//                case "美国":
//                    realmoney = money * 7.14;
//                    break;
//                case "中国":
//                    break;
//                case "日本国":
//                    break;
//                default:
//                    break;
//            }
//        }
    }

    //    计算汇率：1人民币 = 0.14美元 = 20.28日元
    public double exchangeComput(double money, String country) {
        double realmoney = 0;
        switch (country) {
            case "美国":
                realmoney = money * 0.14;
                break;

            case "日本国":
                realmoney = money * 20.28;
                break;
            case "中国":
                realmoney = money;
            default:
                break;
        }
        return realmoney;
    }

    //    业务结束
    private void eventOver(Card user) {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("请问您是否还需要办理其他业务？(yes/no)");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        Scanner sc1 = new Scanner(System.in);
        Pattern isOk = Pattern.compile("^(yes|y|no|n)");

        try {
            String s = sc1.nextLine();
            boolean b1 = isOk.matcher(s).lookingAt();
            while (!b1) {
                System.out.println("!!!!!!!!!!!!谨防诈骗!!!!!!!!!!!!!!!");
                System.out.println("请输入yes/no或以y/n表示继续或停止");
                s = sc1.nextLine();
                System.out.println(s);
                b1 = isOk.matcher(s).lookingAt();
            }
            if (s.startsWith("y")) {
                chooseEvent(user);
            } else {
                System.out.println("感谢您的使用，请记得取走您的银行卡");
                login("", 5);
            }
        } catch (Exception e) {
            eventOver(user);
        }
    }
}

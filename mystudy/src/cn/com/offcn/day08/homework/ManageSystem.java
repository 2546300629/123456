package cn.com.offcn.day08.homework;

import cn.com.offcn.day08.homework.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ManageSystem {

    //    录入成员信息
    public void installUser() {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("1001", "张一", "123456", "部门1", 200.84));
        list.add(new User("1002", "张二", "123456", "部门2", 500.01));
        list.add(new User("1003", "张三", "123456", "部门3", 20.00));
        list.add(new User("1004", "张四", "123456", "部门4", 1200.61));
        list.add(new User("1005", "张五", "123456", "部门5", 100000));
        FileOutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            os = new FileOutputStream("D:\\io\\homework.txt");
            oos = new ObjectOutputStream(os);
            oos.writeObject(list);
//            oos.close();
//            os.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //    显示欢迎界面
    public void wellcome(List<User> users, User user) {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("    员工" + user.getName() + "你好");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("1.显示所有员工信息    2.添加员工信息\n3.修改员工信息    4.删除员工信息\n5.模糊查询    0.退出登录");
        System.out.print("请选择您要执行的业务：");
        int i = inputNum(5);
        switch (i) {
            case 1:
                findAllUser(users, user);
                break;
            case 2:
                addUser(users, user);
                break;
            case 3:
                updateUser(users, user);
                break;
            case 4:
                delUser(users,user);
                break;
            case 5:
                findById(users, user);
                break;
            case 0:
                login();
                break;
        }

    }

//    根据工号模糊查询用户信息
    public void findById(List<User> users, User user) {
        System.out.println("????????????????????????????????????");
        System.out.println("              模糊查询");
        System.out.println("????????????????????????????????????");
        System.out.print("请输入要查询的工号:");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        List<User> list = new ArrayList<>();
        for(User u : users) {
            if (u.getId().contains(id)) {
                list.add(u);
            }
        }

        if (list.size() == 0) {   //  系统中不存在对应的数据
            System.out.println("未搜索到相应用户，输入1重新搜索或者输入0返回欢迎页面");
            int i = inputNum(1);
            if (i == 1) {
                findById(users,user);
            }else {
                System.out.println("即将为您跳转至欢迎页面，请稍候......");
                sleep(3000);
                wellcome(users,user);
            }
        }else {
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            System.out.println("              显示用户");
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            System.out.println("工号     姓名     部门     薪水");
            for (User user1 : list) {
                System.out.println(user1.getId() + "    " + user1.getName() + "    " + user1.getSector() + "    " + user1.getSalary());
            }
            System.out.println("请输入0返回欢迎页面");
            inputNum(0);
            System.out.println("正在为您跳转至欢迎页面，请稍候......");
            wellcome(users,user);
        }
    }

//    删除员工信息
    public void delUser(List<User> users, User user) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("              删除员工信息");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("请输入您要删除的工号：");
        boolean pass = false;
        String id = inputId();
        User target = null;
        for (User u : users) {
            if (u.getId().equals(id)) {
                target = u;
                break;
            }
        }
        ObjectOutputStream oos = null;
        if (target == null) {
            System.out.println("未找到对应用户，请确认您输入的id是否正确");
            delUser(users, user);
        }else {
            users.remove(target);   //  找到目标用户，删除
            try {
                oos = new ObjectOutputStream(new FileOutputStream("D:\\io\\homework.txt"));
                oos.writeObject(users);
                pass = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                if (oos != null) {
                    try {
                        oos.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (pass) {
                    System.out.println("目标用户删除成功，即将为您跳转回欢迎页面");
                    sleep(3000);
                    wellcome(users,user);
                }else {
                    System.out.println("目标用户删除失败，输入1重新删除，输入0将在3秒后为您返回欢迎页面");
                    int i = inputNum(1);
                    if (i == 1) {
                        delUser(users, user);
                    } else {
                        System.out.println("正在为您跳转欢迎页面......");
                        sleep(3000);
                        wellcome(users, user);
                    }
                }
            }
        }
    }

    //    修改员工信息
    public void updateUser(List<User> users, User user) {
        System.out.println("#######################################");
        System.out.println("              修改员工信息");
        System.out.println("#######################################");
        System.out.print("请输入您要修改的员工工号：");
        boolean pass = false;
        String id = inputId();
        User target = null;
        for (User u : users) {
            if (u.getId().equals(id)) {
                target = u;
                break;
            }
        }
        if (target == null) {
            System.out.println("未找到对应用户，请确认您输入的id是否正确");
            updateUser(users, user);
        } else {
            target.setId(id);
            System.out.println("当前员工的姓名为" + target.getName());
            System.out.println("请输入员工的新姓名：");
            Scanner sc = new Scanner(System.in);
            target.setName(sc.nextLine());
            pass = false;
            while (!pass) {
                System.out.println("请输入员工的新密码：");
                String password = sc.nextLine();
                System.out.println("请确认您所设置的密码：");
                String password1 = sc.nextLine();
                if (password.equals(password1)) {
                    pass = true;
                    target.setPassword(password);
                } else {
                    System.out.println("您两次输入的密码不一致，请重新输入");
                }
            }
            System.out.println("当前员工所在的部门为" + target.getSector());
            System.out.println("请输入员工所在的新部门：");
            target.setSector(sc.nextLine());
            System.out.println("当前员工的薪水为" + target.getSalary());
            System.out.println("请设置员工新的薪水：");
            target.setSalary(inputMoney());
            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(new FileOutputStream("D:\\io\\homework.txt"));
                oos.writeObject(users);
                pass = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                if (oos != null) {
                    try {
                        oos.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (pass) {
                    System.out.println("员工信息修改成功，3秒后为您返回欢迎页面");
                    sleep(3000);
                    wellcome(users, user);
                } else {
                    System.out.println("员工信息修改失败，输入1重新修改，输入0将在3秒后为您返回欢迎页面");
                    int i = inputNum(1);
                    if (i == 1) {
                        updateUser(users, user);
                    } else {
                        System.out.println("正在为您跳转欢迎页面......");
                        sleep(3000);
                        wellcome(users, user);
                    }
                }

            }

        }


    }

    //    添加员工信息
    public void addUser(List<User> users, User user) {
        System.out.println("######################################");
        System.out.println("            新员工信息录入");
        System.out.println("######################################");
        Scanner sc = new Scanner(System.in);
        boolean pass = false;   //  记录输入是否成功
        System.out.print("请输入新员工的工号：");
        String id = inputId();
        while (!pass) {
            pass = true;
            for (User u : users) {
                if (u.getId().equals(id)) {
                    pass = false;
                    System.out.println("您输入的工号已经存在请重新输入");
                    id = inputId();
                    break;
                }
            }
        }
        User user1 = new User();
        user1.setId(id);
        System.out.println("请输入新员工的姓名：");
        user1.setName(sc.nextLine());
        pass = false;
        while (!pass) {
            System.out.println("请输入新员工的密码：");
            String password = sc.nextLine();
            System.out.println("请确认您所设置的密码：");
            String password1 = sc.nextLine();
            if (password.equals(password1)) {
                pass = true;
                user1.setPassword(password);
            } else {
                System.out.println("您两次输入的密码不一致，请重新输入");
            }
        }
        System.out.println("请输入新员工所在的部门：");
        user1.setSector(sc.nextLine());
        System.out.println("请设置新员工的薪水：");
        user1.setSalary(inputMoney());
        List<User> list = users;
        list.add(user1);
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("D:\\io\\homework.txt"));
            oos.writeObject(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                    pass = true;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if (pass) {
            System.out.println("添加新员工成功，3秒后将返回欢迎页面");
            sleep(3000);
            wellcome(users, user);
        } else {
            System.out.println("添加新员工失败，请重新添加");
            addUser(users, user);
        }
    }

    //    输入工号格式校验
    public String inputId() {
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        String regex = "\\d{4}$";
        Pattern p = Pattern.compile(regex);
        boolean matches = p.matcher(id).matches();
        while (!matches) {
            System.out.println("您输入的员工工号不符合标准");
            System.out.println("工号应为4位长度的数字组合");
            System.out.print("请您重新输入工号：");
            id = sc.nextLine();
        }
        return id;
    }

    //    显示所有员工信息页面
    public void findAllUser(List<User> users, User user) {
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("              显示用户");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("工号     姓名     部门     薪水");
//        List<User> users = getUsers();
        for (User user1 : users) {
            System.out.println(user1.getId() + "    " + user1.getName() + "    " + user1.getSector() + "    " + user1.getSalary());
        }
        System.out.println("输入0返回欢迎页面");
        inputNum(0);
        wellcome(users, user);
    }

    //    显示登录页面
    public void login() {
        System.out.println("********************************************");
        System.out.println("             欢迎使用员工管理系统");
        System.out.println("********************************************");
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入员工id:");
        String id = sc.nextLine();
        List<User> users = getUsers();  //  获取系统中所有用户
        User loginUser = null;  //  当前正在登录的用户
        for (User user : users) {
            if (user.getId().equals(id)) {
                loginUser = user;
                break;
            }
        }
        if (loginUser == null) {    //  账号输入错误
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("账号输入错误或账号不存在，请重新输入");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            login();
        }
        System.out.print("请输入员工密码:");
        String password = sc.nextLine();
        int loginCount = 0;
        while (!loginUser.getPassword().equals(password)) {
            if (loginCount == 3) {
                System.out.println("您已输入错误3次，请重新进行登录");
                login();
                break;
            }
            System.out.println("密码输入错误，再输入错误3次请重新登录");
            loginCount++;
            System.out.println("您已输入" + loginCount + "次，请重新输入");
            password = sc.nextLine();
        }
        System.out.println("恭喜您登录成功即将为您跳转欢迎页面");
        sleep(3000);
        wellcome(users, loginUser);
    }

    //    输入金额
    public double inputMoney() {
        String regex = "(^[1-9](\\d+)?(\\.\\d{1,2})?$)|(^0$)|(^\\d\\.\\d{1,2}$)";
        Pattern p = Pattern.compile(regex);
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入金额：");
        double v = 0;
        try {
            v = sc.nextDouble();
            while (!p.matcher(v +"").matches()) {
                System.out.println("您输入的不是一个正确的金额，请重新输入");
                v = inputMoney();
            }
        } catch (Exception e) {
            System.out.println("////////////////////////////////////////");
            System.out.println("********您的输入的金额无效，请重新输入*********");
            System.out.println("////////////////////////////////////////");
            v = inputMoney();
        }
        return v;
    }


    //    用户输入数字选择业务
    public int inputNum(int eventNum) {
        String regex = "[0-" + eventNum + "]$";
        Scanner sc = new Scanner(System.in);
        int i = 0;
        try {
            i = sc.nextInt();
        } catch (Exception e) {
            System.out.println("////////////////////////////////////////");
            System.out.println("*************请正确请输入数字**************");
            System.out.println("////////////////////////////////////////");
            i = inputNum(eventNum);
        }
        String tips = "";
        if (eventNum == 0) {
            tips = "请输入0：";
            regex = "0";
        } else if (eventNum > 9) {
            tips = "请输入您所需的数字编号：";
            regex = "\\d+";
        }
        Pattern p = Pattern.compile(regex);
        boolean isMatch = p.matcher(i + "").matches();  //  检查是否满足输入要求

        if (!isMatch) {
            System.out.println("////////////////////////////////////////");
            System.out.println("********您的输入无效，请重新输入*********");
            System.out.println("////////////////////////////////////////");
            System.out.print(tips);
            i = inputNum(eventNum);
        }
        return i;
    }

    //  模拟加载时间
    private void sleep(int i) {
        try {
            Thread.currentThread().sleep(i);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //    读取本地保存的成员信息
    public List<User> getUsers() {
        List<User> list = null;
        ObjectInputStream oos = null;
        try {
            oos = new ObjectInputStream(new FileInputStream("D:\\io\\homework.txt"));
            Object o = oos.readObject();
            list = (List<User>) o;
//            for (User u : list) {
//                System.out.println(u.toString());
//            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return list;
        }
    }
}

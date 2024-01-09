package cn.com.offcn.day06;

import java.util.*;
import java.util.regex.Pattern;

public class BookManager {

    static ArrayList<Map<String, String>> books = new ArrayList<>();

    static {
        Map<String, String> bookMaps = new HashMap<String, String>();
        bookMaps.put("书名", "国学的读与做");
        bookMaps.put("作者", "潘志坚");
        bookMaps.put("分类", "国学");
        bookMaps.put("出版社", "华夏出版社");
        bookMaps.put("书号", "9787522203522");
        bookMaps.put("价格", "89");
        bookMaps.put("简介", "《国学的读与做》借鉴现代、后现代学术成果，对国学作了贯通性的理论解读，旨在阐发国学的内在精神和基本思想，揭示国学的理性基础和当代价值。");
        books.add(bookMaps);
        HashMap<String, String> bookMaps1 = new HashMap<String, String>();
        bookMaps1.put("书名", "新编老子道德经");
        bookMaps1.put("作者", "老子");
        bookMaps1.put("分类", "国学");
        bookMaps1.put("出版社", "外语教学与研究出版社");
        bookMaps1.put("书号", "9787521335972");
        bookMaps1.put("价格", "75");
        bookMaps1.put("简介", "春秋时期老子所著的《道德经》，是道家哲学思想的重要来源，也是中国历史上经典的名著之一");
        books.add(bookMaps1);
        Map<String, String> bookMaps2 = new HashMap<String, String>();
        bookMaps2.put("书名", "哈佛新编中国现代文学史");
        bookMaps2.put("作者", "王德威");
        bookMaps2.put("分类", "文学史");
        bookMaps2.put("出版社", "四川人民出版社");
        bookMaps2.put("书号", "9787220126970");
        bookMaps2.put("价格", "258");
        bookMaps2.put("简介", "《哈佛新编中国现代文学史》，以一百多个关键时刻为切入点，整部文学史起自1635年晚明文人杨廷筠（1562—1627）、友人艾儒略（1582—1649）等的“文学”新诠，止于当代作家韩松（1965— ）所幻想的2066年西行漫记“火星照耀美国”。");
        books.add(bookMaps2);
        Map<String, String> bookMaps3 = new HashMap<String, String>();
        bookMaps3.put("书名", "数据结构");
        bookMaps3.put("作者", "高秀娥");
        bookMaps3.put("分类", "计算机");
        bookMaps3.put("出版社", "清华大学出版社");
        bookMaps3.put("书号", "9787302611646");
        bookMaps3.put("价格", "0");
        bookMaps3.put("简介", "本书主要以案例式展开教学，突出以学生为中心，以学生实际学习成果为导向，符合新工科发展理念，引导学生循序渐进地掌握线性表，栈和队列，数组与广义表，树与二叉树，图，查找和排序等内容，本书突出实用性和应用性，每章以项目驱动切入，并最终加以实现，每章附有典型题例，便于加强知识巩固。");
        books.add(bookMaps3);
        Map<String, String> bookMaps4 = new HashMap<String, String>();
        bookMaps4.put("书名", "大学计算机基础教程");
        bookMaps4.put("作者", "丁革媛");
        bookMaps4.put("分类", "计算机");
        bookMaps4.put("出版社", "清华大学出版社");
        bookMaps4.put("书号", "9787302641117");
        bookMaps4.put("价格", "69.8");
        bookMaps4.put("简介", "本书根据原教育部高等学校计算机科学与技术教学指导委员会《关于进一步加强高等学校计算机基础教学的意见暨计算机基础课程教学基本要求》，并结合全国计算机等级考试大纲(二级)的具体要求而编写。");
        books.add(bookMaps4);
    }

    public static void main(String[] args) {
        BookManager bookManager = new BookManager();
        bookManager.Wellcome();
    }

    //    主界面显示
    public void Wellcome() {
        System.out.println("////////////////////////////////////////");
        System.out.println("@@@@@@@@@@@@欢迎使用图书管理系统@@@@@@@@@@@@");
        System.out.println("////////////////////////////////////////");
        System.out.println("***你可以在任意界面输入0来返回上一级或此页面***");
        System.out.println("请选择您要执行的业务：");
        System.out.println("1.查询书籍    2.新增书籍    \n3.删除书籍    4.更新图书信息");
        int event = inputNum(4);
        switch (event) {
            case 0:
                Wellcome();
                break;
            case 1:
                queryBook();
                break;
            case 2:
                addBook();
                break;
            case 3:
                delBook();
                break;
            case 4:
                updateBook();
                break;
        }
    }

    //    更新书籍信息界面
    public void updateBook() {
        System.out.println("////////////////////////////////////////");
        System.out.println("                 更新书籍                 ");
        System.out.println("////////////////////////////////////////");
        System.out.println("***你可以在任意界面输入0来返回上一级或欢迎页面***");
        System.out.print("请输入你要更新的书的书号：");
        Scanner sc = new Scanner(System.in);
        String bookNo = sc.nextLine();
        String regex = "\\d{13}";
        Pattern compile = Pattern.compile(regex);
        if (compile.matcher(bookNo).matches()) {  //  输入书号是否合法
            Map<String, String> targetMap = new HashMap<>();
            for (Map<String, String> map : books) {
                String bookNo1 = map.get("书号");
                if (bookNo.equals(bookNo1)) {
                    double price = Double.parseDouble(map.get("价格"));
                    targetMap = map;
                    Book book = new Book(map.get("书名"), map.get("作者"), map.get("出版社"), map.get("分类"), map.get("书号"), map.get("简介"), price);
                    showBook(book);
                    System.out.println("确认要更新该书籍的信息吗？请输入yes/no或y/n确认是否删除");
                    String s = sc.nextLine();
                    Pattern compile1 = Pattern.compile("yes|y|no|n");
                    while (!compile1.matcher(s).matches()) {
                        System.out.println("您的输入不符合标准请重新输入");
                        System.out.println("确认更新该书籍吗？请输入yes/no或y/n确认是否继续更新");
                        s = sc.nextLine();
                    }
                    if (s.equals("yes") || s.equals("y")) {
                        System.out.println("原书名为：" + map.get("书名"));
                        System.out.println("请输入新的书名:");
                        map.put("书名", sc.nextLine());
                        System.out.println("原作者为：" + map.get("作者"));
                        System.out.println("请输入新的作者:");
                        map.put("作者", sc.nextLine());
                        System.out.println("原分类为：" + map.get("分类"));
                        System.out.println("请输入新的分类:");
                        map.put("分类", sc.nextLine());
                        System.out.println("原出版社为：" + map.get("出版社"));
                        System.out.println("请输入新的出版社:");
                        map.put("出版社", sc.nextLine());
                        System.out.println("原书号为：" + map.get("书号"));
                        System.out.println("请输入新的书号:");
                        String newBookNo = sc.nextLine();
                        while (!Pattern.compile("\\d{13}").matcher(newBookNo).matches()) {
                            System.out.println("您输入的书号不符合规则，应为13位数字组成，请重新输入");
                            System.out.println("请输入新的书号:");
                            newBookNo = sc.nextLine();
                        }
                        map.put("书号", newBookNo);
                        System.out.println("原价格为：" + map.get("价格"));
                        System.out.println("请输入新的价格:");
                        double money = inputMoney();
                        map.put("价格", money + "");
                        String msg = map.get("简介");
                        System.out.println("原简介为：");
                        if (msg.length() > 50) {
                            System.out.println("       " + msg.substring(0, 50));
                            System.out.println(msg.substring(50));
                        } else {
                            System.out.println("       " + msg);
                        }
                        System.out.println("=========================================");
                        System.out.println("请输入新的简介:");
                        map.put("简介", sc.nextLine());

                        System.out.println("书籍：" + map.get("书名") + "更新成功");
                        System.out.println("3秒后返回主界面");
                        sleep(3000);
                        Wellcome();
                    } else if (s.equals("no") || s.equals("n")) {
                        System.out.println("已取消书籍：" + map.get("书名") + "的更新");
                        System.out.println("3秒后返回主界面");
                        sleep(3000);
                        Wellcome();
                    } else {
                        System.out.println("更新书籍：" + map.get("书名") + "失败");
                        System.out.println("3秒后返回主界面");
                        sleep(3000);
                        Wellcome();
                    }
                }
            }
            if (targetMap.size() == 0) {
                bookNoQueryFailed(sc);
            }
        }
    }

    private void bookNoQueryFailed(Scanner sc) {
        System.out.println("未找到您所输入的书号，需要为您转到查询页面吗？");
        System.out.print("请输入yse/no或者y/n：");
        String str = sc.nextLine();
        Pattern compile1 = Pattern.compile("yes|y|no|n");
        while (!compile1.matcher(str).matches()) {
            System.out.println("您的输入不符合标准请重新输入");
            System.out.println("请输入yes/no或y/n确认是否需要为您转到查询页面");
            str = sc.nextLine();
        }
        if (str.equals("yes") || str.equals("y")) {
            System.out.println("正在为您转入到查询页面，请稍后......");
            sleep(2000);
            queryBook();
        } else if (str.equals("no") || str.equals("n")) {
            System.out.println("正在回到主页面，请稍后......");
            sleep(2000);
            Wellcome();
        } else {
            System.out.println("您的输入不符合规格，即将为您转入到主页面");
            sleep(2000);
            Wellcome();
        }
    }

    //    删除书籍界面
    public void delBook() {
        System.out.println("////////////////////////////////////////");
        System.out.println("                 删除书籍                 ");
        System.out.println("////////////////////////////////////////");
        System.out.println("***你可以在任意界面输入0来返回上一级或欢迎页面***");
        System.out.print("请输入你要删除的书的书号：");
        Scanner sc = new Scanner(System.in);
        String bookNo = sc.nextLine();
        String regex = "\\d{13}";
        Pattern compile = Pattern.compile(regex);
        if (compile.matcher(bookNo).matches()) {  //  输入书号是否合法
            Map<String, String> delBook = new HashMap<>();
            for (Map<String, String> map : books) {
                String bookNo1 = map.get("书号");
                if (bookNo.equals(bookNo1)) {
                    double price = Double.parseDouble(map.get("价格"));
                    Book book = new Book(map.get("书名"), map.get("作者"), map.get("出版社"), map.get("分类"), map.get("书号"), map.get("简介"), price);
                    showBook(book);
                    delBook = map;
                }
            }
            if (delBook.size() == 0) {  //  未搜索到对应的书籍
                bookNoQueryFailed(sc);
            }
            System.out.println("确认删除该书籍吗？请输入yes/no或y/n确认是否删除");
            String s = sc.nextLine();
            Pattern compile1 = Pattern.compile("yes|y|no|n");
            while (!compile1.matcher(s).matches()) {
                System.out.println("您的输入不符合标准请重新输入");
                System.out.println("确认删除该书籍吗？请输入yes/no或y/n确认是否删除");
                s = sc.nextLine();
            }
            if (s.equals("yes") || s.equals("y")) {
                books.remove(delBook);
                System.out.println("书籍：" + delBook.get("书名") + "删除成功");
                System.out.println("3秒后返回主界面");
                sleep(3000);
                Wellcome();
            } else if (s.equals("no") || s.equals("n")) {
                System.out.println("已取消书籍：" + delBook.get("书名") + "的删除");
                System.out.println("3秒后返回主界面");
                sleep(3000);
                Wellcome();
            } else {
                System.out.println("删除书籍：" + delBook.get("书名") + "失败");
                System.out.println("3秒后返回主界面");
                sleep(3000);
                Wellcome();
            }
        }

    }

    //    新增书籍页面
    public void addBook() {
        System.out.println("////////////////////////////////////////");
        System.out.println("                 新书录入                 ");
        System.out.println("////////////////////////////////////////");
        System.out.println("***你可以在任意界面输入0来返回上一级或欢迎页面***");
        System.out.print("请输入新书的书号：");
        Scanner sc = new Scanner(System.in);
        String bookNo = sc.nextLine();
        String regex = "\\d{13}";
        Pattern compile = Pattern.compile(regex);
        if (compile.matcher(bookNo).matches()) {  //  如果输入书号合法则检查是否重复
            for (Map<String, String> map : books) {
                String bookNo1 = map.get("书号");
                if (bookNo.equals(bookNo1)) {
                    System.out.println("您所录入的书号系统中已存在，请重新录入");
                    addBook();
                }
            }
            System.out.println("恭喜您输入的书号" + bookNo + "通过验证");
            Map<String, String> book = new HashMap<>();
            book.put("书号", bookNo);
            System.out.print("请输入新书的名称：");
            book.put("书名", sc.nextLine());
            System.out.print("请输入新书的分类：");
            book.put("分类", sc.nextLine());
            System.out.print("请输入新书的出版社：");
            book.put("出版社", sc.nextLine());
            System.out.print("请输入新书的作者：");
            book.put("作者", sc.nextLine());
            System.out.print("请输入新书的简介：");
            book.put("简介", sc.nextLine());
            System.out.println("请输入新书的金额：");
            double money = inputMoney();
            book.put("价格", money + "");
            books.add(book);
            System.out.println("新书录入成功，3秒后返回主界面");
            sleep(3000);
            Wellcome();
        } else {
            System.out.println("书号应为13位数字，请确认您输入的书号是否正确");
            addBook();
        }
    }

    //    查询页面
    public void queryBook() {
        System.out.println("////////////////////////////////////////");
        System.out.println("@@@@@@@@@@@@请选择您要查询的方式@@@@@@@@@@@@");
        System.out.println("////////////////////////////////////////");
        System.out.println("***你可以在任意界面输入0来返回上一级或欢迎页面***");
        System.out.println("1.书名查询  2.书号查询  3.作者查询  \n4.出版社查询 5.分类查询  6.价格区间查询");
        int event = inputNum(6);
        List<Book> books = new ArrayList<>();
        switch (event) {
            case 0:
                Wellcome();
                break;
            case 1:
                books = inputQuery("书名");
                break;
            case 2:
                books = inputQuery("书号");
                break;
            case 3:
                books = inputQuery("作者");
                break;
            case 4:
                books = inputQuery("出版社");
                break;
            case 5:
                books = inputQuery("分类");
                break;
            case 6:
                books = inputQuery("价格");
                break;
        }
//        System.out.println("共搜索到" + books.size() + "本书");
        if (books.size() == 0) {
            System.out.println("未搜索到符合要求的书籍");
            queryBook();
        } else {
//            搜索到对应书籍设置页面数据
            int totalBook = books.size();    //  搜索到的图书总量
            System.out.println("搜索到书籍结果数量为" + totalBook);
            System.out.println("请选择每页要显示的书籍数量");
            int pageBookNum = inputNum(0);  //  页面一次展示书籍的数量
            int residualBooks = 0;    //  剩余未显示的图书数量
            int totalPage = 0;  //  总页数
            int pageNum = 1;    //  当前页数
            if (totalBook < pageBookNum) {    //  如果传入结果数量不足每页显示数量的上限，则该页显示所有搜索到的对象
                pageBookNum = books.size();
            }
            totalPage = totalBook / pageNum;
            residualBooks = totalBook - (pageBookNum * pageNum);
            showBooks(books, totalPage, pageNum, pageBookNum, residualBooks);
        }
    }

    //    搜索结果的显示页面
    public void showBooks(List<Book> list, int totalPage, int pageNum, int pageBookNum, int residualBooks) {
        int residualPage = 0;   //  剩余页数
        if (list.size() < pageBookNum) {    //  如果传入结果数量不足每页显示数量的上限，则该页显示所有搜索到的对象
            pageBookNum = list.size();
        } else {
            residualPage = residualBooks / pageNum;
        }
//        将本页书籍进行序列化存储
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 0; i < pageBookNum; i++) {
            int bookNo = i + 1;
            String bookName = list.get(i + ((pageNum - 1) * pageBookNum)).getName();
            System.out.println(bookNo + "." + bookName);
            map.put(bookNo, bookName);
        }
        String regex;
        String title = "";
        System.out.println("当前页面为第" + pageNum + "页，还有" + residualPage + "页");
        if (pageNum == 1) {
            title = "请选择你要查看的书籍编号，下一页请输入0：";
            regex = "\\d+";
        } else if (residualPage == 0) {
            title = "当前页面为最后一页，返回上一页请输入r，回到主页面请输入0：";
            regex = "\\d+|r";
        } else {
            title = "输入r为您返回上一页，下一页请输入0：";
            regex = "\\d+|r";
        }
        System.out.println(title);
        Pattern anyNum = Pattern.compile(regex);
        Scanner sc = new Scanner(System.in);
        String bookNo = sc.nextLine();
        while (!anyNum.matcher(bookNo).matches()) {
            System.out.println("您的输入不符合标准请重新输入");
            System.out.println(title);
            bookNo = sc.nextLine();
        }
        if (pageNum == 1) { //  当前页面为第一页
            int i = Integer.parseInt(bookNo);

            if (i == 0) {
                residualBooks = residualBooks - pageBookNum;
                showBooks(list, residualPage, ++pageNum, pageBookNum, residualBooks);
            } else {
                Book book = findByName(map.get(i));
                showBook(book);
                System.out.println("输入任意值返回查询页面：");
                sc.nextLine();
                queryBook();
            }
        } else if (residualPage == 0) { //  当前页面为最后一页
            if (bookNo.equals("0")) {
                System.out.println("正在回到主页面......");
                sleep(3000);
                Wellcome();
            } else if (bookNo.equals("r")) {  //  上一页
                residualBooks = residualBooks + pageBookNum;
                showBooks(list, residualPage, --pageNum, pageBookNum, residualBooks);
            } else {
                int i = Integer.parseInt(bookNo);
                Book book = findByName(map.get(i));
                showBook(book);
                System.out.println("输入任意值返回查询页面：");
                sc.nextLine();
                queryBook();
            }
        } else {
            if (bookNo.equals("0")) {   //  下一页
                residualBooks = residualBooks - pageBookNum;
                showBooks(list, residualPage, ++pageNum, pageBookNum, residualBooks);
            } else if (bookNo.equals("r")) {     //  上一页
                residualBooks = residualBooks + pageBookNum;
                showBooks(list, residualPage, --pageNum, pageBookNum, residualBooks);
            } else {
                int i = Integer.parseInt(bookNo);
                Book book = findByName(map.get(i));
                showBook(book);
                System.out.println("输入任意值返回查询页面：");
                sc.nextLine();
                queryBook();
            }
        }
    }

    //    查看某一本书的信息页面
    public void showBook(Book book) {
        System.out.println("%%%%%%%%%%%%%书籍详细信息%%%%%%%%%%%%");
        System.out.println("===================================");
        System.out.println(book.getName());
        System.out.println("===================================");
        System.out.println("书号：" + book.getBookNo());
        System.out.println("作者：" + book.getAuther());
        System.out.println("出版社：" + book.getPress());
        System.out.println("分类：" + book.getClassify());
        System.out.println("价格：" + book.getPrice());
        System.out.println("简介：");
        String msg = book.getMsg();
        if (msg.length() > 50) {
            System.out.println("  " + msg.substring(0, 50));
            System.out.println(msg.substring(50));
        } else {
            System.out.println("  " + msg);
        }
        System.out.println("===================================");
    }

    //    根据书名返回某一本书
    public Book findByName(String name) {
        for (Map<String, String> map : books) {
            String bookName = map.get("书名");
            if (name.equals(bookName)) {
                double price = Double.parseDouble(map.get("价格"));
                return new Book(map.get("书名"), map.get("作者"), map.get("出版社"), map.get("分类"), map.get("书号"), map.get("简介"), price);
            }
        }
        return new Book();
    }

    //    选择业务方法
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
        if (eventNum == 0) {
            System.out.print("请输入0：");
            regex = "0";
        } else if (eventNum > 9) {
            System.out.print("请输入您所需的数字编号：");
            regex = "\\d+";
        }
        Pattern p = Pattern.compile(regex);
        boolean isMatch = p.matcher(i + "").matches();  //  检查是否满足输入要求

        if (!isMatch) {
            System.out.println("////////////////////////////////////////");
            System.out.println("********您的输入无效，请重新输入*********");
            System.out.println("////////////////////////////////////////");
            i = inputNum(eventNum);
        }
        return i;
    }

    //    输入金额
    public double inputMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入金额：");
        double v = 0;
        try {
            v = sc.nextDouble();
        } catch (Exception e) {
            System.out.println("////////////////////////////////////////");
            System.out.println("********您的输入的金额无效，请重新输入*********");
            System.out.println("////////////////////////////////////////");
            v = inputMoney();
        }
        return v;
    }

    //    输入查询索引
    public List<Book> inputQuery(String condition) {
        List<Book> list = new ArrayList<>();
        System.out.println("################################");
        System.out.println("使用" + condition + "查询");
        System.out.println("################################");
        if (!condition.equals("价格")) {
            System.out.println("书号查询输入书号长度最多为13位数字");
            System.out.print("请输入您要查询的字段：");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            for (Map<String, String> map : books) {
                boolean contains = map.get(condition).contains(s);  //  检查对方是否包含用户输入的字符或字符串
                if (contains) {
                    double price = Double.parseDouble(map.get("价格"));
                    Book book = new Book(map.get("书名"), map.get("作者"), map.get("出版社"), map.get("分类"), map.get("书号"), map.get("简介"), price);
                    list.add(book);
                }
            }
        } else {
            System.out.println("请输入您要查询的价格区间");
            System.out.println("请输入最小金额");
            double min = inputMoney();
            System.out.println("请输入最大金额");
            double max = inputMoney();
            for (Map<String, String> map : books) {
                double price = Double.parseDouble(map.get("价格"));
                System.out.println("最小金额为" + min + "最大金额为" + max + "目标金额为" + price);
                if (min <= price && max >= price) {
                    Book book = new Book(map.get("书名"), map.get("作者"), map.get("出版社"), map.get("分类"), map.get("书号"), map.get("简介"), price);
                    list.add(book);
                }
            }
        }

        return list;
    }

    private void sleep(int i) { //  模拟加载时间
        try {
            Thread.currentThread().sleep(i);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

package cn.com.offcn.test;

public class homework {
    public static void main(String[] args) {

        int[] monkey = new int[15];
        for (int i = 0; i < 15; i++) {
            monkey[i] = i + 1;
        }

        int lives = 15;    //  �����Ӽ�����
        int num = 1;    //  ����������
        int index = 0; //   ������Ӧ����������
        while (lives > 1) {
            if (monkey[index] != 0) {
                if (num == 7) {
                    monkey[index] = 0;
                    num = 1;
                    index++;
                    lives--;
                }else {
                    num++;
                    index++;
                }
            }else {
                index++;
            }
            //����ѭ����һȦ������������
            if (index == 15) {
                index = 0;
            }
        }
        for (int i = 0; i < monkey.length; i++) {
            System.out.print(monkey[i]+",");
        }
    }
}

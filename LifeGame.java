package danyuanceshi;

import java.util.Random;
import java.util.Scanner;

    /*
    1.生命小游戏的邻居为上下左右和斜对角一共八个位置;
    2.默认选择4*4的格子。
    3.将默认的格子初始化，并打印输出
    4.使用Methods中的方法生成下一轮的状态，并打印
     */

public class LifeGame {
    public static void main(String[] args) {

        //先设置一个二维数组存储所有的格子
        String[][] lifeMap = new String[4][4];

        Methods me = new Methods();

        //对所有格子进行初始化输入，死为0，活为1
        //随机生成各个位置的邻居情况
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                int num = new Random().nextInt(2);
                if (num == 1)
                    lifeMap[i][j] = "●";
                else if (num == 0)
                    lifeMap[i][j] = "○";
            }
        }

        //打印格子初始状态
        System.out.println("初始状态为：");
        me.printLifeMap(lifeMap);
        System.out.println("===========");

        int n = 0;
        int num = 0;//记录变化的次数
        while (n == 0) {

            //用point数组，记录对应位置下一轮的状态，1下一代死，2下一代继续活，3下一代复活
            int[] point = me.check(lifeMap, new int[16]);

            //获得下一次变化后的图形
            lifeMap = me.getNext(lifeMap, point).clone();

            System.out.println("第" + (++num) + "次变化：");

            //打印出来
            me.printLifeMap(lifeMap);
            System.out.println("===========");

            System.out.println("输入0继续进行下一步，输入其他数字退出。");
            n = new Scanner(System.in).nextInt();
        }
    }
}

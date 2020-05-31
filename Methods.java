package danyuanceshi;


public class Methods {

    public Methods() {
    }

    //该方法检测所有位置，并返回对应位置的point数组
    //用point数组，记录对应位置下一轮的状态，1下一代死，2下一代继续活，3下一代复活
    public int[] check(String[][] lifeMap, int[] point) {

        int n = 0;
        //统计周围邻居的情况
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                /*
                规则如下，进行判断
                    1.一个人可以有8个邻居；
                    2.一个人若只有一个邻居，在下一代会孤独的死去；
                    3.若有2或3个邻居，在下一代依然活着；
                    4.若有4个或以上邻居，在下一代会因拥挤而死；
                    5.死去的人若有3个邻居，在下一代会复活；
                    6.所有的死去或复活都在下一代变化时同时发生。
                */

                //用life变量记录周围活着的邻居个数
                int life = 0;

                //1.判断正下方的位置
                if (i + 1 < 4 && lifeMap[i + 1][j].equals("●")) {
                    life++;
                }

                //2.判断右下位置
                if (i + 1 < 4 && j + 1 < 4 && lifeMap[i + 1][j + 1].equals("●")) {
                    life++;
                }

                //3.判断左下位置
                if (i + 1 < 4 && j - 1 >= 0 && lifeMap[i + 1][j - 1].equals("●")) {
                    life++;
                }

                //4.判断右侧位置
                if (j + 1 < 4 && lifeMap[i][j + 1].equals("●")) {
                    life++;
                }

                //5.判断左侧位置
                if (j - 1 >= 0 && lifeMap[i][j - 1].equals("●")) {
                    life++;
                }

                //6.判断正上方位置
                if (i - 1 >= 0 && lifeMap[i - 1][j].equals("●")) {
                    life++;
                }

                //7.判断右上位置
                if (i - 1 >= 0 && j + 1 < 4 && lifeMap[i - 1][j + 1].equals("●")) {
                    life++;
                }

                //8.判断左上位置
                if (i - 1 >= 0 && j - 1 >= 0 && lifeMap[i - 1][j - 1].equals("●")) {
                    life++;
                }

                //用一个数组，记录对应位置下一轮的状态，1下一代死，2下一代继续活，3下一代复活
                if (lifeMap[i][j].equals("●")) {
                    if (life == 1)
                        point[n] = 1;
                    else if (life == 2 || life == 3)
                        point[n] = 2;
                    else if (life >= 4)
                        point[n] = 1;
                } else {
                    if (life == 3)
                        point[n] = 3;
                }
                n++;
            }
        }
        return point;
    }

    public String[][] getNext(String[][] lifeMap, int[] point) {

        int n = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                //变更状态
                if (point[n] == 1)
                    lifeMap[i][j] = "○";
                if (point[n] == 3)
                    lifeMap[i][j] = "●";

                n++;
            }
        }
        return lifeMap;
    }

    public void printLifeMap(String[][] lifeMap){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == 3)
                    System.out.println(lifeMap[i][j] + " ");
                else
                    System.out.print(lifeMap[i][j] + " ");
            }
        }
    }
}

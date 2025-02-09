package Game;

import java.util.ArrayList;

public class Calculate
{
    //查找所有符合条件的表达式
    ArrayList<String> find(int[] j)
    {
        Convey c = new Convey();//Convey对象，存储表达式
        Dispose d = new Dispose(c);//Dispose对象，传入Convey
        ArrayList<Integer> card = new ArrayList<>();//存储卡片数字的列表
        int s = 24;

        //将输入的整数数组转存到card列表
        for (int jj : j)
        {
            card.add(jj);
        }

        //调用c1查找所有符合条件的表达式
        d.c1(card, card.size() - 1, s);

        //返回所有符合条件的表达式
        return d.strings;
    }
}

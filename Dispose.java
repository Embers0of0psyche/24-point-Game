package Game;

import java.util.ArrayList;

public class Dispose
{
    private Convey cc;//处理表达式的Convey
    ArrayList<String> strings = new ArrayList<>();//存储符合条件的表达式字符串

    //初始化Convey对象
    Dispose(Convey c)
    {
        cc = c;
    }

    //检查是否可以用指定的运算符和数字生成目标值
    boolean c1(ArrayList<Integer> a, int num, int tt)
    {
        if (num == 1)  // 基本情况：只剩一个数字
        {
            //检查各种运算是否符合目标值
            if (a.get(0) + a.get(1) == tt)
            {
                cc.add(a.get(0));
                cc.add(a.get(1));
                cc.add("+");
                return true;
            }
            if (a.get(0) - a.get(1) == tt)
            {
                cc.add(a.get(0));
                cc.add(a.get(1));
                cc.add("-");
                return true;
            }
            if (a.get(1) - a.get(0) == tt)
            {
                cc.add(a.get(1));
                cc.add(a.get(0));
                cc.add("-");
                return true;
            }
            if (a.get(0) * a.get(1) == tt)
            {
                cc.add(a.get(1));
                cc.add(a.get(0));
                cc.add("*");
                return true;
            }
            if (a.get(0) * tt == a.get(1))
            {
                cc.add(a.get(0));
                cc.add(a.get(1));
                cc.add("/");
                return true;
            }
            if (a.get(1) * tt == a.get(0))
            {
                cc.add(a.get(1));
                cc.add(a.get(0));
                cc.add("/");
                return true;
            }
            return false;
        }
        else//递归情况：处理多个数字
        {
            //遍历列表元素
            for (int cu = 0; cu < a.size(); cu++)
            {
                ArrayList<Integer> a1 = new ArrayList<>();

                int cn = a.get(cu);//当前处理的数字

                //将当前处理的数字从列表中移除，得到新的列表
                for (int i = 0; i < a.size(); i++)
                {
                    if (i == cu)
                    {
                        continue;
                    }
                    a1.add(a.get(i));
                }

                //递归检查是否可以用剩余的数字生成目标值
                if (c1(a1, num - 1, tt - cn))
                {
                    cc.add("+");
                    cc.add(cn);
                    if (num == 3)
                    {
                        strings.add(cc.toString());//保存符合条件的表达式
                        cc.clear();
                    }
                    if (num != 3) return true;//如果不是基本情况返回true
                }
                if (c1(a1, num - 1, tt + cn))
                {
                    cc.add("-");
                    cc.add(cn);
                    if (num == 3)
                    {
                        strings.add(cc.toString());//保存符合条件的表达式
                        cc.clear();
                    }
                    if (num != 3) return true;//如果不是基本情况返回true
                }
                if (c1(a1, num - 1, tt * cn))
                {
                    cc.add("/");
                    cc.add(cn);
                    if (num == 3)
                    {
                        strings.add(cc.toString());//保存符合条件的表达式
                        cc.clear();
                    }
                    if (num != 3) return true;//如果不是基本情况返回true
                }
                if (tt % cn == 0)//检查除法是否整除
                {
                    if (c1(a1, num - 1, (tt / cn)))
                    {
                        cc.add("*");
                        cc.add(cn);
                        if (num == 3)
                        {
                            strings.add(cc.toString());//保存符合条件的表达式
                            cc.clear();
                        }
                        if (num != 3) return true;//如果不是基本情况返回true
                    }
                }
            }
            return false;
        }
    }
}

package Game;

import java.util.ArrayList;

public class Convey
{
    private ArrayList<Integer> n = new ArrayList<>();//存储整数的列表
    private ArrayList<String> ss = new ArrayList<>();//存储字符串的列表

    //向整数列表中添加一个整数
    void add(int x)
    {
        n.add(x);
    }

    //向字符串列表中添加一个字符串
    void add(String s)
    {
        ss.add(s);
    }

    //将整数转换为相应的字符串表示（1->"A",11->"J",12->"Q",13->"K"）
    private String c1(int n)
    {
        switch (n)
        {
            case 1: return "A";
            case 11: return "J";
            case 12: return "Q";
            case 13: return "K";
            default: return Integer.toString(n);
        }
    }

    //递归，将整数列表和字符串列表转换为一个字符串表示
    private String toString(int x)
    {
        if (x == 0)
        {
            //基本情况：返回第一个整数和字符串的组合
            return c1(n.get(0)) + ss.get(0) + c1(n.get(1));
        }
        else
        {
            //递归情况：在已有字符串的基础上添加新元素
            String r = this.toString(x - 1);
            r = "(" + r + ")";
            r += ss.get(x) + c1(n.get(x + 1));
            return r;
        }
    }

    //默认toString，调用带有初始值2的toString
    public String toString()
    {
        return toString(2);
    }

    //清空整数列表和字符串列表
    void clear()
    {
        n.clear();
        ss.clear();
    }
}

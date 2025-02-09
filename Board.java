package Game;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Board extends JPanel
{
    private JLabel[] jl;//JLabel数组，显示卡片
    private int[] jj;//存储卡片编号的数组
    private Random num = new Random();

    public Board() throws Exception
    {

        setLayout(new GridLayout(1, 4, 8, 8));
        jl = new JLabel[4];//初始化JLabel数组
        jj = new int[4];//初始化卡片编号数组
        getJj();//获取随机卡片编号
        for (int i = 0; i < 4; i++)
        {
            //JLabel，设置为卡片图像
            jl[i] = new JLabel(new ImageIcon("cards/" + cc(jj[i]) + ".jpg"));
            add(jl[i]);
        }
    }

    private int[] getJj()
    {
        int tt;
        for (int i = 0; i < jj.length; i++)
        {
            tt = num.nextInt(52) + 1;//随机生成1到52的卡片编号
            for (int j = i; j >= 0; j--)
            {
                if (tt == jj[j])
                {
                    i--;//如果卡片重复，重新生成编号
                    break;
                }
                else
                {
                    jj[i] = tt;//存储卡片编号
                }
            }
        }
        return jj;//返回卡片编号数组
    }

    private String cc(int nn)
    {
        String ss;
        int vv;

        //将卡片编号转换为花色和点数
        if (nn <= 13)
        {
            ss = "spade";
            vv = nn;
        }
        else if (nn <= 26)
        {
            ss = "heart";
            vv = nn - 13;
        }
        else if (nn <= 39)
        {
            ss = "club";
            vv = nn - 26;
        }
        else
        {
            ss = "diamond";
            vv = nn - 39;
        }

        //返回花色和点数的字符串表示
        return ss + "_" + (vv == 1 ? "A" : (vv == 11 ? "J" : (vv == 12 ? "Q" : (vv == 13 ? "K" : vv))));
    }

    public void re() throws Exception
    {
        removeAll();//移除所有组件
        getJj();//获取新的卡片编号
        for (int i = 0; i < 4; i++)
        {
            //JLabel，设置为新的卡片图像
            jl[i] = new JLabel(new ImageIcon("cards/" + cc(jj[i]) + ".jpg"));
            add(jl[i]);//将JLabel添加到面板
        }
        revalidate();//重新验证布局
        repaint();//重绘面板
    }

    public int[] getJa()
    {
        return jj;//返回卡片编号数组
    }
}

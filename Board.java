package Game;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Board extends JPanel
{
    private JLabel[] jl;//JLabel���飬��ʾ��Ƭ
    private int[] jj;//�洢��Ƭ��ŵ�����
    private Random num = new Random();

    public Board() throws Exception
    {

        setLayout(new GridLayout(1, 4, 8, 8));
        jl = new JLabel[4];//��ʼ��JLabel����
        jj = new int[4];//��ʼ����Ƭ�������
        getJj();//��ȡ�����Ƭ���
        for (int i = 0; i < 4; i++)
        {
            //JLabel������Ϊ��Ƭͼ��
            jl[i] = new JLabel(new ImageIcon("cards/" + cc(jj[i]) + ".jpg"));
            add(jl[i]);
        }
    }

    private int[] getJj()
    {
        int tt;
        for (int i = 0; i < jj.length; i++)
        {
            tt = num.nextInt(52) + 1;//�������1��52�Ŀ�Ƭ���
            for (int j = i; j >= 0; j--)
            {
                if (tt == jj[j])
                {
                    i--;//�����Ƭ�ظ����������ɱ��
                    break;
                }
                else
                {
                    jj[i] = tt;//�洢��Ƭ���
                }
            }
        }
        return jj;//���ؿ�Ƭ�������
    }

    private String cc(int nn)
    {
        String ss;
        int vv;

        //����Ƭ���ת��Ϊ��ɫ�͵���
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

        //���ػ�ɫ�͵������ַ�����ʾ
        return ss + "_" + (vv == 1 ? "A" : (vv == 11 ? "J" : (vv == 12 ? "Q" : (vv == 13 ? "K" : vv))));
    }

    public void re() throws Exception
    {
        removeAll();//�Ƴ��������
        getJj();//��ȡ�µĿ�Ƭ���
        for (int i = 0; i < 4; i++)
        {
            //JLabel������Ϊ�µĿ�Ƭͼ��
            jl[i] = new JLabel(new ImageIcon("cards/" + cc(jj[i]) + ".jpg"));
            add(jl[i]);//��JLabel��ӵ����
        }
        revalidate();//������֤����
        repaint();//�ػ����
    }

    public int[] getJa()
    {
        return jj;//���ؿ�Ƭ�������
    }
}

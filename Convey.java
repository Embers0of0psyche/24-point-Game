package Game;

import java.util.ArrayList;

public class Convey
{
    private ArrayList<Integer> n = new ArrayList<>();//�洢�������б�
    private ArrayList<String> ss = new ArrayList<>();//�洢�ַ������б�

    //�������б������һ������
    void add(int x)
    {
        n.add(x);
    }

    //���ַ����б������һ���ַ���
    void add(String s)
    {
        ss.add(s);
    }

    //������ת��Ϊ��Ӧ���ַ�����ʾ��1->"A",11->"J",12->"Q",13->"K"��
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

    //�ݹ飬�������б���ַ����б�ת��Ϊһ���ַ�����ʾ
    private String toString(int x)
    {
        if (x == 0)
        {
            //������������ص�һ���������ַ��������
            return c1(n.get(0)) + ss.get(0) + c1(n.get(1));
        }
        else
        {
            //�ݹ�������������ַ����Ļ����������Ԫ��
            String r = this.toString(x - 1);
            r = "(" + r + ")";
            r += ss.get(x) + c1(n.get(x + 1));
            return r;
        }
    }

    //Ĭ��toString�����ô��г�ʼֵ2��toString
    public String toString()
    {
        return toString(2);
    }

    //��������б���ַ����б�
    void clear()
    {
        n.clear();
        ss.clear();
    }
}

package Game;

import java.util.ArrayList;

public class Dispose
{
    private Convey cc;//������ʽ��Convey
    ArrayList<String> strings = new ArrayList<>();//�洢���������ı��ʽ�ַ���

    //��ʼ��Convey����
    Dispose(Convey c)
    {
        cc = c;
    }

    //����Ƿ������ָ�������������������Ŀ��ֵ
    boolean c1(ArrayList<Integer> a, int num, int tt)
    {
        if (num == 1)  // ���������ֻʣһ������
        {
            //�����������Ƿ����Ŀ��ֵ
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
        else//�ݹ����������������
        {
            //�����б�Ԫ��
            for (int cu = 0; cu < a.size(); cu++)
            {
                ArrayList<Integer> a1 = new ArrayList<>();

                int cn = a.get(cu);//��ǰ���������

                //����ǰ��������ִ��б����Ƴ����õ��µ��б�
                for (int i = 0; i < a.size(); i++)
                {
                    if (i == cu)
                    {
                        continue;
                    }
                    a1.add(a.get(i));
                }

                //�ݹ����Ƿ������ʣ�����������Ŀ��ֵ
                if (c1(a1, num - 1, tt - cn))
                {
                    cc.add("+");
                    cc.add(cn);
                    if (num == 3)
                    {
                        strings.add(cc.toString());//������������ı��ʽ
                        cc.clear();
                    }
                    if (num != 3) return true;//������ǻ����������true
                }
                if (c1(a1, num - 1, tt + cn))
                {
                    cc.add("-");
                    cc.add(cn);
                    if (num == 3)
                    {
                        strings.add(cc.toString());//������������ı��ʽ
                        cc.clear();
                    }
                    if (num != 3) return true;//������ǻ����������true
                }
                if (c1(a1, num - 1, tt * cn))
                {
                    cc.add("/");
                    cc.add(cn);
                    if (num == 3)
                    {
                        strings.add(cc.toString());//������������ı��ʽ
                        cc.clear();
                    }
                    if (num != 3) return true;//������ǻ����������true
                }
                if (tt % cn == 0)//�������Ƿ�����
                {
                    if (c1(a1, num - 1, (tt / cn)))
                    {
                        cc.add("*");
                        cc.add(cn);
                        if (num == 3)
                        {
                            strings.add(cc.toString());//������������ı��ʽ
                            cc.clear();
                        }
                        if (num != 3) return true;//������ǻ����������true
                    }
                }
            }
            return false;
        }
    }
}

package Game;

import java.util.ArrayList;

public class Calculate
{
    //�������з��������ı��ʽ
    ArrayList<String> find(int[] j)
    {
        Convey c = new Convey();//Convey���󣬴洢���ʽ
        Dispose d = new Dispose(c);//Dispose���󣬴���Convey
        ArrayList<Integer> card = new ArrayList<>();//�洢��Ƭ���ֵ��б�
        int s = 24;

        //���������������ת�浽card�б�
        for (int jj : j)
        {
            card.add(jj);
        }

        //����c1�������з��������ı��ʽ
        d.c1(card, card.size() - 1, s);

        //�������з��������ı��ʽ
        return d.strings;
    }
}

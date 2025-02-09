package Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->
        {
            //������
            JFrame frame = new JFrame("��24");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(590, 600);

            //����� ���ò���
            JPanel pane = new JPanel(new GridBagLayout());
            GridBagConstraints gg = new GridBagConstraints();
            gg.fill = GridBagConstraints.BOTH;
            gg.weightx = 0.05;
            gg.weighty = 0.05;
            gg.insets = new Insets(5, 5, 5, 5);

            //�������
            JPanel tp = new JPanel();
            tp.setLayout(new BorderLayout(5, 5));

            //��Ƭ���
            JPanel cp = new JPanel();
            cp.setLayout(new FlowLayout(FlowLayout.LEFT));

            //��Draw Cards����ť
            JButton rr = new JButton("Draw Cards");
            cp.add(rr);

            //��Ƭ���
            Board bb = null;
            try
            {
                bb = new Board();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            if (bb != null)
            {
                cp.add(bb);//���Board���󵽿�Ƭ���
            }
            tp.add(cp, BorderLayout.CENTER);

            JPanel ccp = new JPanel();
            ccp.setLayout(new FlowLayout(FlowLayout.RIGHT));

            JButton sh = new JButton("Calculate");
            sh.setPreferredSize(new Dimension(120, sh.getPreferredSize().height));
            ccp.add(sh);

            tp.add(ccp, BorderLayout.SOUTH);

            gg.gridx = 0;
            gg.gridy = 0;
            gg.gridwidth = GridBagConstraints.REMAINDER;
            pane.add(tp, gg);

            //�ı����
            JPanel tap = new JPanel(new BorderLayout());
            JTextArea ta = new JTextArea(30, 40);
            ta.setEditable(false);//ֻ��
            JScrollPane scrollPane = new JScrollPane(ta);
            scrollPane.setBorder(BorderFactory.createTitledBorder("Number of Schemes:"));
            tap.add(scrollPane, BorderLayout.CENTER);//��ӹ���

            gg.gridy = 1;
            gg.weighty = 1.0;
            pane.add(tap, gg);

            try
            {
                ArrayList<String> slt = new ArrayList<>();//�洢����������б�

                Board b1 = bb;
                rr.addActionListener(e ->
                {
                    try
                    {
                        if (b1 != null)
                        {
                            b1.re();//�ػ濨Ƭ
                        }

                        ta.setText("");//����ı�����
                        slt.clear();//��ս�������б�
                        sh.setEnabled(true);
                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                });

                Board b2 = bb;
                sh.addActionListener(e ->
                {
                    if (b2 != null)
                    {
                        Calculate c1 = new Calculate();
                        int[] cn = b2.getJa();
                        for (int i = 0; i < cn.length; i++)
                        {
                            cn[i] = cn[i] % 13;//����Ƭ���תΪ1-13֮���ֵ
                            if (cn[i] == 0) cn[i] = 13;//���ֵΪ0������Ϊ13
                        }
                        slt.clear();//��ս�������б�
                        slt.addAll(c1.find(cn));//���ҷ��������Ľ�
                        ta.setText("");//����ı�����

                        if (slt.isEmpty())
                        {
                            ta.append("�޽�\n");
                        }
                        else
                        {
                            ta.append(slt.size() + "�ֽⷨ��\n");//��ʾ����
                            for (String solu : slt)
                            {
                                ta.append(solu + "\n");
                            }
                        }
                    }
                });

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            frame.add(pane);
            frame.setVisible(true);//��ʾ����
        });
    }
}

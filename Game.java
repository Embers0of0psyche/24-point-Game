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
            //主窗口
            JFrame frame = new JFrame("算24");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(590, 600);

            //主面板 设置布局
            JPanel pane = new JPanel(new GridBagLayout());
            GridBagConstraints gg = new GridBagConstraints();
            gg.fill = GridBagConstraints.BOTH;
            gg.weightx = 0.05;
            gg.weighty = 0.05;
            gg.insets = new Insets(5, 5, 5, 5);

            //顶部面板
            JPanel tp = new JPanel();
            tp.setLayout(new BorderLayout(5, 5));

            //卡片面板
            JPanel cp = new JPanel();
            cp.setLayout(new FlowLayout(FlowLayout.LEFT));

            //“Draw Cards”按钮
            JButton rr = new JButton("Draw Cards");
            cp.add(rr);

            //卡片面板
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
                cp.add(bb);//添加Board对象到卡片面板
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

            //文本面板
            JPanel tap = new JPanel(new BorderLayout());
            JTextArea ta = new JTextArea(30, 40);
            ta.setEditable(false);//只读
            JScrollPane scrollPane = new JScrollPane(ta);
            scrollPane.setBorder(BorderFactory.createTitledBorder("Number of Schemes:"));
            tap.add(scrollPane, BorderLayout.CENTER);//添加滚动

            gg.gridy = 1;
            gg.weighty = 1.0;
            pane.add(tap, gg);

            try
            {
                ArrayList<String> slt = new ArrayList<>();//存储解决方案的列表

                Board b1 = bb;
                rr.addActionListener(e ->
                {
                    try
                    {
                        if (b1 != null)
                        {
                            b1.re();//重绘卡片
                        }

                        ta.setText("");//清空文本区域
                        slt.clear();//清空解决方案列表
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
                            cn[i] = cn[i] % 13;//将卡片编号转为1-13之间的值
                            if (cn[i] == 0) cn[i] = 13;//如果值为0，设置为13
                        }
                        slt.clear();//清空解决方案列表
                        slt.addAll(c1.find(cn));//查找符合条件的解
                        ta.setText("");//清空文本区域

                        if (slt.isEmpty())
                        {
                            ta.append("无解\n");
                        }
                        else
                        {
                            ta.append(slt.size() + "种解法：\n");//显示解数
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
            frame.setVisible(true);//显示窗口
        });
    }
}

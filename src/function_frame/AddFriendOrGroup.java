/*
 * Created by JFormDesigner on Wed May 24 11:25:16 CST 2023
 */

package function_frame;

import model.User;

import dao.Dao;
import model.UserLabel;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author 12094
 */
public class AddFriendOrGroup extends JFrame
{
    public AddFriendOrGroup() {
        initComponents();
    }

    private void clear_text(ActionEvent e)
    {
        textField1.setText("");
    }

    private void search(ActionEvent e)
    {
        String user_name = textField1.getText();
        try {
            ArrayList<User> user_list = Dao.add_friends_by_name(user_name);
            ArrayList<UserLabel> user_labels = Dao.add_user_to_user_label(user_list);

            user_info_panel = Dao.user_label_add_to_j_scroll_pane(user_labels);
            scrollPane1.add(user_info_panel);
            scrollPane1.revalidate();
            scrollPane1.repaint();
        }
        catch (SQLException ex)
        {
            throw new RuntimeException(ex);
        }
    }

    private void clear2(ActionEvent e)
    {
        textField2.setText("");
    }

    private void search2(ActionEvent e)
    {

    }

    private void initComponents()
    {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        search_panel = new JPanel();
        textField1 = new JTextField();
        button3 = new JButton();
        button4 = new JButton();
        user_panel = new JScrollPane();
        panel4 = new JPanel();
        search_panel2 = new JPanel();
        textField2 = new JTextField();
        button5 = new JButton();
        button6 = new JButton();
        scrollPane1 = new JScrollPane();
        user_info_panel = new JPanel();
        //======== this ========
        setTitle("查找");
        setBackground(Color.white);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        tabbedPane1.setFocusable(false);
        //======== tabbedPane1 ========
        {

            //======== panel1 ========
            {
                panel1.setLayout(null);

                //======== search_panel ========
                {
                    search_panel.setLayout(null);
                    search_panel.add(textField1);
                    textField1.setBounds(45, 15, 330, 40);

                    //---- button3 ----
                    button3.setIcon(new ImageIcon("E:\\study\\java\\MiniChat\\source\\叉叉.png"));
                    button3.setFocusable(false);
                    button3.addActionListener(e -> clear_text(e));
                    search_panel.add(button3);
                    button3.setBounds(375, 15, 50, 40);

                    //---- button4 ----
                    button4.setIcon(new ImageIcon("E:\\study\\java\\MiniChat\\source\\搜索.png"));
                    button4.setFocusable(false);
                    button4.addActionListener(e -> search(e));
                    search_panel.add(button4);
                    button4.setBounds(425, 15, button4.getPreferredSize().width, 40);
                }
                panel1.add(search_panel);
                search_panel.setBounds(0, 0, 565, 70);
                panel1.add(user_panel);
                user_panel.setBounds(0, 70, 565, 285);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel1.getComponentCount(); i++) {
                        Rectangle bounds = panel1.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel1.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel1.setMinimumSize(preferredSize);
                    panel1.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("找人", panel1);

            //======== panel4 ========
            {
                panel4.setLayout(null);

                //======== search_panel2 ========
                {
                    search_panel2.setLayout(null);
                    search_panel2.add(textField2);
                    textField2.setBounds(40, 30, 330, 40);

                    //---- button5 ----
                    button5.setIcon(new ImageIcon("E:\\study\\java\\MiniChat\\source\\叉叉.png"));
                    button5.setFocusable(false);
                    button5.addActionListener(e -> clear2(e));
                    search_panel2.add(button5);
                    button5.setBounds(370, 30, 50, 40);

                    //---- button6 ----
                    button6.setIcon(new ImageIcon("E:\\study\\java\\MiniChat\\source\\搜索.png"));
                    button6.setFocusable(false);
                    button6.addActionListener(e -> search2(e));
                    search_panel2.add(button6);
                    button6.setBounds(420, 30, 78, 40);
                }
                panel4.add(search_panel2);
                search_panel2.setBounds(0, 0, 565, 100);
                panel4.add(scrollPane1);
                scrollPane1.setBounds(0, 100, 565, 260);
            }
            tabbedPane1.addTab("\u627e\u7fa4", panel4);
        }
        contentPane.add(tabbedPane1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JPanel search_panel;
    private JTextField textField1;
    private JButton button3;
    private JButton button4;
    private JScrollPane user_panel;
    private JPanel panel4;
    private JPanel search_panel2;
    private JTextField textField2;
    private JButton button5;
    private JButton button6;
    private JScrollPane scrollPane1;
    private JPanel user_info_panel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

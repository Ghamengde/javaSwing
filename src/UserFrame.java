import function_frame.AddFriendOrGroup;
import model.User;
import dao.Dao;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
/*
 * Created by JFormDesigner on Tue May 23 10:23:19 CST 2023
 */



/**
 * @author 12094
 */
public class UserFrame extends JFrame {
    public UserFrame(String e_mail) {
        initComponents(e_mail);
    }

    private void initComponents(String user_name) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        User user = Dao.get_user(user_name);
        tabbedPane1 = new JTabbedPane();
        tabbedPane1.setFocusable(false);
        scroll_pane2 = new JScrollPane();
        scroll_pane1 = new JScrollPane();
        panel = new JPanel();
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        add_button = new JButton("添加好友/群组");
        create_group_button = new JButton("创建群组");

        setTitle("APEX顶猎聊天室");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        {
            {
                scroll_pane1.setLayout(null);
                scroll_pane1.setFocusable(false);
            }
            tabbedPane1.addTab("消息", scroll_pane1);

            {
                scroll_pane2.setLayout(null);
                scroll_pane2.setFocusable(false);
            }
            tabbedPane1.addTab("联系人", scroll_pane2);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(0, 55, 283, 455);

        {
            panel1.setLayout(null);

            label1.setText("用户名：" + user.getUser_name());
            panel1.add(label1);
            label1.setBounds(new Rectangle(new Point(5, 5), label1.getPreferredSize()));

            label2.setText("邮箱：" + user.getE_mail());
            panel1.add(label2);
            label2.setBounds(new Rectangle(new Point(5, 30), label2.getPreferredSize()));
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 283, 55);

        {
            panel.setLayout(new FlowLayout(FlowLayout.LEFT));

            add_button.setFocusable(false);
            create_group_button.setFocusable(false);

            add_button.addActionListener(e -> add_friend(e));
            create_group_button.addActionListener(e -> create_group(e));

            panel.add(add_button);
            panel.add(create_group_button);
        }
        contentPane.add(panel);
        panel.setBounds(0, 510, 283, 40);


        {
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(getOwner());
    }

    //创建群组
    private void create_group(ActionEvent e)
    {

    }

    //添加好友
    private void add_friend(ActionEvent e)
    {
        new AddFriendOrGroup().setVisible(true);
    }

    private JTabbedPane tabbedPane1;
    private JScrollPane scroll_pane1;
    private JScrollPane scroll_pane2;
    private JPanel panel;
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JButton add_button;
    private JButton create_group_button;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

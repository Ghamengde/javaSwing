/*
 * Created by JFormDesigner on Tue May 23 08:46:58 CST 2023
 */

package function_frame;

import dao.Dao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author 12094
 */
public class Reg extends JFrame {
    public Reg() {
        initComponents();
    }

    private void reg_in(ActionEvent e) {
        if(pwd_tf.getText().length() <= 6)
        {
            JOptionPane.showMessageDialog(null, "密码必须大于6位");
            return;
        }

        String user_name = user_tf.getText().trim();
        String pwd = pwd_tf.getText().trim();
        int age = Integer.parseInt(age_tf.getText().trim());
        String email = email_tf.getText().trim();

        int i = Dao.reg(user_name, pwd, age, email);
        if(i > 0)
        {
            JOptionPane.showMessageDialog(null, "注册成功");
            Dao.close();
            dispose();
        }
        else if (i == -1)
        {
            JOptionPane.showMessageDialog(null,"该邮箱已被注册");
            Dao.close();
        }
    }

    private void initComponents() {
        user_lb = new JLabel();
        pwd_lb = new JLabel();
        age_lb = new JLabel();
        email_lb = new JLabel();
        user_tf = new JTextField();
        age_tf = new JFormattedTextField();
        email_tf = new JTextField();
        pwd_tf = new JPasswordField();
        label5 = new JLabel();
        button1 = new JButton();

        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setTitle("用户注册：");
        setAutoRequestFocus(false);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        user_lb.setText("用户名：");
        contentPane.add(user_lb);
        user_lb.setBounds(new Rectangle(new Point(50, 30), user_lb.getPreferredSize()));

        pwd_lb.setText("密码：");
        contentPane.add(pwd_lb);
        pwd_lb.setBounds(new Rectangle(new Point(60, 70), pwd_lb.getPreferredSize()));

        age_lb.setText("年龄：");
        contentPane.add(age_lb);
        age_lb.setBounds(new Rectangle(new Point(60, 110), age_lb.getPreferredSize()));

        email_lb.setText("邮箱：");
        contentPane.add(email_lb);
        email_lb.setBounds(new Rectangle(new Point(60, 150), email_lb.getPreferredSize()));
        contentPane.add(user_tf);
        user_tf.setBounds(125, 25, 200, user_tf.getPreferredSize().height);
        contentPane.add(age_tf);
        age_tf.setBounds(125, 105, 55, age_tf.getPreferredSize().height);
        contentPane.add(email_tf);
        email_tf.setBounds(125, 145, 200, email_tf.getPreferredSize().height);
        contentPane.add(pwd_tf);
        pwd_tf.setBounds(125, 65, 155, pwd_tf.getPreferredSize().height);

        label5.setText("(密码大于6位)");
        contentPane.add(label5);
        label5.setBounds(295, 70, 85, label5.getPreferredSize().height);

        button1.setText("注册");
        button1.addActionListener(e -> reg_in(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(150, 200), button1.getPreferredSize()));
        button1.setFocusable(false);

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
        setLocationRelativeTo(null);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel user_lb;
    private JLabel pwd_lb;
    private JLabel age_lb;
    private JLabel email_lb;
    private JTextField user_tf;
    private JFormattedTextField age_tf;
    private JTextField email_tf;
    private JPasswordField pwd_tf;
    private JLabel label5;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

import dao.Dao;
import function_frame.Reg;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Mon May 22 21:55:12 CST 2023
 */



/**
 * @author 12094
 */
public class Login  extends JFrame{
    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        Login frame = new Login();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void LoginIn(ActionEvent e)
    {
        String e_mail = textField1.getText().trim();
        String pwd = passwordField1.getText().trim();

        if(Dao.log(e_mail, pwd) == null)
        {
            JOptionPane.showMessageDialog(null, "账号或密码错误");
        }
        else
        {
            new UserFrame(e_mail).setVisible(true);
            dispose();
        }
    }

    private void reg(ActionEvent e) {
        Reg reg_frame = new Reg();
    }

    public Login()
    {
        initComponents();
        init_label_img();
    }

    void init_label_img()
    {
        ImageIcon icon = new ImageIcon("./source/login.jpg");
        icon.setImage(icon.getImage().getScaledInstance(imglabel.getBounds().width, imglabel.getBounds().height,Image.SCALE_DEFAULT));
        imglabel.setIcon(icon);
    }

    private void initComponents() {
        user_nameLabel = new JLabel();
        label1 = new JLabel();
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();
        imglabel = new JLabel();

        {
            setTitle("APEX顶尖猎杀者聊天室");
            var LoginContentPane = getContentPane();
            LoginContentPane.setLayout(null);

            //---- user_nameLabel ----
            user_nameLabel.setText("邮箱：");
            user_nameLabel.setAlignmentX(5.0F);
            user_nameLabel.setAlignmentY(3.5F);
            user_nameLabel.setMaximumSize(new Dimension(60, 20));
            LoginContentPane.add(user_nameLabel);
            user_nameLabel.setBounds(new Rectangle(new Point(85, 105), user_nameLabel.getPreferredSize()));

            //---- label1 ----
            label1.setText("密码：");
            LoginContentPane.add(label1);
            label1.setBounds(new Rectangle(new Point(85, 150), label1.getPreferredSize()));
            LoginContentPane.add(textField1);
            textField1.setBounds(125, 100, 180, textField1.getPreferredSize().height);
            LoginContentPane.add(passwordField1);
            passwordField1.setBounds(125, 145, 180, passwordField1.getPreferredSize().height);

            //---- button1 ----
            button1.setText("登录");
            button1.addActionListener(e -> LoginIn(e));
            LoginContentPane.add(button1);
            button1.setBounds(new Rectangle(new Point(100, 200), button1.getPreferredSize()));
            button1.setFocusable(false);

            //---- button2 ----
            button2.setText("注册");
            button2.addActionListener(e -> reg(e));
            LoginContentPane.add(button2);
            button2.setBounds(new Rectangle(new Point(215, 200), button2.getPreferredSize()));
            button2.setFocusable(false);

            //---- imglabel ----
            imglabel.setIcon(null);
            LoginContentPane.add(imglabel);
            imglabel.setBounds(0, 0, 400, 85);

            LoginContentPane.setPreferredSize(new Dimension(400, 260));
            pack();
            setLocationRelativeTo(getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    private JLabel user_nameLabel;
    private JLabel label1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton button2;
    private JLabel imglabel;
}

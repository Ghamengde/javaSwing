import javax.swing.*;

public class LabelInScrollPaneExample extends JFrame {
    public LabelInScrollPaneExample() {
        JLabel label = new JLabel("这是一个很长很长很长的标签，需要滚动才能查看全部内容。");
        label.setFont(label.getFont().deriveFont(20.0f));

        JScrollPane scrollPane = new JScrollPane(label);

        add(scrollPane);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LabelInScrollPaneExample();
    }
}
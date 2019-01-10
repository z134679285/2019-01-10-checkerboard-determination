import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class 結果 extends JFrame {
    int i;
    static JPanel panel;
    public Graphics g;
    public 結果(int i){
        this.i = i;
    }
    public void initUI(){
        this.setTitle("結果");
        this.setSize(new Dimension(400,200));
        this.setLocationRelativeTo(null);//螢幕設正中間
        this.setResizable(false);//不可以改變視窗大小
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        this.add(panel,BorderLayout.CENTER);
        if(i == 1){
            JLabel lab = new JLabel("恭喜黑子五連，黑子勝！");
            panel.add(lab,BorderLayout.CENTER);

        }
        else if(i == -1){
            JLabel lab = new JLabel("恭喜白子五連，白子勝！");
            panel.add(lab);
        }

        JPanel pal = new JPanel();
        JButton btn_restart = new JButton("重新開始，雪恥");
        JButton btn_exit = new JButton("退出遊戲，不再來嗎?");

        btn_restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "那是否重來打開再戰?";
                if (JOptionPane.showConfirmDialog(null, str, "重新開始",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    System.exit(0); // 退出
                }

            }
        });
        btn_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "你確定要退出?";
                if (JOptionPane.showConfirmDialog(null, str, "棋王是你!!!",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    System.exit(0); // 退出
                }
            }
        });
//        btn_restart.setActionCommand("restart");
//        btn_exit.setActionCommand("exit");

        pal.setLayout(new FlowLayout());
        this.add(pal,BorderLayout.SOUTH);
        pal.add(btn_restart);
        pal.add(btn_exit);
        this.setVisible(true);

    }
//    class frame{
//    public  frame(){
//        棋盤 frm =new 棋盤();
//        frm.setVisible(true);
//    }}
}

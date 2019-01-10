

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class 棋盤 extends JFrame {

    private Container cp;
    public Graphics g;

    public interface 棋盤設定 {
        public static final int Row = 15;
        public static  int Column = 15;
        public static final int X = 30;
        public static final int Y = 60;
        public static final int size = 40;
        public static final int spacing = 40;

    }
    public 棋盤() {
        init();
    }

    private void init() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("翔傑的五子棋");
        this.setSize(new Dimension(650, 650));
        this.setResizable(false);
//        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);//螢幕設正中間
        this.setLayout(null);

        JPanel jp = new  JPanel() {
            public void paint(Graphics g) {
                g.setColor(Color.BLACK);
                super.paint(g);
                // 畫15行
                for (int i = 0; i < 15; i++) {
                    g.drawLine(20, 20 + i * 棋盤設定.spacing, 20
                                    + (棋盤設定.Column - 1) * 棋盤設定.spacing,
                            20 + i * 棋盤設定.spacing);
                }
                // 畫15列
                for (int i = 0; i < 15; i++) {
                    g.drawLine(20 + i *棋盤設定.spacing, 20, 20 + i
                            * 棋盤設定.spacing, 20
                            + (棋盤設定.Column - 1) * 棋盤設定.spacing);
                }
                g.setColor(Color.BLACK);//畫棋盤上黑點
                g.fillOval(133, 133, 15, 15);
                g.fillOval(293, 133, 15, 15);
                g.fillOval(453, 133, 15, 15);
                g.fillOval(133, 293, 15, 15);
                g.fillOval(293, 293, 15, 15);
                g.fillOval(453, 293, 15, 15);
                g.fillOval(133, 453, 15, 15);
                g.fillOval(293, 453, 15, 15);
                g.fillOval(453, 453, 15, 15);



            }
        };
        jp.setBackground(new Color(209, 167, 78));
        jp.setBounds(10, 10, 602, 602);
        this.add(jp);
        this.setVisible(true);
        g = jp.getGraphics();
        /*
         * 添加監聽器     (設定滑鼠跟判定)
         */
      滑鼠跟判定 lis = new 滑鼠跟判定(g);
      jp.addMouseListener(lis);

    }
}
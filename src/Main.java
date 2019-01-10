import javafx.scene.chart.PieChart;
import javafx.scene.media.AudioClip;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        棋盤 frm =new 棋盤( );
        frm.setVisible(true);
        AudioClip ac;
        ac = new AudioClip(new File("C:\\Users\\user\\Documents\\GitHub\\106021150-05-18\\music\\fight.mp3").toURI().toString());
        ac.play();
        ac.setCycleCount(5);
        //开始播放
//      PieChart frm =new PieChart();
//      frm.setVisible(true);
    }

}

//        server frm = new server();
//        frm.setVisible(true);
	 //ComBobox下拉式選單
     //JTextFiled可輸入密碼
     //JTextArea可調整範圍的
     //JScorllPane捲軸 把JTextArea加進去
     //JRadioButton可選擇圈圈(不可複選)
     //ButtonGroup把圈圈給它控管
        //JProgressBar進度讀取條



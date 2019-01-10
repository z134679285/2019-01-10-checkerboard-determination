import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class 滑鼠跟判定 extends MouseAdapter {
    public Graphics g;
    public int x, y;
    public boolean flag = true;
    public static String[][] array = new String[700][700];
    public static int[][] array_win = new int[15][15];
    public static 結果 result;


    public 滑鼠跟判定(Graphics g) {
        this.g = g;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x = correctxy(e.getX());
        y = correctxy(e.getY());
        if (x < 582 && x >= 0 && y < 582 && y >= 0) {
            if (flag && array[x][y] == null) {
                g.setColor(Color.BLACK);
                g.fillOval(x, y, 棋盤.棋盤設定.size,
                        棋盤.棋盤設定.size);

                array[x][y] = "black";

                array_win[getXY(y)][getXY(x)] = 1;
                flag = false;

            } else if (array[x][y] == null) {
                g.setColor(Color.WHITE);
                g.fillOval(x, y, 棋盤.棋盤設定.size,
                        棋盤.棋盤設定.size);

                array[x][y] = "white";

                array_win[getXY(y)][getXY(x)] = -1;

                flag = true;
            }

            if (Win(getXY(y), getXY(x)) == 1) {
                result = new 結果(1);
                result.initUI();
            } else if (Win(getXY(y), getXY(x)) == -1) {
                result = new 結果(-1);
               result.initUI();
            }
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    System.out.print(array_win[i][j] + "  ");
                }
                System.out.println("");
           }
            System.out.println("");
        }

    }


    private int correctxy(int x) {
        x = x / 40;
        return x * 40;
    }

    public int getXY(int x) {
        x = x / 40;
        return x;
    }
    public boolean winRow(int row, int column) {
        int count = 1;
        for (int i = column + 1; i < 15; i++) {// 向右查找
            if (array_win[row][column] == array_win[row][i]) {
                count++;
            } else
                break;
        }
        for (int i = column - 1; i >= 0; i--) {// 向左查找
            if (array_win[row][column] == array_win[row][i]) {
                count++;
            } else
                break;
        }

        if (count >= 5) {
            return true;
        } else
            return false;
    }


    // 判定豎向五個相連

    public boolean winColumn(int row, int column) {
        int count = 1;
        for (int i = row + 1; i < 15; i++) {// 向右查找
            if (array_win[row][column] == array_win[i][column]) {
                count++;
            } else
                break;
        }
        for (int i = row - 1; i >= 0; i--) {// 向左查找
            if (array_win[row][column] == array_win[i][column]) {
                count++;
            } else
                break;
        }
        if (count >= 5) {
            return true;
        } else
            return false;
    }

    //判定斜向右下五個相連

    public boolean winRightDown(int row, int column) {
        int count = 1;
        for (int i = column + 1, j = row + 1; i < 15 && j < 15; i++, j++) {// 向右查找
            if (array_win[row][column] == array_win[j][i]) {
                count++;
            } else
                break;
        }
        for (int i = column - 1, j = row - 1; i >= 0 && j >= 0; i--, j--) {// 向左查找
            if (array_win[row][column] == array_win[j][i]) {
                count++;
            } else
                break;
        }
        if (count >= 5) {
            return true;
        } else
            return false;
    }

    //判定斜向左下五個相連

    public boolean winLeftDown(int row, int column) {
        int count = 1;
        for (int i = column - 1, j = row + 1; i >=0 && j < 15; i--, j++) {// 向右查找
            if (array_win[row][column] == array_win[j][i]) {
                count++;
            } else
                break;
        }
        for (int i = column + 1, j = row - 1; i <15 && j >= 0; i++, j--) {// 向左查找
            if (array_win[row][column] == array_win[j][i]) {
                count++;
            } else
                break;
        }
        if (count >= 5) {
            return true;
        } else
            return false;
    }

    public int Win(int row, int column) {
        if (winRow(row, column) || winColumn(row, column)
                || winRightDown(row, column) || winLeftDown(row, column)) {
            if (array_win[row][column] == 1)
                return 1;
            else if (array_win[row][column] == -1)
                return -1;
        }
        return 0;
    }

}

import java.awt.*;
import javax.swing.*;

public class GradeBookView extends JPanel {
    IPen heyPen;
    int x_pos = 25;
    int y_pos = 10;
    public GradeBookView(IPen iPen) {
        heyPen=iPen;
        JFrame frame = new JFrame();
        frame.getContentPane().add(this);
        frame.setSize(1000,600);
        frame.setVisible(true);
        frame.setTitle("Gradebook");
    }
    private void drawRow(String row,int x_pos,int y_pos, Graphics g) {
        g.drawString( row, x_pos, y_pos );
    }
    private void drawStudentsGrades(String[] students,int grades[][], Graphics g){
        int spaceBetween=15;
        for(int i = 0 ; i < students.length;i++){
            drawRow(heyPen.writeStudentGrades(students[i],grades[i])
                    ,x_pos,y_pos+spaceBetween*(i+2),g);
        }
    }
    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        drawRow(heyPen.writeTableTitle(),x_pos,y_pos,g);
        drawStudentsGrades(heyPen.getStudentsName(),heyPen.getGrades(),g);
    }


}
import javax.swing.*;

public class GradeBookController {
    public static void main(String[] args) {
        String s = JOptionPane.showInputDialog("Type the number of the students");
        String g = JOptionPane.showInputDialog("Type the number of the subjects");
        int students = new Integer(s).intValue();
        int subjects = new Integer(g).intValue();
        GradeBook obj = new GradeBook("Struktura e te dhenave", students, subjects);
        IPen iPen = new IPen(obj);
        iPen.writeTheDiary();
        new GradeBookView(iPen);
    }
}

import javax.swing.*;
import java.util.Arrays;

public class IPen {
    GradeBook myGradeBook;
    int largest_name;
    int largest_subject_name;
    public IPen(GradeBook book){
        myGradeBook=book;
    }
    public int[][] getGrades(){
        return myGradeBook.getGrades();
    }
    public String[] getStudentsName(){
        return myGradeBook.getStudentNames();
    }
    public String[] getSubjectsName(){
        return myGradeBook.getSubjectNames();
    }
    private String setStudentName(int number) {
        return JOptionPane.showInputDialog("Please type the name of Student nr. " + number);
    }

    private int setStudentGrade(String subject) {
        String grade = JOptionPane.showInputDialog("Type the grade for " + subject);
        int grade_value = -1; //set a value -1 which will be used on the if statement to check if the grade has set correctly
        if ( Integer.parseInt(grade) >= 0 && Integer.parseInt(grade) <= 10)//check if grade is from 0 to 10 also with that checks if it is an integer
        {
            grade_value = Integer.parseInt(grade); //setting the grade
        } else {
            JOptionPane.showMessageDialog(null, "Please type a number, with a range from 0 to 10, including 0 or 10!");//throwing an error
        }
        return (grade_value >= 0) ? grade_value : setStudentGrade(subject);//if the statement has passed then return the grade otherwise recall the function untill there's a grade.
    }
    public String setSubjectName(int number) {
        String subject = JOptionPane.showInputDialog("Please type the name of Subject nr. " + number);
        boolean isOk = false;
        if (subject == null || subject.length() < 3) {
            JOptionPane.showMessageDialog(null, "The subject name has to be larger than 2 letters!");
        } else {
            isOk = true;
        }
        return (isOk) ? subject : setSubjectName(number);
    }
    public int findLargestName(String[] names){
        int largest = -1;
        for(int i = 0; i<names.length;i++){
            if(names[i].length()>largest)largest=names[i].length();
        }
        return largest+4;
    }
    private String setAlignment(String name, int align){
        char[] repeat = new char[align-name.length()];// subtracting the align length with the name's length
        Arrays.fill(repeat,' ');//filling the characters with ' ', which will be used as a tool to adjust space between names and grades
        return name+=new String(repeat);// making the full string of spaces and returning it with the name
    }
    private String Average(){
        return "| Average";
    }
    private String TableTitle(String[] subjects,String[] students){
        String row = setAlignment("", largest_name);
        for(int i = 0 ;i<subjects.length;i++){
            row+="| "+setAlignment(subjects[i],largest_subject_name);
        }
        row+=Average();
        return row;
    }
    public String writeTableTitle(){
        return TableTitle(myGradeBook.getSubjectNames(),myGradeBook.getStudentNames());
    }
    public String writeStudentGrades(String student, int grades[]){
        String row = setAlignment(setAlignment(student ,largest_name),largest_name);
        for(int i = 0 ; i < grades.length;i++){
            row+=setAlignment("| "+grades[i],largest_subject_name);
        }
        row +="| "+ myGradeBook.getAverage(grades);
        return row;
    }
    public void setSubjectNames() {
        String[] subjectNames = myGradeBook.getSubjectNames();
        for (int i = 0; i < subjectNames.length; i++) {
            subjectNames[i] = setSubjectName(i + 1);
        }
        largest_subject_name= findLargestName(subjectNames);
        myGradeBook.setSubjectNames(subjectNames);
    }
    public void setStudentsNameAndGrades() {
        String[] studentNames = myGradeBook.getStudentNames();
        String[] subjectNames = myGradeBook.getSubjectNames();
        int[][] grades= myGradeBook.getGrades();
        for (int i = 0; i < studentNames.length; i++) {
            studentNames[i] = setStudentName(i + 1);// qitu i qesum emrat e studenteve
            for (int j = 0; j < grades[i].length; j++) {
                grades[i][j] = setStudentGrade(subjectNames[j]);//qitu i qesum notat
            }
        }
        largest_name = findLargestName(studentNames);
        myGradeBook.setStudentNames(studentNames);// i vendosim emrat ne GradeBook(ditar)
        myGradeBook.setGrades(grades);// i vendosim te gjitha notat ne GradeBook(ditar);
    }
    public void writeTheDiary(){
        setSubjectNames();
        setStudentsNameAndGrades();
    }
}

public class GradeBook {
    private String courseName; // name of course this grade book represents
    private String[] studentNames;
    private String[] subjectNames;
    private int[][] grades; // two-dimensional array of student grades

    // two-argument constructor initializes courseName and grades array
    public GradeBook(String courseName, int studentNumbers, int subjectsNumber) {
        this.courseName = courseName;
        studentNames = new String[studentNumbers];
        subjectNames = new String[subjectsNumber];
        grades = new int[studentNumbers][subjectsNumber];
    }
    public void setStudentNames(String[] students){
        this.studentNames=students;
    }
    public void setSubjectNames(String[] subjects){
        this.subjectNames=subjects;
    }
    public void setGrades(int[][] grades){
        this.grades=grades;
    }
    public String[] getStudentNames() {
        return studentNames;
    }

    public String[] getSubjectNames() {
        return subjectNames;
    }
    public int[][] getGrades() {
        return grades;
    }
    public String getCourseName() {
        return courseName;
    }
  
    public double getAverage(int[] setOfGrades) {
        int total = 0;
        // sum grades for one student
        for (int grade : setOfGrades) {
            total += grade;
        }
        // return average of grades
        return (double) total / setOfGrades.length;
    }
}



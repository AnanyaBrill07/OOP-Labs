package lab4.Q1;
public class GradStudent extends PSUStudent {
    private boolean passThesis;

    
    public GradStudent(int age, double gpa) {
        super(age, gpa);
        this.passThesis = false;
    }

    
    @Override
    public void setPassThesis(boolean passThesis) {
        this.passThesis = passThesis;
    }

    public boolean isPassThesis() {
        return passThesis;
    }

    
    @Override
    public double revealGrade() {
        if (this.passThesis) {
            return getGpa();
        }
        return 0.0d;
    }
}
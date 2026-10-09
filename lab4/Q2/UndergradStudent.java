package lab4.Q2;
public class UndergradStudent extends PSUStudent {
    private int currentYear;

    public UndergradStudent(int age, double gpa) {
        super(age, gpa);
        this.currentYear = 1;
    }

    @Override
    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    @Override
    public double revealGrade() {
        if (this.currentYear >= 4) {
            return getGpa();
        }
        return 0.0d;
    }
}
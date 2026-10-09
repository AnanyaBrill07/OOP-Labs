package lab4.Q1;
public abstract class PSUStudent {
    private int age;
    private double gpa;

  
    public PSUStudent(int age, double gpa) {
        this.age = age;
        this.gpa = gpa;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    
    public abstract double revealGrade();

    
    public void setCurrentYear(int currentYear) {}
    public void setPassThesis(boolean passThesis) {}
}

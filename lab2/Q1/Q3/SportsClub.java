package Q3;
public class SportsClub extends Club {

    public SportsClub(String c, int m) {
        super(c, m);
    }

    @Override
    public int determineBudget() {
        return (numMember * 1000) + (numMember - minNumMember) * 100;
    }

    @Override
    public void changeName(String newName) {
        // SportsClub does not allow its name to be changed
    }
}
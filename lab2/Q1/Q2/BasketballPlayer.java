package Q2;
public class BasketballPlayer extends Player {

    public BasketballPlayer(String name, int jerseyNumber) {
        super(name, jerseyNumber);
    }

    @Override
    public void playGame() {
        minutesPlayed = minutesPlayed + 48;
    }

    public void changeJerseyNumber(int newNumber) {
        jerseyNumber = newNumber;
        System.out.println(name + " changes number to " + jerseyNumber);
    }
}
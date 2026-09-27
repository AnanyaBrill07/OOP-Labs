package Q2;
public class FootballPlayer extends Player {

    public FootballPlayer(String name, int jerseyNumber) {
        super(name, jerseyNumber);
    }

    @Override
    public void playGame() {
        minutesPlayed = minutesPlayed + 90;
    }
}
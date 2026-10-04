package lab3.Q2;
public class ClubManagingSystemTest {
    public static void main(String[] args) {
        Club[] clubs = new Club[4];

        Club student = new Club("Student", 10);
        student.addMember(190); 
        clubs[0] = student;

        
        SportsClub football = new SportsClub("Football", 22);
        football.addMember(18);
        clubs[1] = football;

        
        clubs[2] = new ESportsClub("RoV", 5);

        
        MarketingClub advertising = new MarketingClub("Advertising", 2, 100);
        advertising.addMember(8); 
        clubs[3] = advertising;

        ClubManagingSystem system = new ClubManagingSystem(clubs);

        System.out.println("Highest member club: " + system.getHighestMemberClub().getName());
        System.out.println("Total budget: " + system.determineAllBudget());
        System.out.println("Total members: " + system.getAllMembers());

        System.out.println("\nExpected: highest = Student (200), total budget = 257200, total members = 255");
        System.out.println("Every loop in ClubManagingSystem is typed as Club, but each");
        System.out.println("call to determineBudget()/getNumMember() runs the ACTUAL object's");
        System.out.println("version (Club, SportsClub, or MarketingClub) - that's subtype polymorphism.");
    }
}
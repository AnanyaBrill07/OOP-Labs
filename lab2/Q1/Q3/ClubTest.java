package Q3;
public class ClubTest {
    public static void main(String[] args) {
        System.out.println("--- SportsClub ---");
        SportsClub sports = new SportsClub("Runners", 20);
        sports.advertise();
        System.out.println("Budget (before adding members): " + sports.determineBudget());
        sports.addMember(5);
        System.out.println("Budget (after adding 5 members): " + sports.determineBudget());
        sports.changeName("Sprinters");
        System.out.println("Name after attempted change: " + sports.getName());

        System.out.println("\n--- MarketingClub ---");
        MarketingClub marketing = new MarketingClub("Ad Wizards", 10, 1500);
        marketing.advertise();
        System.out.println("Budget when internal budget > 1000: " + marketing.determineBudget());

        boolean success1 = marketing.useBudget(600);
        System.out.println("useBudget(600) succeeded? " + success1);
        System.out.println("Budget when internal budget <= 1000: " + marketing.determineBudget());

        boolean success2 = marketing.useBudget(10000);
        System.out.println("useBudget(10000) succeeded? " + success2);
    }
}
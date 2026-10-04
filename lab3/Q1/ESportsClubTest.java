public class ESportsClubTest {
    public static void main(String[] args) {
        System.out.println("--- Declared as ESportsClub ---");
        ESportsClub e = new ESportsClub("Esport", 100);
        System.out.println("name: " + e.getName());
        System.out.println("numMember: " + e.getNumMember());
        e.advertise();                               
        System.out.println("determineBudget(): " + e.determineBudget());
        System.out.println("getName(): " + e.getName());

        System.out.println("\n--- Same object, declared as Club ---");
        Club c = new ESportsClub("Esport", 100);
        c.advertise();                                
        System.out.println("determineBudget(): " + c.determineBudget());
        System.out.println("getName(): " + c.getName());

        System.out.println("\nBoth blocks print identical results.");
        System.out.println("The declared (compile-time) type is Club, but Java");
        System.out.println("looks at the actual (run-time) object to decide which");
        System.out.println("overridden method to run - this is dynamic dispatch,");
        System.out.println("the mechanism behind subtype polymorphism.");
    }
}
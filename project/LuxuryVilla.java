public class LuxuryVilla extends Accommodation {
    private boolean hasPrivatePool;

    public LuxuryVilla(String roomNumber, double nightlyRate, boolean occupied, String guestName, boolean hasPrivatePool) {
        super(roomNumber, nightlyRate, occupied, guestName);
        this.hasPrivatePool = hasPrivatePool;
    }

    public boolean hasPrivatePool() { 
        return hasPrivatePool; 
    }

    @Override
    public String getDetailedInfo() {
        String poolText = hasPrivatePool ? "Yes" : "No";
        return "[Luxury Villa] " + getStaySummary() + " | Private Pool: " + poolText;
    }
}
public class StandardRoom extends Accommodation {
    private String floorLevel;
    private boolean hasExtraBed;

    public StandardRoom(String roomNumber, double nightlyRate, boolean occupied, String guestName, String floorLevel, boolean hasExtraBed) {
        super(roomNumber, nightlyRate, occupied, guestName);
        this.floorLevel = floorLevel;
        this.hasExtraBed = hasExtraBed;
    }

    public String getFloorLevel() { 
        return floorLevel; 
    }

    public boolean hasExtraBed() { 
        return hasExtraBed; 
    }

    @Override
    public String getDetailedInfo() {
        String bedText = hasExtraBed ? "Yes" : "No";
        return "[Standard Room] " + getStaySummary() + " | Floor: " + floorLevel + " | Extra Bed: " + bedText;
    }
}
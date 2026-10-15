public abstract class Accommodation implements AccommodationType {
    protected String roomNumber;
    protected String guestName;
    protected double nightlyRate;
    protected boolean occupied;

    public Accommodation(String roomNumber, double nightlyRate, boolean occupied, String guestName) {
        this.roomNumber = roomNumber;
        this.nightlyRate = nightlyRate;
        this.occupied = occupied;
        this.guestName = guestName;
    }

    public String getRoomNumber() { 
        return roomNumber; 
    }

    public String getGuestName() { 
        return guestName; 
    }

    public double getNightlyRate() { 
        return nightlyRate; 
    }

    public boolean isOccupied() { 
        return occupied; 
    }

    public void setGuestName(String guestName) { 
        this.guestName = guestName; 
    }
    
    public void setOccupied(boolean occupied) { 
        this.occupied = occupied; 
    }

    public final String getStaySummary() {
        String statusText;
        if (occupied) {
            statusText = "Occupied by " + guestName;
        } else {
            statusText = "Vacant";
        }
        return "Room: " + roomNumber + " | Status: " + statusText + " | Rate: $" + nightlyRate + "/night";
    }

    public abstract String getDetailedInfo();
}
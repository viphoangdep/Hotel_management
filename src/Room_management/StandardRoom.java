package Room_management;

public class StandardRoom extends Room {
    private boolean havingShower ;
    
    public StandardRoom(boolean havingShower) {
        this.havingShower = havingShower;
    }

    public StandardRoom(int room_id, double price, String check_in_date, int numOfDay, int numOfBed,
            boolean isAvailable, boolean havingShower) {
        super(room_id, price, check_in_date, numOfDay, numOfBed, isAvailable);
        this.havingShower = havingShower;
    }
    public boolean isHavingShower() {
        return havingShower;
    }

    public void setHavingShower(boolean havingShower) {
        this.havingShower = havingShower;
    };
    public double calculatePrice(){
        return this.getNumOfDay()*this.getPrice();
    }

    
}

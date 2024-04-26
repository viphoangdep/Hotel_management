package Room_management ;

public abstract class Room {
    private int room_id;
    private double price;
    private String check_in_date;
    private String check_out_date;
    

    private int numOfDay ;
    private int numOfBed ;
    private boolean isAvailable;
    public Room(){
        this.room_id = 0;
        this.price = 0;
        this.check_in_date = "";
        this.check_out_date = "";
        this.numOfDay = 0;
        this.numOfBed = 0;
        this.isAvailable = false;
    }
    public Room(int room_id, double price, String check_in_date, int numOfDay, int numOfBed, boolean isAvailable){
        this.room_id = room_id;
        this.price = price;
        this.check_in_date = check_in_date;
        this.check_out_date = "";
        this.numOfDay = numOfDay;
        this.numOfBed = numOfBed;
        this.isAvailable = isAvailable;
    }
    public int getRoom_id() {
        return room_id;
    }
    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getCheck_in_date() {
        return check_in_date;
    }
    public void setCheck_in_date(String check_in_date) {
        this.check_in_date = check_in_date;
    }
    public int getNumOfDay() {
        return numOfDay;
    }
    public void   setNumOfDay(int numOfDay) {
        this.numOfDay = numOfDay;
    }
    public int getNumOfBed() {
        return numOfBed;
    }
    public void setNumOfBed(int numOfBed) {
        this.numOfBed = numOfBed;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public  void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public String getCheck_out_date() {
        return check_out_date;
    }
    public void setCheck_out_date(String check_out_date) {
        this.check_out_date = check_out_date;
    }
    abstract double calculatePrice();
    
}

package Room_management;

public class SuiteRoom extends Room{
    private String electricDevices;
    private int numOfUnit;
    public SuiteRoom(String electricDevices, int numOfUnit) {
        super();
        this.electricDevices = "";
        this.numOfUnit = 0;
    }
    public SuiteRoom(int room_id, double price,String check_in_date, int numOfDay, int numOfBed, boolean isAvailable, String electricDevices,
            int numOfUnit) {
        super(room_id, price, check_in_date, numOfDay, numOfBed, isAvailable);
        this.electricDevices = electricDevices;
        this.numOfUnit = numOfUnit;
    }
    public String getElectricDevices() {
        return electricDevices;
    }
    public void setElectricDevices(String electricDevices) {
        this.electricDevices = electricDevices;
    }
    public int getNumOfUnit() {
        return numOfUnit;
    }
    public void setNumOfUnit(int numOfUnit) {
        this.numOfUnit = numOfUnit;
    }
    public double calculatePrice(){
        return this.getNumOfDay()*this.getPrice();
    }
    

}

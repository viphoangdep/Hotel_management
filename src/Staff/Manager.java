package Staff;
import Service.Service;
import Utility.*;
public class Manager extends Employee {
    

    public Manager(int iD, String name, Boolean gender, String phone, String job, int unitTasks, double salary,
            Boolean status, Service task) {
        super(iD, name, gender, phone, job, unitTasks, salary, status, task);
    }

    public Manager() {
        super();
    }
    public void addEmployee(Employee employee){
        System.out.println("hello mother fucker");
    }
    public void doWork(){
        System.out.println("Manager do work");
    }
    public void doJob(){
        System.out.println("nah");
    }
}

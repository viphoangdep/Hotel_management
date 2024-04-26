package Staff;
import Service.*;
import Utility.Person;
public class Employee extends Person{
    private String job;
    private int unitTasks;
    private double salary;
    private Boolean status;
    private Service task;
    public Employee() {
        this.job = "" ;
        this.unitTasks = 0;
        this.salary = 0.0;
        this.status = false;
        this.task = null;
    }
    public Employee(int iD, String name, Boolean gender, String phone, String job, int unitTasks, double salary,
            Boolean status, Service task) {
        super(iD, name, gender, phone);
        this.job = job;
        this.unitTasks = unitTasks;
        this.salary = salary;
        this.status = status;
        this.task = task;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public int getUnitTasks() {
        return unitTasks;
    }
    public void setUnitTasks(int unitTasks) {
        this.unitTasks = unitTasks;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public Service getTask() {
        return task;
    }
    public void setTask(Service task) {
        this.task = task;
    }
    @Override
    public String toString() {
        System.out.println(this.getName() + " " + job + " " + salary + " " + status + " " + task + " " + unitTasks);
        return "Employee [job=" + job + ", salary=" + salary + ", status=" + status + ", task=" + task + ", unitTasks="
                + unitTasks + "]";
    }

}
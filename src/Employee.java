import java.util.ArrayList;
/**
 * @author Jacob Sandefur
 * @version 3/31/2020
 */

public class Employee {
    private int id;
    private String name;
    private String address;
    private double hourlyRate;
    private double hoursWorked;
    private ArrayList<String> actionList;

    public Employee(int id, String name, String address, double hourlyRate, double hoursWorked,
                    ArrayList<String> actionList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.actionList = actionList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public ArrayList<String> getActionList() {
        return actionList;
    }

    public void setActionList(ArrayList<String> actionList) {
        this.actionList = actionList;
    }

    public void recordAction(int patronId, int bookId, int code) {
        String act = patronId + "-" + bookId + "-" + code;
        actionList.add(act);

    }


}

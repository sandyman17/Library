import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 * @author Jacob Sandefur
 * @version 3/31/2020
 */

public class User {
    private ArrayList<Employee> employees;
    private ArrayList<Patron> patrons;

    public User() throws FileNotFoundException {
        this.employees = new ArrayList<Employee>();
        this.patrons = new ArrayList<Patron>();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<Patron> getPatrons() {
        return patrons;
    }

    public void setPatrons(ArrayList<Patron> patrons) {
        this.patrons = patrons;
    }

    public void loadUsers(File employeeRecords, File patronRecords) throws UnsupportedFileException, IOException {
        if (patronRecords.exists() && employeeRecords.exists()) {

            FileReader fr1 = new FileReader(employeeRecords);
            FileReader fr2 = new FileReader(patronRecords);

            BufferedReader br1 = new BufferedReader(fr1);
            BufferedReader br2 = new BufferedReader(fr2); //1 is employees, 2 is patrons
            
            String employLine = br1.readLine();

            while (employLine != null) {
                //read employee lines
                String[] data = employLine.split(", ");

                if (data.length != 6) {
                    throw new UnsupportedFileException("Missing Fields");
                }

                int id = Integer.parseInt(data[0]);
                double hourlyRate = Double.parseDouble(data[3]);
                double hoursWorked = Double.parseDouble(data[4]);

                String[] actionsStr = data[5].split(" ");
                ArrayList<String> actions = new ArrayList<String>();

                for (int i = 0; i < actionsStr.length; i++) {
                    actions.add(actionsStr[i]);
                }

                employees.add(new Employee(id, data[1], data[2], hourlyRate, hoursWorked, actions));

                employLine = br1.readLine();
            }

            br1.close();
            fr1.close();

            String patronLine = br2.readLine();

            while (patronLine != null) {
                //read paton lines
                String[] data = patronLine.split(", ");

                if (data.length != 6) {
                    throw new UnsupportedFileException("Missing Fields");
                }

                int id = Integer.parseInt(data[0]);

                String[] actionsStr = data[5].split(" ");
                ArrayList<Integer> actions = new ArrayList<Integer>();

                for (int i = 0; i < actionsStr.length; i++) {
                    actions.add(Integer.parseInt(actionsStr[i]));
                }

                patrons.add(new Patron(id, data[1], data[2], data[3], data[4], actions));
                patronLine = br2.readLine();
            }

            br2.close();
            fr2.close();
        }
        
        else {
            throw new FileNotFoundException();
        }

    }
    
    public void writeUsers(File employeeRecords, File patronRecords) throws IOException {
        
        FileOutputStream fos1 = new FileOutputStream(employeeRecords);
        FileOutputStream fos2 = new FileOutputStream(patronRecords);

        PrintWriter pw1 = new PrintWriter(fos1);
        PrintWriter pw2 = new PrintWriter(fos2);

        for (Employee employee : employees) {
            StringBuilder sb = new StringBuilder();
            Employee currentEmployee = employee;
            sb.append(currentEmployee.getId());
            sb.append(", ");
            sb.append(currentEmployee.getName());
            sb.append(", ");
            sb.append(currentEmployee.getAddress());
            sb.append(", ");
            sb.append(String.format("%.2f", currentEmployee.getHourlyRate()));
            sb.append(", ");
            sb.append((int) currentEmployee.getHoursWorked());
            sb.append(",");

            for (int j = 0; j < currentEmployee.getActionList().size(); j++) {
                sb.append(" ");
                sb.append(currentEmployee.getActionList().get(j));
            }

            pw1.println(sb.toString());
        }

        pw1.close();
        fos1.close();

        for (int i = 0; i < patrons.size(); i++) {
            StringBuilder sb = new StringBuilder();
            Patron currentPatron = patrons.get(i);

            sb.append(currentPatron.getId());
            sb.append(", ");
            sb.append(currentPatron.getName());
            sb.append(", ");
            sb.append(currentPatron.getAddress());
            sb.append(", ");
            sb.append(currentPatron.getEmail());
            sb.append(", ");

            for (int j = 0; j < currentPatron.getBookLoanList().size(); j++) {
                sb.append(currentPatron.getBookLoanList().get(i));
                sb.append(", ");
            }

            pw2.println(sb.toString());
        }

        pw2.close();
        fos2.close();

    }

    public void addEmployee(Employee employee) {
        employees.add(employee);

    }

    public void addPatron(Patron patron) {
        patrons.add(patron);

    }

    public boolean removeEmployee(int id) {
        if (id >= 0 && employees.size() > 0) {
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getId() == id) {
                    employees.remove(employees.get(i));
                    return true;
                }
            }
        }

        return false;

    }

    public boolean removePatron(int id) {
        if (id >= 0 && patrons.size() > 0) {
            for (int i = 0; i < patrons.size(); i++) {
                if (patrons.get(i).getId() == id) {
                    patrons.remove(patrons.get(i));
                    return true;
                }
            }
        }

        return false;

    }

}

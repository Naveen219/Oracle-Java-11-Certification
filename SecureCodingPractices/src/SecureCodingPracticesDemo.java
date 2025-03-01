import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Company implements Cloneable {
    protected  List<String> empNames;
    public Company(List<String> empNames) {
        this.empNames = empNames;
    }
    public List<String> getEmployeeNames() {


        // returns the original list, any operation on the object by the caller can change the state of
        // empNames which is not ideal
 //       return empNames;
        // defensive coding so the state cannot be changed / modified
        return new ArrayList<>(this.empNames);

    }
    @Override
    protected  Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
public class SecureCodingPracticesDemo {
    public static void main(String[] args) throws Exception {
        List<String> employees = new ArrayList<>(Arrays.asList("Naveen", "Rohit", "Virat","Dhoni"));
        Company company = new Company(employees);
        Company companyClone = (Company)company.clone();
       // System.out.println(companyClone.getEmployeeNames());
        company.getEmployeeNames().clear();
        System.out.println(company.getEmployeeNames());
        System.out.println(company.getEmployeeNames().equals(companyClone.getEmployeeNames()));
        System.out.println(company.getEmployeeNames() == companyClone.getEmployeeNames());
    }



}

package lists;

import entities.Employee;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeMinimumWageList {
  private Map<String, String> list = new HashMap<String, String>();

  private final BigDecimal minimumWage = BigDecimal.valueOf(1212.00);

  public EmployeeMinimumWageList(EmployeeList employeeList) {
    this.list = getEmployeeMinimumWageList(employeeList.getList());
  }

  public Map<String, String> getList() {
    return list;
  }

  public Map<String, String> getEmployeeMinimumWageList(List<Employee> employees) {
    Map<String, String> employeeMinimumWageList = new HashMap<String, String>();

    for (Employee employee : employees) {
      BigDecimal salary = employee.getSalary();
      BigDecimal totalMinimumWage = salary.divide(minimumWage, 2, RoundingMode.HALF_UP);

      employeeMinimumWageList.put(employee.getName(), totalMinimumWage.toString());
    }

    return employeeMinimumWageList;
  }
}

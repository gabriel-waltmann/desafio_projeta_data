package logs;

import lists.EmployeeList;

public class EmployeeTotalSalaryLog {
  public EmployeeTotalSalaryLog(EmployeeList employeeList) {
    String totalSalary = employeeList.getTotalSalary();

    System.out.println("Total dos salarios de todos os funcionarios: " + totalSalary);
  }
}

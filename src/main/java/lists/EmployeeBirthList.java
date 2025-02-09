package lists;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeBirthList {
  private List<Employee> list = new ArrayList<Employee>();
  List<Integer> birthMonths = new ArrayList<Integer>();

  public EmployeeBirthList(
      EmployeeList employeeList,
      List<Integer> birthMonths
  ) {
    this.birthMonths = birthMonths;
    List<Employee> birthEmployees = getBirthEmployees(employeeList.getList(), birthMonths);

    this.list = birthEmployees;
  }

  public List<Employee> getList() {
    return list;
  }

  public List<Integer> getBirthMonths() {
    return birthMonths;
  }

  private List<Employee> getBirthEmployees(
      List<Employee> employees,
      List<Integer> birthMonths
  ) {
    List<Employee> birthEmployees = new ArrayList<Employee>();

    for (Employee employee : employees) {
      int mes = employee.getBirthDate().getMonthValue();

      if (birthMonths.contains(mes)) {
        birthEmployees.add(employee);
      }
    }

    return birthEmployees;
  }
}

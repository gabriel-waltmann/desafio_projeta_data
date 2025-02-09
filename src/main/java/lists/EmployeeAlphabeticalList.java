package lists;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAlphabeticalList {
  private List<Employee> list;

  public EmployeeAlphabeticalList(EmployeeList employeeList) {
    this.list = getEmployeeAlphabeticalList(employeeList.getList());
  }

  public List<Employee> getList() {
    return this.list;
  }

  public List<Employee> getEmployeeAlphabeticalList(List<Employee> employees) {
    List<Employee> employeeAlphabeticalList = new ArrayList<Employee>();

    employeeAlphabeticalList.addAll(employees);

    employeeAlphabeticalList.sort(
        (f1, f2) -> f1.getName().compareTo(f2.getName())
    );

    return employeeAlphabeticalList;
  }
}

package lists;

import entities.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeFunctionList {
  private Map<String, List<Employee>> list = new HashMap<String, List<Employee>>();

  public EmployeeFunctionList(EmployeeList employeeList) {
    this.list = getEmployeesFunction(employeeList.getList());
  }

  public Map<String, List<Employee>> getList() {
    return list;
  }

  private Map<String, List<Employee>> getEmployeesFunction(List<Employee> employees) {
    new HashMap<String, List<Employee>>();

    for (Employee employee : employees) {
      String function = employee.getFunction();

      if (list.containsKey(function)) {
        list.get(function).add(employee);

        continue;
      }

      List<Employee> employeesFunctionTemp = new ArrayList<Employee>();
      employeesFunctionTemp.add(employee);

      list.put(function, employeesFunctionTemp);
    }

    return list;
  }
}

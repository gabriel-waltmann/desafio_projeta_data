package logs;

import lists.EmployeeList;
import lists.EmployeeMinimumWageList;

import java.util.Map;

public class EmployeeListMinimumWageLog {
  private Object[][] getEmployeeMinimumWageTable(Map<String, String> list) { // name, salary
    int totalRows = list.size() + 1;

    Object[][] table = new String[totalRows][];

    table[0] = new String[]{"Nome", "Salarios Minimos"};

    for (int i = 0; i < list.size(); i++) {
      String name = list.keySet().toArray()[i].toString();
      String salary = list.get(name);

      table[i + 1] = new String[]{ name, salary };
    }

    return table;
  }

  public EmployeeListMinimumWageLog(EmployeeMinimumWageList employeeMinimumWageList) {
    System.out.println("Total de salários minimos por funcionário: ");

    Object[][] table = getEmployeeMinimumWageTable(employeeMinimumWageList.getList());

    for (final Object[] row : table) {
      System.out.format("%-25s%-25s%n", row);
    }
  }
}

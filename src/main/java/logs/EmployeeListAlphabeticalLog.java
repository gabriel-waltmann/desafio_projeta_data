package logs;

import entities.Employee;
import lists.EmployeeAlphabeticalList;
import utils.CurrencyUtil;
import utils.DateUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class EmployeeListAlphabeticalLog {
  CurrencyUtil currencyUtil = new CurrencyUtil();

  DateUtil dateUtil = new DateUtil();

  private Object[][] getEmployeeTable(List<Employee> employees) {
    int rowsLength = employees.size() + 1;

    final Object[][] table = new String[rowsLength][];

    String[] header = new String[]{"Nome", "Data de Nascimento", "Salario", "Funcao"};
    table[0] = header;

    for (int i = 0; i < employees.size(); i++) {
      String name = employees.get(i).getName();

      LocalDate birthDate = employees.get(i).getBirthDate();
      String birthDateFormatted = dateUtil.format(birthDate, "d/MM/uuuu");

      BigDecimal salary = employees.get(i).getSalary();
      String salaryFormatted = currencyUtil.format(salary);

      String function = employees.get(i).getFunction();

      table[i + 1] = new String[]{ name, birthDateFormatted, salaryFormatted, function };
    }

    return table;
  }

  public EmployeeListAlphabeticalLog(EmployeeAlphabeticalList employeeAlphabeticalList) {
    System.out.println("Funcionários em ordem alfabética: ");

    Object[][] table = getEmployeeTable(employeeAlphabeticalList.getList());

    for (final Object[] row : table) {
      System.out.format("%-25s%-25s%-25s%-25s%n", row);
    }
  }
}

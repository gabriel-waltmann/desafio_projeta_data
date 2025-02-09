package logs;

import entities.Employee;
import lists.EmployeeBirthList;
import utils.CurrencyUtil;
import utils.DateUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class EmployeeListBirthLog {
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

  private String getBirthMonths(List<Integer> birthMonths) {
    String months = "";

    for (int i = 0; i < birthMonths.size(); i++) {
      if (i == birthMonths.size() - 1) {
        months = months + birthMonths.get(i);
        continue;
      }

      months = months + birthMonths.get(i) + ", ";
    }

    return months;
  }

  public EmployeeListBirthLog(EmployeeBirthList employeeBirthList) {
    String birthMonths = getBirthMonths(employeeBirthList.getBirthMonths());
    System.out.println("Funcionarios que fazem aniversário no mês de " + birthMonths);

    Object[][] table = getEmployeeTable(employeeBirthList.getList());

    for (final Object[] row : table) {
      System.out.format("%-25s%-25s%-25s%-25s%n", row);
    }
  }
}

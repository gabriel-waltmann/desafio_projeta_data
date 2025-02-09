package lists;

import entities.Employee;
import utils.CurrencyUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class EmployeeList {
  CurrencyUtil currencyUtil = new CurrencyUtil();

  final private List<Employee> list = new ArrayList<Employee>();

  public void addEmployee (String name, String birthDate, String salary, String function) {
    int dia = Integer.parseInt(birthDate.substring(0, 2));
    int mes = Integer.parseInt(birthDate.substring(3, 5));
    int ano = Integer.parseInt(birthDate.substring(6, 10));

    LocalDate dataNascimentoFormatada = LocalDate.of(ano, mes, dia);

    Employee employee = new Employee(
        name,
        dataNascimentoFormatada,
        new BigDecimal(salary),
        function
    );

    list.add(employee);
  }

  public void removeEmployeeByName(String name) {
    for (int i = 0; i < list.size(); i++) {
      String employeeName = list.get(i).getName();

      if (employeeName.equals(name)) {
        list.remove(i);
        break;
      }
    }
  }

  public List<Employee> getList() {
    return list;
  }

  public void incrementSalary(float percentage) {
    for (Employee employee : list) {
      employee.incrementSalary(percentage);
    }
  }

  public Employee getEmployeeWithBiggestAge() {
    Employee employeeWithBiggestAge = null;

    for (Employee employee : list) {
      int age = employee.getAge();

      boolean isEmployeeWithBiggestAge = employeeWithBiggestAge == null || age > employeeWithBiggestAge.getAge();
      if (isEmployeeWithBiggestAge) {
        employeeWithBiggestAge = employee;
      }
    }

    return employeeWithBiggestAge;
  }

  public String getTotalSalary() {
    BigDecimal totalSalary = BigDecimal.ZERO;

    for (Employee employee : list) {
      totalSalary = totalSalary.add(employee.getSalary());
    }

    return currencyUtil.format(totalSalary);
  }
}
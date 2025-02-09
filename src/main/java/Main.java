import entities.Employee;
import lists.*;
import logs.*;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    EmployeeList employeeList = getEmployeeList();

    employeeList.removeEmployeeByName("João");

    new EmployeeListLog(employeeList);

    System.out.println("\n");

    employeeList.incrementSalary(0.1f);

    EmployeeFunctionList employeeFunctionList = new EmployeeFunctionList(employeeList);

    new EmployeeListFunctionLog(employeeFunctionList);

    System.out.println("\n");

    List<Integer> birthMonths = List.of(10, 12);

    EmployeeBirthList employeeBirthList = new EmployeeBirthList(employeeList, birthMonths);

    new EmployeeListBirthLog(employeeBirthList);

    System.out.println("\n");

    Employee employee = employeeList.getEmployeeWithBiggestAge();
    new EmployBirthLog(employee);

    System.out.println("\n");

    EmployeeAlphabeticalList employeeAlphabeticalList = new EmployeeAlphabeticalList(employeeList);
    new EmployeeListAlphabeticalLog(employeeAlphabeticalList);

    System.out.println("\n");

    new EmployeeTotalSalaryLog(employeeList);

    System.out.println("\n");

    EmployeeMinimumWageList employeeMinimumWageList = new EmployeeMinimumWageList(employeeList);
    new EmployeeListMinimumWageLog(employeeMinimumWageList);
  }

  private static EmployeeList getEmployeeList() {
    EmployeeList employeeList = new EmployeeList();

    employeeList.addEmployee("Maria", "18/10/2000", "2009.44", "Operador");
    employeeList.addEmployee("João", "12/05/1990", "2284.38", "Operador");
    employeeList.addEmployee("Caio", "02/05/1961", "9836.14", "Coordenador");
    employeeList.addEmployee("Miguel", "14/10/1988", "19119.88", "Diretor");
    employeeList.addEmployee("Alice", "05/01/1995", "2234.68", "Recepcionista");
    employeeList.addEmployee("Heitor", "19/11/1999", "1582.72", "Operador");
    employeeList.addEmployee("Arthur", "31/03/1993", "4071.84", "Contador");
    employeeList.addEmployee("Laura", "08/07/1994", "3017.45", "Gerente");
    employeeList.addEmployee("Heloísa", "24/05/2003", "1606.85", "Eletricista");
    employeeList.addEmployee("Helena", "02/09/1996", "2799.93", "Gerente");

    return employeeList;
  }

}

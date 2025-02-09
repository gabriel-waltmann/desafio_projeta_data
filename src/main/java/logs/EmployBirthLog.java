package logs;

import entities.Employee;

public class EmployBirthLog {
  public EmployBirthLog(Employee employee) {
    System.out.println("Funcionário com maior idade: ");
    System.out.println("nome: " + employee.getName());
    System.out.println("Idade: " + employee.getAge());
  }
}

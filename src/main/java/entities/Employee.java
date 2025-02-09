package entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee extends Person {
  BigDecimal salary;
  String function;

  public Employee(String nome, LocalDate dataNascimento, BigDecimal salary, String function) {
    super(nome, dataNascimento);

    this.salary = salary;
    this.function = function;
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public void setSalary(BigDecimal salario) {
    this.salary = salario;
  }

  public String getFunction() {
    return function;
  }

  public void setFunction(String function) {
    this.function = function;
  }

  public void incrementSalary(float porcentagem) {
    float valorAumento = (salary.floatValue() * porcentagem) / 100;

    salary = salary.add(BigDecimal.valueOf(valorAumento));
  }

  public int getAge() {
    LocalDate dataAtual = LocalDate.now();

    return dataAtual.getYear() - this.getBirthDate().getYear();
  }
}

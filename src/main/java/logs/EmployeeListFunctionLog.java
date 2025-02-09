package logs;

import entities.Employee;
import lists.EmployeeFunctionList;

import java.util.List;
import java.util.Map;

public class EmployeeListFunctionLog {
  public EmployeeListFunctionLog(EmployeeFunctionList employeeFunctionList) {
    System.out.println("Funcionarios por função: ");

    Object[][] table = getEmployeeFunctionTable(employeeFunctionList.getList());

    for (final Object[] row : table) {
      System.out.format("%-25s%-25s%n", row);
    }
  }

  public Object[][] getEmployeeFunctionTable(Map<String, List<Employee>> list) {
    int totalLinhas = list.size() + 1;
    final Object[][] table = new String[totalLinhas][];
    table[0] = new String[]{"Função", "Funcionarios"};

    for (int funcaoIndex = 0; funcaoIndex < list.size(); funcaoIndex++) {
      String funcao = list.keySet().toArray()[funcaoIndex].toString();
      List<Employee> employees = list.get(funcao);

      String funcionariosNomes = "";

      for (int funcionarioIndex = 0; funcionarioIndex < employees.size(); funcionarioIndex++) {
        String nome = employees.get(funcionarioIndex).getName();

        if (funcionarioIndex == 0) {
          funcionariosNomes = nome;

          continue;
        }

        funcionariosNomes = funcionariosNomes + ", " + nome;
      }

      table[funcaoIndex + 1] = new String[]{ funcao, funcionariosNomes };
    }

    return table;
  }
}

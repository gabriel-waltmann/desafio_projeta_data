import java.math.BigDecimal;
import java.util.List;

public class Principal {
  public static void main(String[] args) {
    FuncionarioLista funcionarioLista = new FuncionarioLista();

    funcionarioLista.incluirFuncionario("Maria", "18/10/2000", "2009.44", "Operador");
    funcionarioLista.incluirFuncionario("João", "12/05/1990", "2284.38", "Operador");
    funcionarioLista.incluirFuncionario("Caio", "02/05/1961", "9836.14", "Coordenador");
    funcionarioLista.incluirFuncionario("Miguel", "14/10/1988", "19119.88", "Diretor");
    funcionarioLista.incluirFuncionario("Alice", "05/01/1995", "2234.68", "Recepcionista");
    funcionarioLista.incluirFuncionario("Heitor", "19/11/1999", "1582.72", "Operador");
    funcionarioLista.incluirFuncionario("Arthur", "31/03/1993", "4071.84", "Contador");
    funcionarioLista.incluirFuncionario("Laura", "08/07/1994", "3017.45", "Gerente");
    funcionarioLista.incluirFuncionario("Heloísa", "24/05/2003", "1606.85", "Eletricista");
    funcionarioLista.incluirFuncionario("Helena", "02/09/1996", "2799.93", "Gerente");

    funcionarioLista.removerFuncionarioPorNome("João");

//    3.3
    funcionarioLista.imprimirFuncionarios();

    System.out.println("\n");

//    3.4
    funcionarioLista.incrementarSalarioParaTodosFuncionarios(0.1f);

//    3.5
    funcionarioLista.ordenarFuncionariosPorFuncao();

//    3.6
    funcionarioLista.imprimirFuncionariosPorFuncao();

    System.out.println("\n");

//    3.8
    funcionarioLista.imprimirFuncionariosPorAniversario(List.of(10, 12));

    System.out.println("\n");

//    3.9
    funcionarioLista.imprimirMaiorIdade();

    System.out.println("\n");

//    3.10
    funcionarioLista.imprimirFuncionariosPorOrdemAlfabetica();

    System.out.println("\n");

//    3.11
    funcionarioLista.imprimirSalarioTotal();

    System.out.println("\n");

//    3.12
    funcionarioLista.calcularTotalDeSalariosMinimosPorFuncionario(new BigDecimal("1212.00"));

    funcionarioLista.imprimirFuncionariosPorSalariosMinimos();

    System.out.println("\n");

  }
}

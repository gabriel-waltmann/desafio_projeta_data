import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FuncionarioLista {
  private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

  private Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<String, List<Funcionario>>();

  private Map<String, BigDecimal> totalDeSalariosMinimosPorFuncionario = new HashMap<String, BigDecimal>();

  public void incluirFuncionario (String nome, String dataNascimento, String salario, String funcao) {
    int dia = Integer.parseInt(dataNascimento.substring(0, 2));
    int mes = Integer.parseInt(dataNascimento.substring(3, 5));
    int ano = Integer.parseInt(dataNascimento.substring(6, 10));

    LocalDate dataNascimentoFormatada = LocalDate.of(ano, mes, dia);

    Funcionario funcionario = new Funcionario(
        nome,
        dataNascimentoFormatada,
        new BigDecimal(salario),
        funcao
    );

    funcionarios.add(funcionario);
  }

  public void removerFuncionarioPorNome(String nome) {
    for (int i = 0; i < funcionarios.size(); i++) {
      String nomeFuncionario = funcionarios.get(i).getNome();

      if (nomeFuncionario.equals(nome)) {
        funcionarios.remove(i);
        break;
      }
    }
  }

  void ordenarFuncionariosPorFuncao() {
    funcionariosPorFuncao = new HashMap<String, List<Funcionario>>();

    for (Funcionario funcionario : funcionarios) {
      String funcao = funcionario.getFuncao();

      if (funcionariosPorFuncao.containsKey(funcao)) {
        funcionariosPorFuncao.get(funcao).add(funcionario);

        continue;
      }

      List<Funcionario> funcionariosPorFuncaoTemp = new ArrayList<Funcionario>();
      funcionariosPorFuncaoTemp.add(funcionario);

      funcionariosPorFuncao.put(funcao, funcionariosPorFuncaoTemp);
    }
  }

  void imprimirFuncionariosPorFuncao() {
    int totalLinhas = funcionariosPorFuncao.size() + 1;
    final Object[][] tabela = new String[totalLinhas][];
    tabela[0] = new String[]{"Função", "Funcionarios"};

    for (int funcaoIndex = 0; funcaoIndex < funcionariosPorFuncao.size(); funcaoIndex++) {
      String funcao = funcionariosPorFuncao.keySet().toArray()[funcaoIndex].toString();
      List<Funcionario> funcionarios = funcionariosPorFuncao.get(funcao);

      String funcionariosNomes = "";

      for (int funcionarioIndex = 0; funcionarioIndex < funcionarios.size(); funcionarioIndex++) {
        String nome = funcionarios.get(funcionarioIndex).getNome();

        if (funcionarioIndex == 0) {
          funcionariosNomes = nome;

          continue;
        }

        funcionariosNomes = funcionariosNomes + ", " + nome;
      }

      tabela[funcaoIndex + 1] = new String[]{ funcao, funcionariosNomes };
    }

    for (final Object[] linha : tabela) {
      System.out.format("%-25s%-25s%n", linha);
    }
  }

  public void imprimirFuncionarios() {
    int totalLinhas = funcionarios.size() + 1;
    final Object[][] tabela = new String[totalLinhas][];

    tabela[0] = new String[]{"Nome", "Data de Nascimento", "Salario", "Funcao"};

    for (int i = 0; i < funcionarios.size(); i++) {
      String nome = funcionarios.get(i).getNome();

      LocalDate dataNascimento = funcionarios.get(i).getDataNascimento();
      DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
      String dataNascimentoFormatado = dataNascimento.format(formatters);

      BigDecimal salario = funcionarios.get(i).getSalario();
      DecimalFormat df = new DecimalFormat("#,##0.00");
      // formatar com separador de milhar
      df.setGroupingUsed(true);
      // formar com , em vez de .
      df.setDecimalFormatSymbols(new DecimalFormatSymbols(new Locale("pt", "BR")));
      String salarioFormatado = df.format(salario);

      String funcao = funcionarios.get(i).getFuncao();

      tabela[i + 1] = new String[]{ nome, dataNascimentoFormatado, salarioFormatado, funcao };
    }

    for (final Object[] linha : tabela) {
      System.out.format("%-25s%-25s%-25s%-25s%n", linha);
    }
  }

  void calcularTotalDeSalariosMinimosPorFuncionario(BigDecimal salarioMinimo) {
    totalDeSalariosMinimosPorFuncionario = new HashMap<String, BigDecimal>();

    for (Funcionario funcionario : funcionarios) {
      BigDecimal salario = funcionario.getSalario();
      BigDecimal totalSalariosMinimos = salario.divide(salarioMinimo, 2, RoundingMode.HALF_UP);

      totalDeSalariosMinimosPorFuncionario.put(funcionario.getNome(), totalSalariosMinimos);
    }
  }

  void imprimirFuncionariosPorSalariosMinimos() {
    int totalLinhas = totalDeSalariosMinimosPorFuncionario.size() + 1;
    final Object[][] tabela = new String[totalLinhas][];
    tabela[0] = new String[]{"Funcionario", "Total de Salarios Minimos"};

    for (int funcionarioIndex = 0; funcionarioIndex < funcionarios.size(); funcionarioIndex++) {
      String nome = funcionarios.get(funcionarioIndex).getNome();
      String totalSalariosMinimos = totalDeSalariosMinimosPorFuncionario.get(nome).toString();

      tabela[funcionarioIndex + 1] = new String[]{ nome, totalSalariosMinimos };
    }

    for (final Object[] linha : tabela) {
      System.out.format("%-25s%-25s%n", linha);
    }
  }

  public void imprimirFuncionariosPorAniversario(List<Integer> meses) {
    List<Funcionario> funcionariosAniversariantes = new ArrayList<Funcionario>();

    for (Funcionario funcionario : funcionarios) {
      int mes = funcionario.getDataNascimento().getMonthValue();

      if (meses.contains(mes)) {
        funcionariosAniversariantes.add(funcionario);
      }
    }

    int totalLinhas = funcionariosAniversariantes.size() + 1;
    final Object[][] tabela = new String[totalLinhas][];
    tabela[0] = new String[]{"Nome", "Data de Nascimento", "Salario", "Funcao"};

    for (int i = 0; i < funcionariosAniversariantes.size(); i++) {
      String nome = funcionariosAniversariantes.get(i).getNome();

      LocalDate dataNascimento = funcionariosAniversariantes.get(i).getDataNascimento();
      DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
      String dataNascimentoFormatado = dataNascimento.format(formatters);

      BigDecimal salario = funcionariosAniversariantes.get(i).getSalario();
      DecimalFormat df = new DecimalFormat("#,##0.00");
      // formatar com separador de milhar
      df.setGroupingUsed(true);
      // formar com , em vez de .
      df.setDecimalFormatSymbols(new DecimalFormatSymbols(new Locale("pt", "BR")));
      String salarioFormatado = df.format(salario);

      String funcao = funcionariosAniversariantes.get(i).getFuncao();

      tabela[i + 1] = new String[]{ nome, dataNascimentoFormatado, salarioFormatado, funcao };
    }

    for (final Object[] linha : tabela) {
      System.out.format("%-25s%-25s%-25s%-25s%n", linha);
    }
  }

  public void imprimirFuncionariosPorOrdemAlfabetica() {
    List<Funcionario> funcionariosOrdenados = new ArrayList<Funcionario>(funcionarios);
    funcionariosOrdenados.sort((f1, f2) -> f1.getNome().compareTo(f2.getNome()));

    int totalLinhas = funcionarios.size() + 1;
    final Object[][] tabela = new String[totalLinhas][];

    tabela[0] = new String[]{"Nome", "Data de Nascimento", "Salario", "Funcao"};

    for (int i = 0; i < funcionariosOrdenados.size(); i++) {
      String nome = funcionariosOrdenados.get(i).getNome();

      LocalDate dataNascimento = funcionariosOrdenados.get(i).getDataNascimento();
      DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
      String dataNascimentoFormatado = dataNascimento.format(formatters);

      BigDecimal salario = funcionariosOrdenados.get(i).getSalario();
      DecimalFormat df = new DecimalFormat("#,##0.00");
      // formatar com separador de milhar
      df.setGroupingUsed(true);
      // formar com , em vez de .
      df.setDecimalFormatSymbols(new DecimalFormatSymbols(new Locale("pt", "BR")));
      String salarioFormatado = df.format(salario);

      String funcao = funcionariosOrdenados.get(i).getFuncao();

      tabela[i + 1] = new String[]{ nome, dataNascimentoFormatado, salarioFormatado, funcao };
    }

    for (final Object[] linha : tabela) {
      System.out.format("%-25s%-25s%-25s%-25s%n", linha);
    }
  }

  void imprimirSalarioTotal() {
    BigDecimal salarioTotal = BigDecimal.ZERO;

    for (Funcionario funcionario : funcionarios) {
      salarioTotal = salarioTotal.add(funcionario.getSalario());
    }

    DecimalFormat df = new DecimalFormat("#,##0.00");
    // formatar com separador de milhar
    df.setGroupingUsed(true);
    // formar com , em vez de .
    df.setDecimalFormatSymbols(new DecimalFormatSymbols(new Locale("pt", "BR")));
    String salarioTotalFormatado = df.format(salarioTotal.setScale(2, RoundingMode.HALF_UP));

    System.out.println("Total dos salarios de todos os funcionarios: " + salarioTotalFormatado);
  }

  void incrementarSalarioParaTodosFuncionarios(float porcentagem) {
    for (Funcionario funcionario : funcionarios) {
      funcionario.incrementarSalario(porcentagem);
    }
  }

  public void imprimirMaiorIdade() {
    Funcionario funcionarioMaiorIdade = null;
    LocalDate dataAtual = LocalDate.now();

    for (Funcionario funcionario : funcionarios) {
      int idade = dataAtual.getYear() - funcionario.getDataNascimento().getYear();

      if (funcionarioMaiorIdade == null || idade > funcionarioMaiorIdade.getDataNascimento().getYear()) {
        funcionarioMaiorIdade = funcionario;
      }
    }

    int idade = dataAtual.getYear() - funcionarioMaiorIdade.getDataNascimento().getYear();
    System.out.println();
    System.out.println("Funcionario com maior idade: ");
    System.out.println("nome: " + funcionarioMaiorIdade.getNome());
    System.out.println("Idade: " + idade);
  }
}
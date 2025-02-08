import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa {
  BigDecimal salario;
  String funcao;

  public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
    super(nome, dataNascimento);

    this.salario = salario;
    this.funcao = funcao;
  }

  public BigDecimal getSalario() {
    return salario;
  }

  public void setSalario(BigDecimal salario) {
    this.salario = salario;
  }

  public String getFuncao() {
    return funcao;
  }

  public void setFuncao(String funcao) {
    this.funcao = funcao;
  }

  public void incrementarSalario(float porcentagem) {
    float valorAumento = (salario.floatValue() * porcentagem) / 100;

    salario = salario.add(BigDecimal.valueOf(valorAumento));
  }
}

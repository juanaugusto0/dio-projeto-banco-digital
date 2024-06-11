public class Conta {

    private String nome;
    private int id;
    private double saldo;

    public Conta(String nome, Banco banco) {
        this.nome = nome;
        this.id = banco.getContas().size() + 1;
        banco.adicionarConta(this);
    }

    @Override
    public String toString() {
        return "Contas: (nome=" + nome + ", id=" + id + ", saldo=" + saldo + ")";
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente");
        } else {
            saldo -= valor;
        }
    }

    public void transferir(Conta destino, double valor) {
        if (destino == null) {
            System.out.println("Conta inexistente");
        }
        if (valor > saldo) {
            System.out.println("Saldo insuficiente");
        }else {
            sacar(valor);
            destino.depositar(valor);
        }
    }

}

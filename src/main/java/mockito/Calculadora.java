package mockito;

public class Calculadora {

    private ServicoMatematico sm;

    public Calculadora(ServicoMatematico sm) {
        this.sm = sm;
    }

    public int soma(int a, int b) {
        return sm.somar(a, b);
    }
}

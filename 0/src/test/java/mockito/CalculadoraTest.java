package mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CalculadoraTest {

    @Mock
    private ServicoMatematico sm = mock(ServicoMatematico.class);

    public CalculadoraTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveRetonarCinco() {
        when(sm.somar(2,3)).thenReturn(5);
        Calculadora calc = new Calculadora(sm);
        var result = calc.soma(2, 3);
        assertEquals(5, result);
        verify(sm).somar(2,3);
    }
}

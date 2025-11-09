package mockito;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class BancoServiceTest {

    @Mock
    ContaRepository contaRepository;

    public BancoServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConsultarSaldo() {
        Conta conta = new Conta("8081", 567);
        when(contaRepository.buscarConta(any())).thenReturn(conta);

        BancoService service = new BancoService(contaRepository);
        double saldo = service.consultarSaldo("8081");
        assertEquals(567, saldo);

        verify(contaRepository).buscarConta("8081");
    }


    @Test
    public void testDepositar() {
        Conta conta = new Conta("8081", 500 );
        when(contaRepository.buscarConta(any())).thenReturn(conta);

        BancoService service = new BancoService(contaRepository);
        service.depositar("8081", 500);

        assertEquals(1000, conta.getSaldo());

        verify(contaRepository).buscarConta("8081");
        verify(contaRepository).salvar(conta);
        verifyNoMoreInteractions(contaRepository);
    }
}

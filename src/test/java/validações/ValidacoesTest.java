package validações;

import org.junit.Assert;
import org.junit.Test;

public class ValidacoesTest {

    @Test
    public void testaHorarioValido(){
        Assert.assertTrue(ValidaHoraAtividade.ValidaHoraAtiviade("15:00"));
    }
    @Test
    public void testaHorarioInvalido(){
        Assert.assertFalse(ValidaHoraAtividade.ValidaHoraAtiviade("15:00:00"));
    }
    @Test
    public void testaUsuarioValido(){
        Assert.assertTrue(ValidaNomeUser.validaNomeUser("Douglas_vargas"));
    }
    @Test
    public void testaUsuarioInvalido(){
        Assert.assertFalse(ValidaNomeUser.validaNomeUser("Douglas%@!%!%@"));
    }

}

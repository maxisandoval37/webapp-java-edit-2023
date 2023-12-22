package dev.maxisandoval37.webappjavaedit2023;

import dev.maxisandoval37.webappjavaedit2023.model.Duenio;
import dev.maxisandoval37.webappjavaedit2023.service.DuenioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DuenioServiceTest {

    @Autowired
    private DuenioService duenioService;

    @Test
    public void testGuardarDuenio() {
        Duenio duenio = new Duenio();
        duenio.setNombre("pepe");
        duenio.setDireccion("arg");

        Duenio duenioGuardado = duenioService.guardarDuenio(duenio);

        assertNotNull(duenioGuardado.getId());
        assertEquals("pepe",duenioGuardado.getNombre());
        assertEquals("arg", duenioGuardado.getDireccion());
    }

    @Test
    public void testListarDuenios() {
        List<Duenio> duenios = duenioService.listarDuenios();
        assertTrue(duenios.size() > 0);
    }

    @Test
    public void testObtenerDuenioPorId(){
        Long duenioId = 1L;
        Duenio duenio = duenioService.obtenerDuenioPorId(duenioId);

        assertNotNull(duenio);
        assertEquals(duenioId, duenio.getId());
    }

}

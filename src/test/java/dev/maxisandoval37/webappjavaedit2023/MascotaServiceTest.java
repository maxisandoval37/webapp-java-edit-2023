package dev.maxisandoval37.webappjavaedit2023;

import dev.maxisandoval37.webappjavaedit2023.model.Duenio;
import dev.maxisandoval37.webappjavaedit2023.model.Mascota;
import dev.maxisandoval37.webappjavaedit2023.service.DuenioService;
import dev.maxisandoval37.webappjavaedit2023.service.MascotaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MascotaServiceTest {

    @Autowired
    private DuenioService duenioService;

    @Autowired
    private MascotaService mascotaService;

    @Test
    public void testGuardarMascota(){
        Duenio duenio = new Duenio();
        duenio.setNombre("pepe");
        duenio.setDireccion("arg");

        Duenio duenioGuardado = duenioService.guardarDuenio(duenio);

        Mascota mascota = new Mascota();
        mascota.setNombre("fatiga");
        mascota.setEspecie("perro");
        mascota.setEdad(3);
        //mascota.setDuenio(duenioGuardado);

        Mascota mascotaGuardada = mascotaService.guardarMascota(mascota, duenioGuardado.getId());

        assertNotNull(mascotaGuardada.getId());
        assertEquals("fatiga", mascotaGuardada.getNombre());
        assertEquals("perro", mascotaGuardada.getEspecie());
        assertEquals(3, mascotaGuardada.getEdad());
        assertEquals(duenioGuardado.getId(), mascota.getDuenio().getId());
    }

    @Test
    public void testListarMascotas() {
        List<Mascota> mascotas = mascotaService.listarMascotas();
        assertTrue(mascotas.size() > 0);
    }

    @Test
    public void testObtenerMascotaPorId() {
        Long mascotaId = 1L;
        Mascota mascota = mascotaService.obtenerMascotaPorId(mascotaId);

        assertNotNull(mascota);
        assertEquals(mascotaId, mascota.getId());
    }

    @Test
    public void testActualizarMascota() {
        Long mascotaId = 1L;

        Duenio duenio = new Duenio();
        duenio.setNombre("chester");
        duenio.setDireccion("arg");

        Duenio duenioGuardado = duenioService.guardarDuenio(duenio);

        Mascota mascotaActualizada = new Mascota();
        mascotaActualizada.setNombre("firulais");
        mascotaActualizada.setEspecie("perro");
        mascotaActualizada.setEdad(1);
        mascotaActualizada.setDuenio(duenioGuardado);

        mascotaService.actualizarMascota(mascotaId, mascotaActualizada);

        Mascota mascotaDespuesDeActualizar = mascotaService.obtenerMascotaPorId(mascotaId);

        assertEquals(mascotaActualizada.getNombre(), mascotaDespuesDeActualizar.getNombre());
        assertEquals(mascotaActualizada.getEspecie(), mascotaDespuesDeActualizar.getEspecie());
        assertEquals(mascotaActualizada.getEdad(), mascotaDespuesDeActualizar.getEdad());
        assertEquals(mascotaActualizada.getDuenio(), mascotaDespuesDeActualizar.getDuenio());
    }

    @Test
    public void testEliminarMascota() {
        Long mascotaId = 3L;
        mascotaService.eliminarMascota(mascotaId);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            mascotaService.obtenerMascotaPorId(mascotaId);
        });

        String expectedMessage = "No se encontro la mascota";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


public class PersonaTest {

    @Test
    void crearPersona(){

        LocalDate fechaNacimiento = LocalDate.of(2003, 1, 15);
        Persona persona = Persona.create("Matias", "Villafañe", 22, fechaNacimiento);

        assertEquals("Villafañe", persona.getApellido());

    }

    @Test
    void crearPersonaConNombreInvalido() {
        LocalDate fechaNacimiento = LocalDate.of(2003, 1, 15);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Persona.create("", "Villafañe", 22, fechaNacimiento);
        });
        assertEquals("El nombre no puede estar vacío", exception.getMessage());

    }

    @Test
    void crearPersonaConApellidoInvalido() {
        LocalDate fechaNacimiento = LocalDate.of(2003, 1, 15);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Persona.create("Matias", "", 22, fechaNacimiento);
        });
        assertEquals("El apellido no puede estar vacío", exception.getMessage());
    }

    @Test
    void crearPersonaConEdadInvalida() {
        LocalDate fechaNacimiento = LocalDate.of(2003, 1, 15);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Persona.create("Matias", "Villafañe", -1, fechaNacimiento);
        });
        assertEquals("La edad no puede ser negativa", exception.getMessage());
    }

    @Test
    void crearPersonaConFechaNula() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Persona.create("Matias", "Villafañe", 22, null);
        });
        assertEquals("La fecha de nacimiento es obligatoria", exception.getMessage());
     }


}

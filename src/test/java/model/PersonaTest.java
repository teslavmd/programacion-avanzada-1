package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PersonaTest {

    @Test
    void crearPersona(){

        LocalDate fechaNacimiento = LocalDate.of(2003, 1, 15);
        Persona persona = Persona.create("Matias", "Villafañe", 22, fechaNacimiento);

        assertEquals("Villafañe", persona.getApellido());

    }

}

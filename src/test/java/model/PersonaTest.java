package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PersonaTest {

    @Test
    void crearPersona(){

        LocalDate fechaNacimiento = LocalDate.of(2003, 1, 15);
        Persona persona = Persona.create("Matias", "Villafañe", 22, fechaNacimiento);

        assertEquals("Villafañe", persona.getApellido());

    }

    @Test
    void crearPersonaConNombrEInvalido(){
        boolean invalido = false;
        try {
            LocalDate fechaNacimiento = LocalDate.of(2003,1,15);
            Persona persona = Persona.create("", "Villafañe", 22, fechaNacimiento);

        }catch (IllegalArgumentException e){
            invalido = true;
            assertEquals("El nombre no puede estar vacío", e.getMessage());
        }
        assertTrue(invalido, "se espera una exception");
    }

    @Test
    void crearPersonaConApellidoInvalido(){
        boolean invalido = false;
        try {
            LocalDate fechaNacimiento = LocalDate.of(2003,1,15);
            Persona persona = Persona.create("Matias", "", 22, fechaNacimiento);

        }catch (IllegalArgumentException e){
            invalido = true;
            assertEquals("El apellido no puede estar vacío", e.getMessage());
        }
        assertTrue(invalido, "se espera una exception");
    }





    @Test
    void crearPersonaConEdadInvalida(){
        boolean invalido = false;
        try {
            LocalDate fechaNacimiento = LocalDate.of(2003,1,15);
            Persona persona = Persona.create("Matias", "Villafañe", -1, fechaNacimiento);

        }catch (IllegalArgumentException e){
            invalido = true;
            assertEquals("La edad no puede ser negativa", e.getMessage());
        }
        assertTrue(invalido, "se espera una exception");
    }

    @Test
    void crearPersonaConFEchaNula(){
        boolean fechaNull = false;
        try {
            LocalDate fechaNacimiento = null;
            Persona persona = Persona.create("Matias", "Villafañe", 22, fechaNacimiento);

        }catch (IllegalArgumentException e){
            fechaNull = true;
            assertEquals("La fecha de nacimiento es obligatoria", e.getMessage());
        }
        assertTrue(fechaNull, "se espera una exception");
    }


}

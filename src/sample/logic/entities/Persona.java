package sample.logic.entities;

import javafx.scene.control.TextField;
import sample.PersonaException;

import javax.swing.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Persona implements Serializable {//para que java pueda guardar objetos en archivos
    // necesita implementar la interfaz de serializable(input output) (voy a poder convertir la representacion
    // en memoria )como un objeto binario en un objeto serializable que se pueda escribir en algún
    // tipo de fuente en este caso en un archivo , base de dato

    //private UUID id;
    private String name;
    private String lastName;
    private String municipality;
    private String department;
    private String deathDate;


    public Persona(String name, String lastName, String municipality,String deathDate,String department) throws PersonaException {
        this.name = name;
        this.lastName = lastName;
        this.deathDate= deathDate;
        this.municipality = municipality;
        this.department = department;
        // this.id = UUID.randomUUID();
        //this.setAge(age);
    }


   /* public UUID getId() {
        return id;
    }

    */

    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public String getDeathDate() {
        return deathDate;
    }
    public String getMunicipality() {
        return municipality;
    }
    public String getDepartment() {
        return department;
    }

    public void setDeathDate(String deathDateInput) throws PersonaException {
        try {
            String deathDate = JOptionPane.showInputDialog(deathDateInput);

            /*if (deathDate > LocalDate.now()) throw new PersonaException(PersonaException.BAD_DETHDATE_LOWER);
            if (deathDate > 120) throw new PersonaException(PersonaException.BAD_DETHDATE_UPPER);


             */
            this.deathDate = deathDate;
        } catch (NumberFormatException er) {
            throw new PersonaException(PersonaException.BAD_AGE + " : " + er.getMessage());
        }


    }

    public String getAge() {
        return "The age is " + this.deathDate;
    }


    /*@Override
    public List<String> toListString() {
        List<String> result = new ArrayList<>();
        result.add(this.name);
        result.add(this.lastName);
        result.add(this.deathDate);
        result.add(this.municipality);
        result.add(this.department);
        return result;
    }

    @Override
    public String getHeader() {
        return "name,LastName,municipality,department,deathDate";
    }

     */
}
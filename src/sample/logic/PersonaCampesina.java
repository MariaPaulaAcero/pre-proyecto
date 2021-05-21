package sample.logic;

import javafx.collections.FXCollections;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonaCampesina implements IPersonaCampesina {
    private IpersonaPersistence personaPersistence;
    private IPersonaCampesina personaCampesina;
    //private Map<UUID, Persona> personas;
    //private ObservableList<Persona> personas;

    private IExport export;
    private List<Persona> personas;

    public PersonaCampesina() {
        this.personas = FXCollections.observableArrayList();
        try {
            this.personaPersistence = new PersonaPersistence();
            this.export = new Export();
            //this.personas.addAll(this.personaPersistence.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /* public PersonaCampesina(List<Persona>personasCampesinas) {
        this.personas = FXCollections.observableArrayList();
        try {
            personasCampesinas.add(new Persona("Edwin", "Antonio Indaburo", "Nechí","07/01/2021","Antoquia"));
            personasCampesinas.add(new Persona("Alfredo", "García", "Ituango","10/01/2021","Antoquia"));
            personasCampesinas.add(new Persona("Yordan Eduardo", "Guetio", "Corinto","02/02/2021","Cauca"));
            personasCampesinas.add(new Persona("Albeiro", "Hoyos", "Anorí","05/04/2021","Antoquia"));
            personasCampesinas.add(new Persona("Wilson", "Lopez", "Aguadas","28/04/2021","Caldas"));
            personasCampesinas.add(new Persona("Aldinever", "Cruz Guaraca","Aipe","09/05/2021","Huila"));
            personasCampesinas.add(new Persona("Edwin", "Antonio Indaburo", "Nechí","07/01/2021","Antoquia"));

        } catch (PersonaException e) {
            e.printStackTrace();
        }
    }


    */
    @Override
    public List<Persona> getAll() {
        return this.personas;
    }

    /*@Override
    public Persona getById(UUID id) {
        return null;
    }*/

    @Override
    public Persona insert(Persona persona) {
        personas.add(persona);
        return persona;
    }

    @Override
    public void delete(List<Persona> personasToDelete) {
        personasToDelete.forEach(this.personas::remove);
    }

    // método para importar y exportar
    @Override
    public void export() throws Exception {
        List<Exportable> e = new ArrayList<>();
        this.personas.stream().forEach(p -> e.add(p));
        this.export.export(e, Exportable.CSV);
    }
}

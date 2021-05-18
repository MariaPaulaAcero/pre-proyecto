package sample;

import javafx.collections.FXCollections;
import sample.logic.entities.Persona;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PersonaCampesina implements IPersonaCampesina {
    private IpersonaPersistence personaPersistence;
    //private Map<UUID, Persona> personas;
    //private ObservableList<Persona> personas;

    //private IExport export;
    private List<Persona> personas;

    public PersonaCampesina() {
        this.personas = FXCollections.observableArrayList();
        try {
            this.personaPersistence = new PersonaPersistence();
            //this.export = new Export();
            //this.personas.addAll(this.personaPersistence.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Persona> getAll() {
        return this.personas;
    }

    /*@Override
    public Persona getById(UUID id) {
        return null;
    }

     */

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
        /*List<Exportable> e = new ArrayList<>();
        this.personas.stream().forEach(p -> e.add(p));
        this.export.export(e, Exportable.CSV);

         */

    }

}

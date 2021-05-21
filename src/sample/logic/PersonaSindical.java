package sample.logic;

import javafx.collections.FXCollections;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonaSindical implements IPersonaSindical {
    private IpersonaPersistence personaPersistence;
    private IPersonaSindical personaSindical;
    //private Map<UUID, Persona> personas;
    //private ObservableList<Persona> personas;

    private IExport export;
    private List<Persona> personas;

    public PersonaSindical() {
        this.personas = FXCollections.observableArrayList();
        try {
            this.personaPersistence = new PersonaPersistence();
            this.export = new Export();
            //this.personas.addAll(this.personaPersistence.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Persona> getAll() {
        return this.personas;
    }

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

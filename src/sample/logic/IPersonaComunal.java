package sample.logic;

import java.util.List;

public interface IPersonaComunal {
    List<Persona> getAll();

    //Persona getById(UUID id);

    Persona insert(Persona persona);

    void delete(List<Persona> personas);

    void export() throws Exception;
}

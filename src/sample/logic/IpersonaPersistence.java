package sample.logic;

import java.io.IOException;
import java.util.List;

public interface IpersonaPersistence {
    void save(Persona persona) throws IOException;

    List<Persona> read() throws IOException, ClassNotFoundException;

    void export() throws IOException;

}

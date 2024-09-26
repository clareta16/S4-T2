package cat.itacademy.s04.t02.n01.repositori;

import cat.itacademy.s04.t02.n01.model.Fruita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoriFruita extends JpaRepository<Fruita, Integer> {
    //et permet fer operacions CRUD automàticament
}
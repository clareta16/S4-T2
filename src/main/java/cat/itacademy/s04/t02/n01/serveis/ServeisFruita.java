package cat.itacademy.s04.t02.n01.serveis;

import cat.itacademy.s04.t02.n01.model.Fruita;
import cat.itacademy.s04.t02.n01.repositori.RepositoriFruita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServeisFruita {

    @Autowired
    private RepositoriFruita fruitaRepositori;

    public Fruita addFruita(Fruita fruita) {
        return fruitaRepositori.save(fruita);
    }

    public Fruita updateFruita(Fruita fruita) {
        return fruitaRepositori.save(fruita);
    }

    public void deleteFruita(int id) {
        fruitaRepositori.deleteById(id);
    }

    public Fruita getFruitaById(int id) {
        return fruitaRepositori.findById(id).orElse(null);
    }

    public List<Fruita> getAllFruites() {
        return fruitaRepositori.findAll();
    }
}

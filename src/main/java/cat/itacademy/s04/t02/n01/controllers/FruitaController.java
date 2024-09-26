package cat.itacademy.s04.t02.n01.controllers;

import cat.itacademy.s04.t02.n01.model.Fruita;
import cat.itacademy.s04.t02.n01.serveis.ServeisFruita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruita")
public class FruitaController {

    @Autowired
    private ServeisFruita fruitaServeis;

    @PostMapping("/add") //Gestiona peticions HTTP de tipus POST per afegir una nova fruita
    public ResponseEntity<Fruita> addFruita(@RequestBody Fruita fruita) {

        try {
            Fruita novaFruita = fruitaServeis.addFruita(fruita);
            return new ResponseEntity<>(novaFruita, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}") //igual que PostMapping però per fer update d'una nova fruita
    public ResponseEntity<Fruita> updateFruita(@PathVariable("id") int id, @RequestBody Fruita fruita) {
// el pathVariable indica que el paràmetre id és igual que l'id indicat al cos de la petició http
        try {
            Fruita updateFruita = fruitaServeis.updateFruita(fruita);
            return new ResponseEntity<>(updateFruita, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }



    @DeleteMapping("/delete/{id}") //igual per delete
    public ResponseEntity<HttpStatus> deleteFruita(@PathVariable("id") int id) {
        try {
            fruitaServeis.deleteFruita(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruita> getOneFruita(@PathVariable("id") int id) {
        try {
            Fruita fruita = fruitaServeis.getFruitaById(id);
            return new ResponseEntity<>(fruita, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> getAllFruites() {
        try {
            List<Fruita> fruites = fruitaServeis.getAllFruites();
            if (fruites.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(fruites, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


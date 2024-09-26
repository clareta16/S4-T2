package cat.itacademy.s04.t02.n01.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fruita")
public class Fruita {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int kgQuantity;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKgQuantity() {
        return kgQuantity;
    }

    public void setKgQuantity(int kgQuantity) {
        this.kgQuantity = kgQuantity;
    }

}

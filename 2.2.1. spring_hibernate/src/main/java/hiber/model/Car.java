package hiber.model;

import javax.persistence.*;


@Entity
@Table(name = "car")
public class Car {

    @OneToOne
    private User user;

    public Car(){}

    public Car(String model, int series){
        this.model = model;
        this.series = series;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="model")
    String model;

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name="series")
    int series;

    public int getSeries() {
        return this.series;
    }

    public void setSeries(int series) {
        this.series = series;
    }


    @Override
    public String toString() {
        return "Car {" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }




}

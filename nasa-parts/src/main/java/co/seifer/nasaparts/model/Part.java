package co.seifer.nasaparts.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Part implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="part_sequence")
    @SequenceGenerator(name="part_sequence", sequenceName="part_sequence", allocationSize=100)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;
    @Column(name = "cuantity")
    private Double cuantity; // si falla la culpa es de mat! y cambiar a double
    private LocalDateTime last_date_updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Double getCuantity() {
        return cuantity;
    }

    public void setCuantity(Double cuantity) {
        this.cuantity = cuantity;
    }

    public LocalDateTime getLast_date_updated() {
        return last_date_updated;
    }

    public void setLast_date_updated(LocalDateTime last_date_updated) {
        this.last_date_updated = last_date_updated;
    }

    public Part(Long id, String name, Provider provider, Double cuantity, LocalDateTime last_date_updated) {
        this.id = id;
        this.name = name;
        this.provider = provider;
        this.cuantity = cuantity;
        this.last_date_updated = last_date_updated;
    }

    @Override
    public String toString() {
        return "Part [id=" + id + ", name=" + name + ", provider=" + provider + ", cuantity=" + cuantity
                + ", last_date_updated=" + last_date_updated + "]";
    }
    
}
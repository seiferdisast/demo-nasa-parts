package co.seifer.nasaparts.model;

import java.io.Serializable;
import org.hibernate.annotations.Table;

import jakarta.persistence.*;

@Entity
public class Provider implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="provider_sequence")
    @SequenceGenerator(name="provider_sequence", sequenceName="provider_sequence", allocationSize=100)
    private Long id;
    private String name;
    private Boolean enabled;
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
    public Boolean getEnabled() {
        return enabled;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    public Provider(Long id, String name, Boolean enabled) {
        this.id = id;
        this.name = name;
        this.enabled = enabled;
    }
    @Override
    public String toString() {
        return "Provider [id=" + id + ", name=" + name + ", enabled=" + enabled + "]";
    }
    
}
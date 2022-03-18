package mx.edu.utez.inventario_dulceria.rol.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mx.edu.utez.inventario_dulceria.user.model.User;

import javax.persistence.*;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;

    @OneToOne(mappedBy = "rol")
    @JsonIgnore
    private User user;

    public Rol() {
    }

    public Rol(String description, User user) {
        this.description = description;
        this.user = user;
    }

    public Rol(long id, String description, User user) {
        this.id = id;
        this.description = description;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

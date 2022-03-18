package mx.edu.utez.inventario_dulceria.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mx.edu.utez.inventario_dulceria.user.model.User;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int quantity;
    private String caducityDate;

    @ManyToMany
    @JoinTable(
            name = "user_products",
            joinColumns = @JoinColumn( name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @JsonIgnore
    private Set<User> users;

    public Product() {
    }

    public Product(String name, int quantity, String caducityDate, Set<User> users) {
        this.name = name;
        this.quantity = quantity;
        this.caducityDate = caducityDate;
        this.users = users;
    }

    public Product(long id, String name, int quantity, String caducityDate, Set<User> users) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.caducityDate = caducityDate;
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCaducityDate() {
        return caducityDate;
    }

    public void setCaducityDate(String caducityDate) {
        this.caducityDate = caducityDate;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}

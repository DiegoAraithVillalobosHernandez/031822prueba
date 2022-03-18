package mx.edu.utez.inventario_dulceria.user.model;

import mx.edu.utez.inventario_dulceria.product.model.Product;
import mx.edu.utez.inventario_dulceria.rol.model.Rol;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String phone;

    @OneToOne
    @JoinColumn(name = "rol_id", unique = true)
    private Rol rol;

    @ManyToMany(mappedBy = "users")
    private List<Product> products;

    public User() {
    }

    public User(String username, String password, String name, String surname, String phone, Rol rol) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.rol = rol;
        this.products = null;
    }

    public User(long id, String username, String password, String name, String surname, String phone, Rol rol) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.rol = rol;
        this.products = null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

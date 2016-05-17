package com.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
        @NamedQuery(name = "getProductsByName", query = "SELECT p from Product p WHERE p.type = :type order by p.name"),
        @NamedQuery(name = "getProductsByPriceDesc", query = "SELECT p from Product p WHERE p.type = :type order by p.price desc"),
        @NamedQuery(name = "getProductsByPriceAsc", query = "SELECT p from Product p WHERE p.type = :type order by p.price asc"),
        @NamedQuery(name = "getProductsByCompany", query = "SELECT p from Product p WHERE p.type = :type order by p.company"),

        @NamedQuery(name = "getTopProducts", query = "select p from Product p order by p.id desc "),
        @NamedQuery(name = "getProduct", query = "SELECT p from Product p WHERE p.id = :id"),

        @NamedQuery(name = "searchProductsByName", query = "SELECT p from Product p WHERE p.name like :name order by p.name"),
        @NamedQuery(name = "searchProductsByPriceDesc", query = "SELECT p from Product p WHERE p.name like :name order by p.price desc"),
        @NamedQuery(name = "searchProductsByPriceAsc", query = "SELECT p from Product p WHERE p.name like :name order by p.price asc"),
        @NamedQuery(name = "searchProductsByCompany", query = "SELECT p from Product p WHERE p.name like :name order by p.company"),

        @NamedQuery(name = "countProducts", query = "select count(p.id) from Product p where p.type = :type"),
        @NamedQuery(name = "countSearchProducts", query = "select count(p.id) from Product p where p.name like :name")

})
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_photo")
    private String photo;

    @Column(name = "product_price")
    private BigDecimal price;

    @Column(name = "product_model")
    private String model;

    @Column(name = "product_type")
    @Enumerated(EnumType.STRING)
    private ProductType type;

    @Column(name = "product_available")
    private boolean available;

    @Column(name = "product_size")
    private String size;

    @Column(name = "product_weight")
    private int weight;

    @Column(name = "product_storage")
    private int storage;

    @Column(name = "product_ram")
    private int ram;

    @Column(name = "product_screen")
    private float screen;

    @Column(name = "product_os")
    private String os;

    @Column(name = "product_color")
    private String color;

    @Column(name = "product_description")
    private String description;

    @Column(name = "product_processor")
    private String processor;

    @Column(name = "product_company")
    private String company;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public float getScreen() {
        return screen;
    }

    public void setScreen(float screen) {
        this.screen = screen;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (!name.equals(product.name)) return false;
        return model.equals(product.model);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + model.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", company='" + company + '\'' +
                '}';
    }
}

package gsa.webland.ecommercex.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Table(name="products")
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItem;

    @ManyToMany()
    @JoinTable(
        name="categorie_product",
        joinColumns = @JoinColumn(name="categorie_id"),
        inverseJoinColumns = @JoinColumn(name="product_id")
    )
    private List<Categorie> categorie;

    private String name;
    private String description;
    private double price;
    private int stock;
    private LocalDateTime created_At;
    private LocalDateTime updated_At;


    @PrePersist
    protected void setCreatedDate(){
        this.updated_At=LocalDateTime.now();
        this.created_At=LocalDateTime.now();

    }
    @PreUpdate
    protected void setUpdatedDate(){
        this.updated_At=LocalDateTime.now();
    }
    
}

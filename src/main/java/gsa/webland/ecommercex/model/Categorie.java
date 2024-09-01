package gsa.webland.ecommercex.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name="categorie")
public class Categorie {
    @ManyToMany(mappedBy="categorie")
    private List<Product> product;
    
    

    @Id
    @GeneratedValue
    private Long id;
    private String name;
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

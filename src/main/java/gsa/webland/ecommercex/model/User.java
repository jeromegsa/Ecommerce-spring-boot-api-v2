package gsa.webland.ecommercex.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<Orders> orders;

    @Column(name="username")
    private String username;

    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
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

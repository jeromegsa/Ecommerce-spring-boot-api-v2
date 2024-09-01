package gsa.webland.ecommercex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gsa.webland.ecommercex.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    
}

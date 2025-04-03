package org.aster.repositories;


import org.aster.models.User;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
    @Transactional
    public User save(User userEntity) {
        this.persist(userEntity);
        return userEntity;
    }
}

package org.aster.services;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import org.aster.dtos.UserDTO;
import org.aster.entities.User;
import org.aster.repositories.UserRepository;

@RequestScoped
public class UserService {
    @Inject
    UserRepository userRepository;

    public User createUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        return this.userRepository.save(user);
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId);
    }
}

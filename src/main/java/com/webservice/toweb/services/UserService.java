package com.webservice.toweb.services;

import com.webservice.toweb.entities.User;
import com.webservice.toweb.repositories.UserRepository;
import com.webservice.toweb.services.exception.DataBaseException;
import com.webservice.toweb.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        return optionalUser.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User insert(User obj) {
        return userRepository.save(obj);
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException err) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException err) {
            throw new DataBaseException(err.getMessage());
        }
    }

    public User update(Long id, User user) {

        User userReference = null;

        try {
            userReference = userRepository.getReferenceById(id);
            updateData(userReference, user);
        } catch (EntityNotFoundException err) {
            throw new ResourceNotFoundException(id);
        }
        return userRepository.save(userReference);
    }

    private void updateData(User userReference, User user) {
        userReference.setName(user.getName());
        userReference.setEmail(user.getEmail());
        userReference.setPhone(user.getPhone());
    }
}

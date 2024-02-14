package com.dailycode.usersystem.service.impl;

import com.dailycode.usersystem.entity.UserEntity;
import com.dailycode.usersystem.model.User;
import com.dailycode.usersystem.repository.UserRepository;
import com.dailycode.usersystem.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirtsName(user.getFirtsName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());

        // Guarda la entidad en la base de datos
        UserEntity savedUserEntity = userRepository.save(userEntity);

        // Actualiza el ID en el objeto User antes de devolverlo
        user.setId(savedUserEntity.getId());

        return user;
    }
//    public User saveUser(User user) {
//        UserEntity userEntity = new UserEntity();
//        BeanUtils.copyProperties(user, userEntity);
//        userRepository.save(userEntity);
//        return user;
//    }

    @Override
    public List<User> getAllUsers() {
        List<UserEntity> userEntities
                = userRepository.findAll();

        List<User> users = userEntities
                .stream()
                .map(userEntity -> new User(
                        userEntity.getId(),
                        userEntity.getFirtsName(),
                        userEntity.getLastName(),
                        userEntity.getEmail()
                ))
                .collect(Collectors.toList());

        return users;
    }

    @Override
    public User getUserById(Long id) {
        UserEntity userEntity
                = userRepository.findById(id).get();
        User user = new User();
        BeanUtils.copyProperties(userEntity, user);
        return user;
    }

    @Override
    public boolean deleteUser(Long id) {
        UserEntity user =  userRepository.findById(id).get();
        userRepository.delete(user);
        return true;
    }

    @Override
    public User updateUser(Long id, User user) {
        UserEntity userEntity =
                userRepository.findById(id).get();
        userEntity.setEmail(user.getEmail());
        userEntity.setFirtsName(user.getFirtsName());
        userEntity.setLastName(user.getLastName());

        userRepository.save(userEntity);
        return user;
    }

}

package com.dailycode.usersystem.service.impl;

import com.dailycode.usersystem.entity.UserEntity;
import com.dailycode.usersystem.model.User;
import com.dailycode.usersystem.repository.UserRepository;
import com.dailycode.usersystem.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userRepository.save(userEntity);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<UserEntity> userEntities = (List<UserEntity>) userRepository.findAll();

        List<User> users = userEntities.stream().map(userEntity -> new User(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getEmailId()
        )).collect(Collectors.toList());

        return users;
    }


}

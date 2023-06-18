package com.company.kotlinapp_apis.service.impl;

import com.company.kotlinapp_apis.bean.UserMapper;
import com.company.kotlinapp_apis.dao.UserRepository;
import com.company.kotlinapp_apis.dto.UserDto.UserDto;
import com.company.kotlinapp_apis.model.User;
import com.company.kotlinapp_apis.service.inter.UserServiceInter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

@Service //You can use Mapper here
public class UserServiceImpl implements UserServiceInter {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User userEntity = userMapper.toEntity(userDto);

        String savedEmail = userRepository.findById(userEntity.getId()).get()
                .getEmail();

        if(!savedEmail.isBlank()){
            throw new UnsupportedOperationException("this email already taken..");
        }

        return userMapper.toDto(userRepository.save(userEntity));
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> listDto = new ArrayList<>();

        List<User> listEntity = userRepository.findAll();

        for (User entity : listEntity) {
            UserDto dto = userMapper.toDto(entity);
            listDto.add(dto);
        }

        return listDto;
    }

    @Override
    public UserDto getUserById(Long id) {
        User entity = userRepository.findById(id).orElseThrow(() ->
                new UnsupportedOperationException("id is not exist.."));
        return userMapper.toDto(entity);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        return null;
    }

    @Override
    public Boolean deleteUser(Long id) {
        return null;
    }


//

//
//    public UserDto createUser(UserDto userDto) {
//        User user = userMapper.toEntity(userDto);
//        user.setRole(Role.USER);
//        //logic here
//
//
//        return userMapper.toDto(user);
//    }

}

package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {
    //Dependency Injection(DI)
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        User user = new User();
        user.setAccount("TestUser05");
        user.setEmail("TestUser05@gmail.com");
        user.setPhoneNumber("010-4567-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User newUser = userRepository.save(user);
        System.out.println("newUser : "+newUser);
    }

    @Test
    @Transactional
    public void read() {
//        Optional<User> user = userRepository.findById(2L);
        Optional<User> user = userRepository.findByAccount("TestUser03");

        user.ifPresent(selectUser ->{
            selectUser.getOrderDetailList().stream().forEach(detail->{
                System.out.println(detail.getItemId());
            });

        });
    }

    @Test
    public void update() {

        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser ->{
            selectUser.setAccount("pppp");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });

    }

//    @DeleteMapping("/api/user")
    @Test
    @Transactional
    public void delete() {
        Optional<User> user = userRepository.findById(1L);

        Assertions.assertTrue(user.isPresent());

        user.ifPresent(selectUser->{
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(1L);

//        if(deleteUser.isPresent()){
//            System.out.println("데이터 존재 :"+deleteUser.get());
//        }else{
//            System.out.println("데이터 삭제 데이터 없음");
//        }
        Assertions.assertFalse(deleteUser.isPresent());
    }
}

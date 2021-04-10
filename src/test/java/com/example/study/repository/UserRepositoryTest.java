package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import com.sun.tools.javac.util.Assert;
import jdk.vm.ci.meta.Local;
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
        String account = "Test01";
        String password = "Test01";
        String status = "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-2322";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);
        Assertions.assertNotNull(newUser);
    }

    @Test
    @Transactional
    public void read() {
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2322");
        Assertions.assertNotNull(user);
    }


//
//    @Test
//    public void update() {
//
//        Optional<User> user = userRepository.findById(2L);
//
//        user.ifPresent(selectUser ->{
//            selectUser.setAccount("pppp");
//            selectUser.setUpdatedAt(LocalDateTime.now());
//            selectUser.setUpdatedBy("update method()");
//
//            userRepository.save(selectUser);
//        });
//
//    }
//
////    @DeleteMapping("/api/user")
//    @Test
//    @Transactional
//    public void delete() {
//        Optional<User> user = userRepository.findById(1L);
//
//        Assertions.assertTrue(user.isPresent());
//
//        user.ifPresent(selectUser->{
//            userRepository.delete(selectUser);
//        });
//
//        Optional<User> deleteUser = userRepository.findById(1L);
//
////        if(deleteUser.isPresent()){
////            System.out.println("데이터 존재 :"+deleteUser.get());
////        }else{
////            System.out.println("데이터 삭제 데이터 없음");
////        }
//        Assertions.assertFalse(deleteUser.isPresent());
//    }
}

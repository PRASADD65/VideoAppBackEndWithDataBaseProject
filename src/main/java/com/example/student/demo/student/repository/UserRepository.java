package com.example.student.demo.student.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.student.demo.student.module.User;
public interface UserRepository extends JpaRepository<User, Long> {
    User findByFirstNameAndLastName(String firstName, String lastName);
    User findByFirstNameAndPassword(String firstName, String password);
    User findByFirstName(String firstName);
}

package ru.sf.MongoDBTest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.sf.MongoDBTest.entity.User;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    User findByFirstName(String firstname);
    List<User> findByEmail(String email);
    Long deletePersonByFirstName(String firstName);
}

package ru.sf.MongoDBTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.sf.MongoDBTest.entity.User;
import ru.sf.MongoDBTest.repository.UserRepository;

@SpringBootApplication
public class MongoDbTestApplication implements CommandLineRunner {

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(MongoDbTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("blah-blah");
		repository.deleteAll();
		repository.save(new User("Tester", "Testerov", "test@test.com", "+1005224"));
		repository.save(new User("SecondUser", "His latName","test@test.com","+795001"));

		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (User user : repository.findAll()) {
			System.out.println(user);
		}
		System.out.println();

		System.out.println("Customer found with findByFirstName('Tester'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Tester"));

		System.out.println("Customers found with findByEmail('test@test.com'):");
		System.out.println("--------------------------------");
		for (User User : repository.findByEmail("test@test.com")) {
			System.out.println(User);
		}
	}
}

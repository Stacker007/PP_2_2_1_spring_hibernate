package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        CarService carService = context.getBean(CarService.class);

        UserService userService = context.getBean(UserService.class);
        Car car = new Car("Tesla", 1);
        Car car2 = new Car("MB", 2);
        Car car3 = new Car("Honda", 3);
        Car car4 = new Car("Honda", 4);
        carService.add(car);
        carService.add(car2);
        carService.add(car3);
        carService.add(car4);


        userService.add(new User("User1", "Lastname1", "user1@mail.ru", car));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", car2));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", car3));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", car4));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }
        userService.getUsersByCar("Tesla",1).stream()
                .forEach(System.out::println);

        context.close();
    }
}

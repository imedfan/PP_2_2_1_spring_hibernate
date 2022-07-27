package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.NoResultException;


// select * from users
// JOIN car ON users.car_id = car.id
// WHERE car.model = 'Volga' AND car.series = '21'

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Volga", 24) ));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Belaz", 21)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("Gaz", 23)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Uaz", 25)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
         System.out.println("Car model = " + user.getModel() + " , model =" + user.getSeries());
         System.out.println();

      }

      try{
         System.out.println("------------------------");
         System.out.println(userService.getUserWhereCar("Volga", 24));
      }catch(NoResultException e){
         e.printStackTrace();
      }
     

      
      context.close();
   }
}

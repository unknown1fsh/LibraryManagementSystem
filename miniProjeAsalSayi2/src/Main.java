import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();

        // Kullanıcı ekleme işlemi
        userController.addUser("omer", "oaoyun123@example.com");

        // Kullanıcıları listeleme işlemi
        List<User> users = userController.getUsers();
        for (User user : users) {
            System.out.println("Username: " + user.getUsername() + ", Email: " + user.getEmail());
        }
    }
}

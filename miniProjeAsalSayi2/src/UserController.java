import java.util.List;

public class UserController {
    private UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    public void addUser(String username, String email) {
        userService.addUser(username, email);
    }

    public List<User> getUsers() {
        return userService.getUsers();
    }

    // Diğer istekler buraya eklenebilir: kullanıcı güncelleme, silme vb.
}

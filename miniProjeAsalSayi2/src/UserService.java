import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
    }

    public void addUser(String username, String email) {
        User newUser = new User(username, email);
        users.add(newUser);
    }

    public List<User> getUsers() {
        return users;
    }

    // Diğer işlemler buraya eklenebilir: kullanıcı güncelleme, silme vb.
}

package Blog;

public interface Commends {
    void publishPost(String author, String text);

    void commentPost(int postId, String author, String text);

    User signUp(String firstName, String lastName, String nickName, String password);

    User signIn(String nickName, String password);

    void start();

    void menu(User user);
}

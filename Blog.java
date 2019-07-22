package Blog;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Blog implements Commends {
    private List<User> Users = new ArrayList<User>();
    private List<Post> Posts = new ArrayList<Post>();
    static Integer identifier;

    public Blog() {
        identifier = 1000;
    }

    public void publishPost(String author, String text) {
        Entry post = new Post(author, text);
        Posts.add((Post) post);
        System.out.println("Dodałeś posta o ID: " + post.getId() + "   data dodania: " + post.getDate());
    }
    public void commentPost(int postId, String author, String text) {
        Entry comment = new Comment(author, text);
        for (Post element : Posts) {
            if (element.getId() == postId) {
                element.setComment((Comment) comment);
            }
        }
        System.out.println("Dodałeś komentarz o ID: " + comment.getId() + "   data dodania: " + comment.getDate());
    }

    @Override
    public User signUp(String firstName, String lastName, String nickName, String password) {
        User user = new User(firstName, lastName, nickName, password);
        Users.add(user);
        System.out.println("Rejestracja przebiegła pomyślnie");
        return user;
    }

    @Override
    public User signIn(String nickName, String password) {
        for (User user : Users) {
            if (user.getNickName().equals(nickName) && user.getPassword().equals(password))
                return user;
        }
        System.out.println("Błędny login lub hasło");
        return null;
    }

    @Override
    public void start() {
        System.out.println("Wybierz opcję:");
        System.out.println("1 : Zaloguj się");
        System.out.println("2 : Zarejestruj się");
        System.out.println("3 : Wyłącz Bloga");
        Scanner scn = new Scanner(System.in);
        switch (scn.nextLine()) {
            case "1":
                System.out.println("Podaj nick: ");
                String nickName = scn.nextLine();
                System.out.println("Podaj hasło: ");
                String password = scn.nextLine();
                menu(signIn(nickName, password));
                break;
            case "2":
                System.out.println("Rejestracja użytkownika " + "\n" + "Podaj imię: ");
                String firstName = scn.nextLine();
                System.out.println("Podaj nazwisko: ");
                String lastName = scn.nextLine();
                boolean bool = true;
                do {
                    System.out.println("Podaj nick: ");
                    nickName = scn.nextLine();
                    for (User element : Users) {
                        if (element.getNickName().equals(nickName)) {
                            bool = false;
                            System.out.println("Ten nick już istnieje");
                        } else bool = true;
                    }
                } while (!bool);
                System.out.println("Podaj hasło: ");
                password = scn.nextLine();
                String password2;
                do {
                    System.out.println("Powtórz hasło: ");
                    password2 = scn.nextLine();
                    if (!password.equals(password2)) System.out.println("Niepoprawne hasło");
                } while ((!password.equals(password2)));
                menu(signUp(firstName, lastName, nickName, password));
                break;
            case "3":
                break;
                default:
                    System.out.println("Nie ma takiej opcji");
                    start();
                    break;
        }
    }

    @Override
    public void menu(User user) {
        System.out.println("Witaj " + user.getFirstName() + "!");
        boolean bool = true;
        do {
            System.out.println("Wybierz opcję:");
            System.out.println("1 : Opublikuj post" + "\n" + "2 : Skomentuj post po jego ID" + "\n" + "3 : Wypisz wszystkie posty użytkownika" + "\n" + "4 : Wyszukaj po ID" + "\n" + "5 : Wyloguj");
            Scanner scn = new Scanner(System.in);
            switch (scn.nextLine()) {
                case "1":
                    System.out.println("Napisz treść posta");
                    publishPost(user.getNickName(), scn.nextLine());
                    break;
                case "2":
                    int postId;
                    boolean bool1 = true;
                    do {
                        System.out.println("Podaj ID posta");
                        postId = scn.nextInt();
                        for (Post post : Posts) {
                            if (post.getId() == postId)
                                bool1 = false;
                        }
                        if (bool1)
                            System.out.println("Błędny ID posta");
                    } while (bool1);
                    System.out.println("Napisz treść komentarza");
                    scn = new Scanner(System.in);
                    String tekst = scn.nextLine();
                    commentPost(postId, user.getNickName(), tekst);
                    break;
                case "3":
                    System.out.println("Podaj nick użytkownika");
                    String nick = scn.nextLine();
                    for (Post post : Posts) {
                        if (post.getAuthor().equals(nick))
                            System.out.println("ID: " + post.getId() + "   " + post.getText() + "   data dodania: " + post.getDate());
                    }
                    break;
                case "4":
                    System.out.println("Podaj ID");
                    int id = scn.nextInt();
                    for (User user1 : Users) {
                        if (user1.getId() == id)
                            System.out.println("Użytkownik: " + user1.getNickName());
                    }
                    for (Post post1 : Posts) {
                        if (post1.getId() == id)
                            System.out.println("Post użytkownika " + post1.getAuthor() + ": " + post1.getText() + "   data dodania: " + post1.getDate());
                        for (Comment com1 : post1.getComments()) {
                            if (com1.getId() == id)
                                System.out.println("Komentarz użytkownika " + com1.getAuthor() + ": " + com1.getText() + "   data dodania: " + com1.getDate());
                        }
                    }
                    break;
                case "5":
                    bool = false;
                    break;
                    default:
                        System.out.println("Nie ma takiej opcji");
            }

        } while (bool);
        start();
    }

    public static void main(String[] args) {
        Blog b = new Blog();
        b.start();
    }
}

import config.ProjectConfig;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;
import services.UserService;

public class Main {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        ProjectConfig.class);

    CommentService commentService = context.getBean(CommentService.class);

    Comment comment = new Comment();
    comment.setText("Demo comment");
    comment.setAuthor("Jay");

    // Spring Context 回傳的 CommentService 物件會變成一顆 proxy 物件
    System.out.println("CommentService: "+commentService.getClass().toString());
    commentService.publishComment(comment);

    UserService userService = context.getBean(UserService.class);
    userService.readComment(comment);

    // Spring Context 回傳的 UserService 物件會變成一顆 proxy 物件
    System.out.println("UserService: "+userService.getClass().toString());


  }
}

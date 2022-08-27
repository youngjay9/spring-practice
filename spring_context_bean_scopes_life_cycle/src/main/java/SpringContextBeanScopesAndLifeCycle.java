import config.ProjectConfig;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;
import services.UserService;

public class SpringContextBeanScopesAndLifeCycle {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        ProjectConfig.class);

    CommentService commentService = context.getBean(CommentService.class);

    UserService userService = context.getBean(UserService.class);


    boolean b = commentService.getCommentRepository() == userService.getCommentRepository();

    System.out.println(b);
  }
}

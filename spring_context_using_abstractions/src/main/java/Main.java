import configuration.ProjectConfig;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {

  public static void main(String[] args) {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        ProjectConfig.class);

    Comment comment = new Comment();
    comment.setAuthor("Jay");
    comment.setText("Fucking comment!!");

    CommentService commentService = context.getBean(CommentService.class);

    commentService.publishComment(comment);

  }
}

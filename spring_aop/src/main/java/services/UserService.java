package services;

import aspects.AnnotationAspect;
import java.util.logging.Logger;
import model.Comment;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private Logger logger = Logger.getLogger(CommentService.class.getName());

  @AnnotationAspect
  public void readComment(Comment comment) {
    logger.info("User read comment: " + comment.getText());
  }
}

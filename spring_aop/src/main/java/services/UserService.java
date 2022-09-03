package services;

import aspects.Annotation_Aspect;
import java.util.logging.Logger;
import model.Comment;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private Logger logger = Logger.getLogger(CommentService.class.getName());

  @Annotation_Aspect
  public void readComment(Comment comment) {
    logger.info("User read comment: " + comment.getText());
  }
}

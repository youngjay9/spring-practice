package proxies;

import model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("email")
public class EmailCommentNotificationproxy implements CommentNotificationProxy {

  @Override
  public void sendComment(Comment comment) {
    System.out.println("Sending notification using email for comment:" + comment.getText());
  }
}

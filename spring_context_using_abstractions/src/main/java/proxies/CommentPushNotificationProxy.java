package proxies;

import model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("push")
public class CommentPushNotificationProxy implements CommentNotificationProxy {

  @Override
  public void sendComment(Comment comment) {
    System.out
        .println("Sending notification use pushNotification for comment:" + comment.getText());
  }
}

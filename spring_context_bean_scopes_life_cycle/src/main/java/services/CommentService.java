package services;

import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import processors.CommentProcessor;
import repositories.CommentRepository;

@Service
public class CommentService {

  @Autowired
  private ApplicationContext context;
  
  @Autowired
  private CommentRepository commentRepository;

  public CommentRepository getCommentRepository() {
    return commentRepository;
  }

  public void sendComment(Comment comment){

    /*
      不可將 scope: prototype bean(CommentProcessor) 直接 autowired 至
      scope:singleton bean(CommentService);
      因為 singleton bean 在加入 spring context 時只會初始化一次, 如果將 prototype bean
      直接 autowired 至此, 會造成 prototype bean 的物件也只會初始化一次，之後拿到的都是同一顆物件。
    */
    CommentProcessor processor = context.getBean(CommentProcessor.class);
    processor.setComment(comment);
    processor.processComment();

  }
}

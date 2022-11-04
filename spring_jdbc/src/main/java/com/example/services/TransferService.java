package com.example.services;

import com.example.model.Account;
import com.example.repositories.AccountRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferService {

  private final AccountRepository accountRepository;

  public TransferService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Transactional
  /**
   * 在 transactional 下, 沒有發生 exception 整個交易才會 commit
   */
  public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
    Account sender = accountRepository.findAccountById(idSender);
    Account receiver = accountRepository.findAccountById(idReceiver);

    BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
    BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

    accountRepository.changeAmount(idSender, senderNewAmount);
    accountRepository.changeAmount(idReceiver, receiverNewAmount);
    // 沒有此 exception, 上面 2 個 changeAmount 才會 commit 至 DB
    throw new RuntimeException("Oh no! Something went wrong!");
  }

  public List<Account> getAllAccounts() {
    return accountRepository.findAllAccounts();
  }
}

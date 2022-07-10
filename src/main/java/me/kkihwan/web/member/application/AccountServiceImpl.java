package me.kkihwan.web.member.application;

import lombok.RequiredArgsConstructor;
import me.kkihwan.web.member.application.model.AccountResponse;
import me.kkihwan.web.member.db.AccountRepository;
import me.kkihwan.web.member.domain.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final AccountRepository accountRepository;

    @Transactional
    @Override
    public AccountResponse create(Account account) {
        Account savedAccount = accountRepository.save(account);
        return AccountResponse.builder()
                .id(savedAccount.getId())
                .build();
    }
}
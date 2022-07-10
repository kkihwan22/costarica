package me.kkihwan.web.member.application;

import me.kkihwan.web.member.application.model.AccountResponse;
import me.kkihwan.web.member.domain.Account;

public interface AccountService {
    AccountResponse create(Account account);
}

package me.kkihwan.web.member.rest;

import lombok.RequiredArgsConstructor;
import me.kkihwan.web.member.application.AccountService;
import me.kkihwan.web.member.application.model.AccountParameter;
import me.kkihwan.web.member.application.model.AccountResponse;
import me.kkihwan.web.shared.application.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AccountRestController {
    private final Logger LOG = LoggerFactory.getLogger(AccountRestController.class);
    private final AccountService accountService;

    //JPA SAVE TEST
    @PostMapping("/accounts")
    public BaseResponse<AccountResponse> createAccount(@RequestBody AccountParameter parameter) {
        LOG.debug(parameter.toString());
        AccountResponse response = accountService.create(parameter.toEntity());
        return BaseResponse.successResponse(response);
    }

}

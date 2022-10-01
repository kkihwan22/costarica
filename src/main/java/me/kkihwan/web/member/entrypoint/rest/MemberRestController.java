package me.kkihwan.web.member.entrypoint.rest;


import lombok.RequiredArgsConstructor;
import me.kkihwan.web.member.application.MemberService;
import me.kkihwan.web.member.entrypoint.rest.model.MemberRegisterRequest;
import me.kkihwan.web.shared.entrypoint.BaseRestController;
import me.kkihwan.web.shared.entrypoint.Body;
import me.kkihwan.web.shared.entrypoint.BodyFactory;
import me.kkihwan.web.shared.entrypoint.SimpleBodyData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberRestController implements BaseRestController {
    private final Logger log = LoggerFactory.getLogger(MemberRestController.class);
    private final MemberService memberService;

    @PostMapping("/public/v1/members")
    public ResponseEntity<Body<SimpleBodyData<Long>>> registerMember(
            @RequestBody MemberRegisterRequest request,
            BindingResult bindingResult) {
        log.debug("[ request ] : {}", request);

        hasError(bindingResult);

        Long id = memberService.registerMember(request.to());
        log.debug("register member id: {}", id);

        SimpleBodyData<Long> result = new SimpleBodyData<>(id);

        return ResponseEntity.ok(BodyFactory.success(result));
    }
}
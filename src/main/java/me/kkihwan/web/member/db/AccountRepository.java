package me.kkihwan.web.member.db;


import me.kkihwan.web.member.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {

}

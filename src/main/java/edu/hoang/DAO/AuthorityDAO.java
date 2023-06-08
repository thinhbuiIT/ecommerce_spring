package edu.hoang.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.hoang.entity.Account;
import edu.hoang.entity.Authority;

public interface AuthorityDAO extends JpaRepository<Authority,Integer> {
	public List<Authority> findByAccount(Account account);
}

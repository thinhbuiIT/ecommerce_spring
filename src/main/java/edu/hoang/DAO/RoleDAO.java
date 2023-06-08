package edu.hoang.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.hoang.entity.Role;

public interface RoleDAO extends JpaRepository<Role,String> {
	
}

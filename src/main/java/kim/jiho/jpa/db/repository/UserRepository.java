package kim.jiho.jpa.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kim.jiho.jpa.db.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {}

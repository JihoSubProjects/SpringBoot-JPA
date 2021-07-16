package kim.jiho.jpa.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kim.jiho.jpa.db.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}

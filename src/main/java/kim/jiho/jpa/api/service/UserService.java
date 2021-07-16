package kim.jiho.jpa.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kim.jiho.jpa.db.entity.User;
import kim.jiho.jpa.db.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
	List<User> users = new ArrayList<>();
	userRepository.findAll().forEach(user -> users.add(user));
	return users;
    }

    public Optional<User> findById(Long userPID) {
	Optional<User> user = userRepository.findById(userPID);
	return user;
    }

    public User save(User user) {
	userRepository.save(user);
	return user;
    }

    public void updateById(Long userPID, User updatedUser) {
	Optional<User> user = userRepository.findById(userPID);
	if (user.isPresent()) {
	    user.get().setPassword(updatedUser.getPassword());
	    user.get().setName(updatedUser.getName());
	    userRepository.save(user.get());
	}
    }

    public void deleteById(Long userPID) {
	userRepository.deleteById(userPID);
    }

}

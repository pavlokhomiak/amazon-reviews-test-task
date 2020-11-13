package mate.academy.boot.hellobootdemo.service.impl;

import java.util.List;
import mate.academy.boot.hellobootdemo.models.User;
import mate.academy.boot.hellobootdemo.repository.UserRepository;
import mate.academy.boot.hellobootdemo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public void update(User user, Long id) {
        User userFromDb = userRepository.getOne(id);
        userFromDb.setProfileName(user.getProfileName());
        userFromDb.setPassword(user.getPassword());
        userFromDb.setReviewList(user.getReviewList());
        userFromDb.setRoles(user.getRoles());
        userRepository.save(userFromDb);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}

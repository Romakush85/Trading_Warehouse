package ua.kushnir.petproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.kushnir.petproject.models.user.Role;
import ua.kushnir.petproject.models.user.User;
import ua.kushnir.petproject.models.user.UserDetailsImpl;
import ua.kushnir.petproject.repositories.RolesRepository;
import ua.kushnir.petproject.repositories.UsersRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService implements UserDetailsService {

    private final UsersRepository usersRepository;
    private final RolesRepository rolesRepository;

    public User findByUsername(String username) {
        Optional<User> user =  usersRepository.findByUsername(username);
        return user.orElse(null);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if(Objects.isNull(user)) {
            throw  new UsernameNotFoundException(String.format("User %s is not found", username));
        }

        return UserDetailsImpl.build(user);
    }

    public void createUser(User user, Role role) {
        user.setRoles(List.of(rolesRepository.findByName(role.getName()).get()));
        usersRepository.save(user);
    }
}

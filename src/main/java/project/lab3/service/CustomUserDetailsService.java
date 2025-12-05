package project.lab3.service;

import project.lab3.models.User;
import project.lab3.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException("User not found");

        UserBuilder builder =
                org.springframework.security.core.userdetails.User.withUsername(user.getUsername());
        builder.password(user.getPasswordHash());
        builder.roles(user.getRole()); // Spring автоматично додає префікс ROLE_
        return builder.build();
    }
}

package kg.attractor.exam9.service.impl;

import kg.attractor.exam9.dto.UserDto;
import kg.attractor.exam9.exceptions.SuchEmailAlreadyExistsException;
import kg.attractor.exam9.exceptions.UserNotFoundException;
import kg.attractor.exam9.models.Role;
import kg.attractor.exam9.models.User;
import kg.attractor.exam9.repository.UserRepository;
import kg.attractor.exam9.service.RoleService;
import kg.attractor.exam9.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.Arrays;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;


//    @Override
//    public void updateUserByEmail(String email, UserEditDto userEditDto) throws SuchEmailAlreadyExistsException, RoleNotFoundException {
//        boolean isExistsUser = userRepository.existsUserByEmail(email);
//        if(!isExistsUser){
//            throw new UserNotFoundException();
//        }
//
//        User user = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
//
//        user.setName(userEditDto.getName());
//        user.setSurname(userEditDto.getSurname());
//        user.setAge(userEditDto.getAge());
////        user.setEmail(userDto.getEmail());
//        user.setPassword(userEditDto.getPassword());
//        user.setPhoneNumber(userEditDto.getPhoneNumber());
//        user.setAvatar(userImage);
//
////        user.setAccountType(userDto.getAccountType().toUpperCase());
////        user.setRoles(Arrays.asList(roleRepository.findRoleByRole(userDto.getAccountType().toUpperCase())));
//
//        userRepository.save(user);
//
//    }
    @Override
    public void save(User user){
        userRepository.saveAndFlush(user);
    }


    @Override
    public UserDto getUserByEmail(String userEmail) {
        User user = userRepository.findByEmail(userEmail).orElseThrow(UserNotFoundException::new);
        return builder(user);
    }

    @Override
    public Optional<User> getUserByEmailModel(String userEmail) {
        Optional<User> user = userRepository.findByEmail(userEmail);
        return user;
    }


    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.of(userRepository.findById(id).orElseThrow(UserNotFoundException::new));
    }




    @Override
    public void register(UserDto userDto) throws SuchEmailAlreadyExistsException, RoleNotFoundException {

        boolean isUserExists = userRepository.existsUserByEmail(userDto.getEmail());
        if(isUserExists){
            throw new SuchEmailAlreadyExistsException();
        }

        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEnabled(true);

        Role role = roleService.findRoleByRole("USER");

        user.setRoles(Arrays.asList(role));
        role.setUsers(Arrays.asList(user));

        userRepository.saveAndFlush(user);
    }


    private UserDto builder(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .enabled(user.getEnabled())
                .roleName(user.getRoles().iterator().next().getRole())
                .build();
    }



}

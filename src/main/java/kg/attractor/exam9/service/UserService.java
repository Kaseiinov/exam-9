package kg.attractor.exam9.service;


import jakarta.servlet.http.HttpServletRequest;
import kg.attractor.exam9.dto.UserDto;
import kg.attractor.exam9.exceptions.SuchEmailAlreadyExistsException;
import kg.attractor.exam9.models.User;

import javax.management.relation.RoleNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

public interface UserService {

    //
    //        userRepository.save(user);
    //
    //    }

    void save(User user);

    UserDto getUserByEmail(String userEmail);

    Optional<User> getUserByEmailModel(String userEmail);

    Optional<User> getUserById(Long id);

    void register(UserDto userDto) throws SuchEmailAlreadyExistsException, RoleNotFoundException;
}

package kg.attractor.exam9.service.impl;


import kg.attractor.exam9.models.Role;
import kg.attractor.exam9.repository.RoleRepository;
import kg.attractor.exam9.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role findRoleByRole(String role){
        return roleRepository.findRoleByRole(role);
    }

}

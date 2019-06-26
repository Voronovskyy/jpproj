package LITS.jpproj.service.impl;

import LITS.jpproj.entity.User;
import LITS.jpproj.repository.UserRepository;
import LITS.jpproj.service.UserDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import LITS.jpproj.entity.User;
import LITS.jpproj.repository.UserRepository;
import LITS.jpproj.service.UserDtoService;
import LITS.jpproj.service.TokenService;

@Service
public class UserDtoServiceImpl implements UserDtoService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String auth(String login, String pass) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login,
                        pass
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = userRepository.findUserByLogin(login);
        return tokenService.createToken(user.getId());
    }
}

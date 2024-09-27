package fr.assara.user.application;

import fr.assara.user.ReadUserDTO;
import fr.assara.user.mapper.UserMapper;
import fr.assara.user.model.User;
import fr.assara.user.repository.UserRepository;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.Instant;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    /**
     * Method to synchronize with oAuth2User'attributes with info User in our Database
     */
    public void syncWithIdp(OAuth2User oAuth2User) {
        Map<String, Object> attributes = oAuth2User.getAttributes();
        User user = mapOauth2AttributesToUser(attributes);
        Optional<User> userExisting = userRepository.findOneByEmail(user.getEmail());
        if(userExisting.isPresent()) {
            if(attributes.get("updated_at") != null) {
                Instant dbLastModifiedDate = userExisting.orElseThrow().getLastModifiedDate();
                Instant idpModifiedDate;
                if(attributes.get("updated_at") instanceof Instant) {
                    idpModifiedDate = (Instant) attributes.get("updated_at");
                } else {
                    idpModifiedDate = Instant.ofEpochSecond((Integer) attributes.get("updated_at"));
                }
                if(idpModifiedDate.isAfter(dbLastModifiedDate)) {
                    updateUser(user);
                }
            }
        } else {
            userRepository.saveAndFlush(user);
        }
    }

    /**
     * Method to transform and get authenticated User to readUserDTO
     */
    public ReadUserDTO getUserAuthenticatedfromSecurityContext() {
        OAuth2User principal = (OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = mapOauth2AttributesToUser(principal.getAttributes());
        return userMapper.readUserDTOtoUser(user);
    }


    /**
     * Method to update user
     */
    private void updateUser(User user) {

        Optional<User> userExisting = this.userRepository.findOneByEmail(user.getEmail());

        if(userExisting.isPresent()) {
            User userUpdated = userExisting.get();
            userUpdated.setFirstName(user.getFirstName());
            userUpdated.setLastName(user.getLastName());
            userUpdated.setEmail(user.getEmail());
            userUpdated.setImageUrl(user.getImageUrl());
            userRepository.saveAndFlush(userUpdated);
        }
    }

    /**
     * Method to map all user'attributes from Oauth2
     */
    private User mapOauth2AttributesToUser(Map<String, Object> attributes) {

        String sub = String.valueOf(attributes.get("sub"));
        User user = new User();
        String username = null;

        if(attributes.get("given_name") != null) {
            user.setFirstName((String) attributes.get("given_name"));
        } else if(attributes.get("name") != null) {
            user.setFirstName((String) attributes.get("name"));
        }

        if(attributes.get("family_name") != null) {
            user.setLastName((String) attributes.get("family_name"));
        }

        if(attributes.get("preferred_username") != null) {
            username = ((String) attributes.get("preferred_username")).toLowerCase();
        }

        if(attributes.get("email") != null) {
            user.setEmail((String) attributes.get("email"));
        } else if(sub.contains("|") && (username != null && username.contains("@"))) {
            user.setEmail(username);
        } else {
            user.setEmail(sub);
        }

        if(attributes.get("picture") != null) {
            user.setImageUrl((String) attributes.get("picture"));
        }

        return user;
    }
}

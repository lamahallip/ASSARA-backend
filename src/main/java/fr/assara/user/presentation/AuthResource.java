package fr.assara.user.presentation;

import fr.assara.user.ReadUserDTO;
import fr.assara.user.application.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class AuthResource {

    private final UserService userService;
    private final ClientRegistration clientRegistration;

    public AuthResource(UserService userService, ClientRegistrationRepository clientRegistrations) {
        this.userService = userService;
        this.clientRegistration = clientRegistrations.findByRegistrationId("okta");
    }

    // Method to get and read info User from Authentication
    @GetMapping(value = "/get-authenticated-user")
    public ResponseEntity<ReadUserDTO> getAuthenticatedUser(@AuthenticationPrincipal OAuth2User user) {
        if(user == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            userService.syncWithIdp(user);
            ReadUserDTO userFromAuthentication = userService.getUserAuthenticatedfromSecurityContext();
            return ResponseEntity.ok().body(userFromAuthentication);
        }
    }

    // Method to logout
    @PostMapping(value = "/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        String originUrl = request.getHeader(HttpHeaders.ORIGIN);
        String issuerUri = clientRegistration.getProviderDetails().getIssuerUri();
        Object[] params = { originUrl, issuerUri, clientRegistration.getClientId() };
        String logoutUrl = MessageFormat.format("{0}v2/logout?client_id={1}&returnTo={2}", params);
        request.getSession().invalidate();
        return ResponseEntity.ok().body(Map.of("logoutUrl", logoutUrl));
    }
}

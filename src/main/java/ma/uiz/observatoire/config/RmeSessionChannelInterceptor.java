package ma.uiz.observatoire.config;

import io.jsonwebtoken.JwtException;
import ma.uiz.observatoire.repository.TokenRepository;
import ma.uiz.observatoire.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.MultiValueMap;

public class RmeSessionChannelInterceptor implements ChannelInterceptor {


    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private TokenRepository tokenRepository;


    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        String userEmail;
        String jwt;
        MessageHeaders headers = message.getHeaders();
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
        MultiValueMap<String, String> multiValueMap = headers.get(StompHeaderAccessor.NATIVE_HEADERS,
                MultiValueMap.class);
        if (multiValueMap != null) {
            if (multiValueMap.containsKey("Authorization")) {
                jwt = multiValueMap.get("Authorization").get(0);
                if (!jwt.startsWith("Bearer ")) {
                    return null;
                }
                jwt = jwt.substring(7);
                userEmail = jwtService.extractUsername(jwt);
                if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
                    var isTokenValid = tokenRepository.findByToken(jwt).map(t -> !t.isExpired() && !t.isRevoked())
                            .orElse(false);
                    if (!(jwtService.isTokenValid(jwt, userDetails) && isTokenValid))
                        throw new JwtException("Invalid Token") {};
                }
            }
        }
        return message;
    }

    /** For testing purposes only */
    public JwtService getJwtService() {
        return jwtService;
    }

    /** For testing purposes only */
    public TokenRepository getTokenRepository() {
        return tokenRepository;
    }

    /** For testing purposes only */
    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }
}

package com.codingmanstudio.courses.filters;

import com.codingmanstudio.courses.api.v1.dto.Student.StudentDTO;
import com.codingmanstudio.courses.domain.Account;
import com.codingmanstudio.courses.services.AccountService;
import com.codingmanstudio.courses.services.TokenAuthenticationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Transactional
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {
    private final AccountService accountService;
    public JWTLoginFilter(String url, AuthenticationManager authManager, AccountService accountService) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
        this.accountService=accountService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        Account credentials = new Account(request.getParameter("username"), request.getParameter("password"));
        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        credentials.getUsername(),
                        credentials.getEncrytedPassword()
                )
        );
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        TokenAuthenticationService.addAuthentication(response, authResult);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        Object userInfo= accountService.getUserInfo(request.getParameter("username"));
        ObjectMapper objectMapper = new ObjectMapper();
        String userInfoString= objectMapper.writeValueAsString(userInfo);
        response.getWriter().write(userInfoString);
    }
}

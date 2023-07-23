package com.Mohan.ExpenseTracker.services;

import com.Mohan.ExpenseTracker.models.AuthenticationToken;
import com.Mohan.ExpenseTracker.models.User;
import com.Mohan.ExpenseTracker.repositories.IAuthTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthTokenService {
    @Autowired
    private IAuthTokenRepo authTokenRepo;

    public String addToken(User existingUser) {
        AuthenticationToken token = new AuthenticationToken(existingUser);
        authTokenRepo.save(token);
        return token.getTokenValue();
    }

    public AuthenticationToken getTokenByUser(User existingUser) {
        return authTokenRepo.findByUser(existingUser);
    }

    public void removeToken(AuthenticationToken existingToken) {
        authTokenRepo.delete(existingToken);
    }
}

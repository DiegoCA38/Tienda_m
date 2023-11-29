package com.tienda.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author diego
 */
public interface UsuarioDetailsService {
    public UserDetails loadUserbyUsername(String username) throws
            UsernameNotFoundException;
}

package com.game.tagiron.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtil {
    private static PasswordEncoder encoder = null;

    public static PasswordEncoder getPasswordEncoder() {
        if(encoder == null) encoder = new BCryptPasswordEncoder();
        return encoder;
    }

    public static boolean matches( String password, String encoded ) {
        return encoder.matches( password, encoded );
    }

}

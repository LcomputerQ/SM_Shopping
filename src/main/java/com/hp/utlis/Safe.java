package com.hp.utlis;

import org.springframework.util.Base64Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Safe {
    public static String md5(String txt) {
        String rust = "";
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            md.update(txt.getBytes());
            byte[] digest = md.digest();
            rust = Base64Utils.encodeToString(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return rust;
    }

}

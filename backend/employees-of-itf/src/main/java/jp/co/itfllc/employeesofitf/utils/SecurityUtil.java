package jp.co.itfllc.employeesofitf.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.stereotype.Component;

@Component
public class SecurityUtil {
    private final RandomStringUtil randomStringUtil;

    private final MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

    private final String algorithm = "PBKDF2WithHmacSHA256";

    private final SecretKeyFactory skf = SecretKeyFactory.getInstance(this.algorithm);

    private final Integer stretchCount = 10000;

    private final Integer saltLength = 16;

    public SecurityUtil(RandomStringUtil randomStringUtil) throws NoSuchAlgorithmException {
        this.randomStringUtil = randomStringUtil;
    }

    public String getHashedPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String salt = this.randomStringUtil.nextString(this.saltLength);
        byte[] hashedSalt = this.hashSalt(salt);
        String hashedPassword = this.hashPassword(password, hashedSalt);

        return salt + "." + hashedPassword;
    }

    public Boolean validatePassword(String password, String hashedPassword) {
        return true;
    }

    private byte[] hashSalt(String salt) throws NoSuchAlgorithmException {
        this.messageDigest.update(salt.getBytes());

        return this.messageDigest.digest();
    }

    private String hashPassword(String password, byte[] hashedSalt)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        var keySpec = new PBEKeySpec(password.toCharArray(), hashedSalt, this.stretchCount, 512);
        SecretKey secretKey = this.skf.generateSecret(keySpec);
        byte[] encodedBytes = secretKey.getEncoded();
        var sb = new StringBuilder();

        for (byte b : encodedBytes) {
            sb.append(String.format("%02x", b & 0xff));
        }

        return sb.toString();
    }
}

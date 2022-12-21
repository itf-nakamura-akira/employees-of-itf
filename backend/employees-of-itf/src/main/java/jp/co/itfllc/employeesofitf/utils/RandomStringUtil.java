package jp.co.itfllc.employeesofitf.utils;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomStringUtil {
    private final Random random = new SecureRandom();

    private final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private final String lower = upper.toLowerCase(Locale.ROOT);

    private final String digits = "0123456789";

    private final String alphanum = upper + lower + digits;

    private final char[] symbols = alphanum.toCharArray();

    public String nextString() {
        return this.nextString(16);
    }

    public String nextString(Integer length) {
        if (length < 1){
            throw new IllegalArgumentException();
        }

        var buf = new char[length];

        for (int i = 0; i < buf.length; ++i) {
            buf[i] = this.symbols[this.random.nextInt(this.symbols.length)];
        }

        return new String(buf);
    }
}

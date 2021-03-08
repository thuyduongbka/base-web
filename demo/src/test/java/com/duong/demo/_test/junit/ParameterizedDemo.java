package com.duong.demo._test.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import static org.springframework.test.util.AssertionErrors.assertTrue;


public class ParameterizedDemo {
    @ParameterizedTest
    @ValueSource(strings = { "race car", "radar", "aba" })
    void palindromes(String candidate) {
        assertTrue("ok", isPalindrome(candidate));
    }

    boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < (n/2); ++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }
}

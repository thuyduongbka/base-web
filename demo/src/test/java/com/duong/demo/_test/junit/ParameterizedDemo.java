package com.duong.demo._test.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import static org.springframework.test.util.AssertionErrors.assertTrue;


public class ParameterizedDemo {
    @ParameterizedTest
    @ValueSource(strings = { "race car", "radar", "able was I ere I saw elba" })
    void palindromes(String candidate) {
        assertTrue("ok", candidate.equals(candidate));
    }
}

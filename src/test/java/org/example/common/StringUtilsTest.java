package org.example.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

    @Test
    void testCapitalizeForEmptyString() {
        String result = StringUtils.capitalize("");
        Assertions.assertNotNull(result);
    }

    @Test
    void testCapitalize() {
        String actual = StringUtils.capitalize("lowercase");
        Assertions.assertEquals("Lowercase", actual);
    }
}

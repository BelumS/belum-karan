package org.example.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.common.NumberConstants.*;
import static org.junit.jupiter.api.Assertions.*;

public class NumberConstantsTest {

    @Test
    public void testConstants() {
        assertNotNull(TITLE);
        assertNotNull(INVALID_PRIME);
    }
}

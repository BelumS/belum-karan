package org.example.text.rss;

import org.example.common.TestConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RSSFeederTest {
    private static final String URL = "https://www.vogella.com/article.rss";

    @Test
    void test() {
        String input = URL + System.lineSeparator();
        assertNotNull(RSSFeeder.readRss(TestConstants.testScanner(input)));
    }

    @Test
    @DisplayName("Read RSS throws Exception")
    void testException() {
        assertEquals("", RSSFeeder.readRss(null));
    }

}

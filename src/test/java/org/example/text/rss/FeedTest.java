package org.example.text.rss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class FeedTest {
    private Feed feed;

    @BeforeEach
    void setup() {
        feed = new FeedBuilder()
                .title("Test")
                .link("localhost")
                .language("EN")
                .description("Test")
                .copyRight("Test")
                .publishDate(LocalDate.now().toString())
                .build();
    }

    @Test
    void testConstructor() {
        assertNotNull(feed);
    }

    @Test
    void testTitle() {
        assertNotNull(feed.getTitle());
    }

    @Test
    void testLink() {
        assertNotNull(feed.getLink());
    }

    @Test
    void testLanguage() {
        assertNotNull(feed.getLanguage());
    }

    @Test
    void testDescription() {
        assertNotNull(feed.getDescription());
    }

    @Test
    void testCopyRight() {
        assertNotNull(feed.getCopyRight());
    }

    @Test
    void testPublishDate() {
        assertNotNull(feed.getPublishDate());
    }

    @Test
    void testGetEntries() {
        assertNotNull(feed.getEntries());
    }

    @Test
    void testToString() {
        assertNotNull(feed.toString());
    }

}

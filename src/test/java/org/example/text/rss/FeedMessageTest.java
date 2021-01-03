package org.example.text.rss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class FeedMessageTest {
    private FeedMessage message;

    @BeforeEach
    void setup() {
        message = new FeedMessageBuilder()
                .title("TEST")
                .link("localhost")
                .description("TEST")
                .author("JUnit 5")
                .guid(UUID.randomUUID().toString())
                .build();
    }

    @Test
    void testConstructor() {
        assertNotNull(message);
    }

    @Test
    void testTitle() {
        assertNotNull(message.getTitle());
    }

    @Test
    void testLink() {
        assertNotNull(message.getLink());
    }

    @Test
    void testDescription() {
        assertNotNull(message.getDescription());
    }

    @Test
    void testAuthor() {
        assertNotNull(message.getAuthor());
    }

    @Test
    void testGuid() {
        assertNotNull(message.getGuid());
    }

    @Test
    void testToString() {
        assertNotNull(message.toString());
    }

}

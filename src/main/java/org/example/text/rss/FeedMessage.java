package org.example.text.rss;

import lombok.Getter;

/**
 * Represents one RSS message
 */
@Getter
public class FeedMessage {
    private String title;
    private String description;
    private String link;
    private String author;
    private String guid;

    public FeedMessage(FeedMessageBuilder builder) {
        this.title = builder.getTitle();
        this.description = builder.getDescription();
        this.link = builder.getLink();
        this.author = builder.getAuthor();
        this.guid = builder.getGuid();
    }

    @Override
    public String toString() {
        return "{"
                + "\"title\":\"" + title + "\","
                + "\"description\":\"" + description + "\","
                + "\"link\":\"" + link + "\","
                + "\"author\":\"" + author + "\","
                + "\"guid\":\"" + guid + "\""
                + "}";
    }
}

package org.example.text.rss;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores an RSS Feed
 */
@Getter
class Feed {
    private String title;
    private String link;
    private String description;
    private String language;
    private String copyRight;
    private String publishDate;
    private final List<FeedMessage> entries = new ArrayList<>();

    public Feed(FeedBuilder builder) {
        this.title = builder.getTitle();
        this.link = builder.getLink();
        this.description = builder.getDescription();
        this.language = builder.getLanguage();
        this.copyRight = builder.getCopyRight();
        this.publishDate = builder.getPublishDate();
    }

    @Override
    public String toString() {
        return "{"
                + "\"title\":\"" + title + "\","
                + "\"description\":\"" + description + "\","
                + "\"link\":\"" + link + "\","
                + "\"language\":\"" + language + "\","
                + "\"copyRight\":\"" + copyRight + "\","
                + "\"publishDate\":\"" + publishDate + "\""
                + "}";
    }

}

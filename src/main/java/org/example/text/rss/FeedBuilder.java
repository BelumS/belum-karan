package org.example.text.rss;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Builds an RSS Feed
 */
@NoArgsConstructor
@Getter
public final class FeedBuilder {
    private String title;
    private String link;
    private String description;
    private String language;
    private String copyRight;
    private String publishDate;

    public FeedBuilder title(@NonNull String title) {
        this.title = title;
        return this;
    }

    public FeedBuilder link(@NonNull String link) {
        this.link = link;
        return this;
    }

    public FeedBuilder description(@NonNull String description) {
        this.description = description;
        return this;
    }

    public FeedBuilder language(@NonNull String language) {
        this.language = language;
        return this;
    }

    public FeedBuilder copyRight(@NonNull String copyRight) {
        this.copyRight = copyRight;
        return this;
    }

    public FeedBuilder publishDate(@NonNull String publishDate) {
        this.publishDate = publishDate;
        return this;
    }

    public Feed build() {
        return new Feed(this);
    }

}

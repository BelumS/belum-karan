package org.example.text.rss;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NoArgsConstructor
public final class FeedMessageBuilder {
    private String title;
    private String description;
    private String link;
    private String author;
    private String guid;

    public FeedMessageBuilder title(@NonNull String title) {
        this.title = title;
        return this;
    }

    public FeedMessageBuilder description(@NonNull String description) {
        this.description = description;
        return this;
    }

    public FeedMessageBuilder link(@NonNull String link) {
        this.link = link;
        return this;
    }

    public FeedMessageBuilder author(@NonNull String author) {
        this.author = author;
        return this;
    }

    public FeedMessageBuilder guid(@NonNull String guid) {
        this.guid = guid;
        return this;
    }

    public FeedMessage build() {
        return new FeedMessage(this);
    }
}

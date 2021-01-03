package org.example.text.rss;

import org.example.constants.AppConstants;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Given a link to RSS/Atom Feed, get all posts and display them.
 */
public class RSSFeeder {
    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String CHANNEL = "channel";
    private static final String LANGUAGE = "language";
    private static final String COPYRIGHT = "copyright";
    private static final String LINK = "link";
    private static final String AUTHOR = "author";
    private static final String ITEM = "item";
    private static final String PUB_DATE = "publishDate";
    private static final String GUID = "guid";

    private URL url;

    private RSSFeeder() {
    }

    private RSSFeeder(String url) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readRss(Scanner scanner) {
        try (scanner) {
            System.out.println("Enter a URL: ");
            String url = scanner.nextLine();

            final var feeder = new RSSFeeder(url);
            final var feed = feeder.readFeed();
            final var messages = feed.getEntries();

            System.out.println(feed);
            for (var message : messages) {
                System.out.println(message);
            }
            return messages.toString();
        } catch (Exception e) {
            AppConstants.printError(e);
            return "";
        }
    }

    private Feed readFeed() {
        Feed feed = null;
        try {
            boolean isFeedHeader = true;
            String description = "";
            String title = "";
            String link = "";
            String language = "";
            String copyRight = "";
            String author = "";
            String publishDate = "";
            String guid = "";

            //Create a new factory
            var inputFactory = XMLInputFactory.newInstance();

            //Setup a new eventReader
            var in = read();
            var eventReader = inputFactory.createXMLEventReader(in);

            //read the XML document
            while (eventReader.hasNext()) {
                var event = eventReader.nextEvent();

                if (event.isStartElement()) {
                    String localPart = event.asStartElement().getName().getLocalPart();
                    switch (localPart) {
                        case ITEM:
                            if (isFeedHeader) {
                                isFeedHeader = false;
                                feed = new FeedBuilder()
                                        .title(title)
                                        .link(link)
                                        .description(description)
                                        .copyRight(copyRight)
                                        .publishDate(publishDate)
                                        .build();
                            }
                            event = eventReader.nextEvent();
                            break;
                        case TITLE:
                            title = getCharDate(event, eventReader);
                            break;
                        case DESCRIPTION:
                            description = getCharDate(event, eventReader);
                            break;
                        case LINK:
                            link = getCharDate(event, eventReader);
                            break;
                        case GUID:
                            guid = getCharDate(event, eventReader);
                            break;
                        case LANGUAGE:
                            language = getCharDate(event, eventReader);
                            break;
                        case AUTHOR:
                            author = getCharDate(event, eventReader);
                            break;
                        case PUB_DATE:
                            publishDate = getCharDate(event, eventReader);
                            break;
                        case COPYRIGHT:
                            copyRight = getCharDate(event, eventReader);
                            break;
                    }
                } else if (event.isEndElement()) {
                    if (ITEM.equalsIgnoreCase(event.asEndElement().getName().getLocalPart())) {
                        var message = new FeedMessageBuilder()
                                .author(author)
                                .description(description)
                                .guid(guid)
                                .link(link)
                                .title(title)
                                .build();
                        feed.getEntries().add(message);
                        event = eventReader.nextEvent();
                        continue;
                    }
                }
            }
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        }
        return feed;
    }

    private String getCharDate(XMLEvent event, XMLEventReader eventReader) throws XMLStreamException {
        String result = "";
        event = eventReader.nextEvent();

        if (event instanceof Characters) {
            result = event.asCharacters().getData();
        }
        return result;
    }

    private InputStream read() {
        try {
            return this.url.openStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

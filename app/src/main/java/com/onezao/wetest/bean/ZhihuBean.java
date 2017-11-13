package com.onezao.wetest.bean;

/**
 * Created by zneo on 2017/11/10.
 */

public class ZhihuBean {
    private String title;
    private String link;
    private String description;
    private String dccreator;
    private String pubDate;
    private String guid;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDccreator() {
        return dccreator;
    }

    public void setDccreator(String dccreator) {
        this.dccreator = dccreator;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Override
    public String toString() {
        return "ZhihuBean{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", dccreator='" + dccreator + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", guid='" + guid + '\'' +
                '}';
    }
}

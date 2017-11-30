package com.zenith.livinghistory.api.zenithlivinghistoryapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

import java.io.Serializable;

public class AnnotationBody implements Serializable {

    /*
    * Example:
    *
    * "body": {
    *  "id" : "id prop is used in semantic annotations",
    *   "type" : "TextualBody",
    *   "value" : "<p>Paragraf!</p>",
    *   "format" : "text/html",
    *   "language" : "tr",
    *   "creator": "http://example.net/user2",
    *   "created": "2014-06-02T17:00:00Z"
    * }
    *
    * */


    //region Private Members

    @JsonProperty("@id")
    private String id;

    private String type;

    private String value;

    private String format;

    private String language;

    private String creator;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private DateTime created;

    //endregion

    //region Constructor

    public AnnotationBody() {
    }

    public AnnotationBody(String id, String type, String value, String format, String language, String creator, DateTime created) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.format = format;
        this.language = language;
        this.creator = creator;
        this.created = created;
    }
    //endregion

    //region Getter and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public DateTime getCreated() {
        return created;
    }

    public void setCreated(DateTime created) {
        this.created = created;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    //endregion
}


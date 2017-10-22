package com.zenith.livinghistory.api.zenithlivinghistoryapi.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeId;
import org.joda.time.DateTime;

import java.io.Serializable;

public class Annotation implements Serializable {

    /*
    * Example:
    *
    * {
    *   "@context": "http://www.w3.org/ns/anno.jsonld",
    *   "id": "http://example.org/anno3",
    *   "type": "Annotation",
    *   "creator": "http://example.org/user1",
    *   "created": "2015-01-28T12:00:00Z",
    *   "modified": "2015-01-29T09:00:00Z",
    *   "body": {
    *       "type" : "TextualBody",
    *       "value" : "<p>Paragraf!</p>",
    *       "format" : "text/html",
    *       "language" : "tr",
    *       "creator": "http://example.net/user2",
    *       "created": "2014-06-02T17:00:00Z"
    *   },
    *   "target": {
    *       "id": "http://example.com/image1.jpg#xywh=100,100,300,300",
    *       "type": "Image",
    *       "format": "image/jpeg"
    *   }
    * }
    *
    * */

    @JsonProperty("@context")
    private String context;

    private String id;

    private String type;

    private String creator;

    private DateTime created;

    private DateTime modified;

    private AnnotationBody body;

    private AnnotationTarget target;

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

    public DateTime getModified() {
        return modified;
    }

    public void setModified(DateTime modified) {
        this.modified = modified;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AnnotationBody getBody() {
        return body;
    }

    public void setBody(AnnotationBody body) {
        this.body = body;
    }

    public AnnotationTarget getTarget() {
        return target;
    }

    public void setTarget(AnnotationTarget target) {
        this.target = target;
    }
}

package com.zenith.livinghistory.api.zenithlivinghistoryapi.dto;

import java.io.Serializable;

public class ContentTarget implements Serializable {

    /*
    * Example:
    *
    * "target": {
    *   "id": "http://example.com/image1.jpg#xywh=100,100,300,300",
    *   "type": "Image",
    *   "format": "image/jpeg"
    * }
    *
    * */

    public ContentTarget() {
    }

    public ContentTarget(String id, String type, String format) {
        this.id = id;
        this.type = type;
        this.format = format;
    }

    private String id;

    private String type;

    private String format;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
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
}

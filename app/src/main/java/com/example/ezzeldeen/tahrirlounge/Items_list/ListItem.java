package com.example.ezzeldeen.tahrirlounge.Items_list;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListItem {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("eventName")
    @Expose
    private String eventName;
    @SerializedName("eventImage")
    @Expose
    private String eventImage;
    @SerializedName("eventInstractor")
    @Expose
    private String eventInstractor;
    @SerializedName("eventDetails")
    @Expose
    private String eventDetails;
    @SerializedName("eventDate")
    @Expose
    private String eventDate;

    /**
     * No args constructor for use in serialization
     *
     */
    public ListItem() {
    }

    /**
     *
     * @
     * @param eventDate
     * @param eventInstractor
     * @param eventDetails
     * @param eventImage
     * @param eventName

     */
    public ListItem(String eventName, String eventImage, String eventInstractor, String eventDetails, String eventDate) {
        super();
        this.eventName = eventName;
        this.eventImage = eventImage;
        this.eventInstractor = eventInstractor;
        this.eventDetails = eventDetails;
        this.eventDate = eventDate;

    }

    public long getId() {
        return id;
    }


    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventImage() {
        return eventImage;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }

    public String getEventInstractor() {
        return eventInstractor;
    }

    public void setEventInstractor(String eventInstractor) {
        this.eventInstractor = eventInstractor;
    }

    public String getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }



}
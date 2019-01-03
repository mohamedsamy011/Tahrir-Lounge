package com.example.ezzeldeen.tahrirlounge.Items_list;

/**
 * Created by ezzeldeen on 28/09/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TeamMembersList {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("position")
    @Expose
    private String position;
    @SerializedName("image")
    @Expose
    private String Image;

    /**
     * No args constructor for use in serialization
     *
     */
    public TeamMembersList() {
    }

    /**
     *
     * @param position

     * @param name
     * @param image
     */
    public TeamMembersList( String name, String position, String image) {
        super();
        this.name = name;
        this.position = position;
        this.Image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }



    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        this.Image = image;
    }

}




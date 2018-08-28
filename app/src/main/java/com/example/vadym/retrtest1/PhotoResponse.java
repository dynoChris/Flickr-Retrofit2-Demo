
package com.example.vadym.retrtest1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhotoResponse {

    @SerializedName("photos")
    @Expose
    private Photos photos;

    public class Photos {

        @SerializedName("photo")
        @Expose
        private List<Photo> photo = null;

        public class Photo {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("owner")
            @Expose
            private String owner;
            @SerializedName("secret")
            @Expose
            private String secret;
            @SerializedName("server")
            @Expose
            private String server;
            @SerializedName("farm")
            @Expose
            private int farm;
            @SerializedName("title")
            @Expose
            private String title;
            @SerializedName("ispublic")
            @Expose
            private int ispublic;
            @SerializedName("isfriend")
            @Expose
            private int isfriend;
            @SerializedName("isfamily")
            @Expose
            private int isfamily;
            @SerializedName("url_s")
            @Expose
            private String urlS;
            @SerializedName("height_s")
            @Expose
            private String heightS;
            @SerializedName("width_s")
            @Expose
            private String widthS;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getOwner() {
                return owner;
            }

            public void setOwner(String owner) {
                this.owner = owner;
            }

            public String getSecret() {
                return secret;
            }

            public void setSecret(String secret) {
                this.secret = secret;
            }

            public String getServer() {
                return server;
            }

            public void setServer(String server) {
                this.server = server;
            }

            public int getFarm() {
                return farm;
            }

            public void setFarm(int farm) {
                this.farm = farm;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getIspublic() {
                return ispublic;
            }

            public void setIspublic(int ispublic) {
                this.ispublic = ispublic;
            }

            public int getIsfriend() {
                return isfriend;
            }

            public void setIsfriend(int isfriend) {
                this.isfriend = isfriend;
            }

            public int getIsfamily() {
                return isfamily;
            }

            public void setIsfamily(int isfamily) {
                this.isfamily = isfamily;
            }

            public String getUrlS() {
                return urlS;
            }

            public void setUrlS(String urlS) {
                this.urlS = urlS;
            }

            public String getHeightS() {
                return heightS;
            }

            public void setHeightS(String heightS) {
                this.heightS = heightS;
            }

            public String getWidthS() {
                return widthS;
            }

            public void setWidthS(String widthS) {
                this.widthS = widthS;
            }

        }

        public List<Photo> getPhoto() {
            return photo;
        }

        public void setPhoto(List<Photo> photo) {
            this.photo = photo;
        }

    }


    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

}

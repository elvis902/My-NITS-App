package com.example.mynitsapp.ui.home;

public class SliderItems {
    String imageUrl, imageDescription;

    public SliderItems(String imageUrl, String imageDescription) {
        this.imageUrl = imageUrl;
        this.imageDescription = imageDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }
}

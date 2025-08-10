package DocumentManagementSystem;

public class ImageElement extends DocumentElement {
    private String imageUrl;
    private String altText;

    public ImageElement(String imageUrl, String altText) {
        this.imageUrl = imageUrl;
        this.altText = altText;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    @Override
    public void render() {
        System.out.println("Rendering image element with URL: " + imageUrl + " and alt text: " + altText);
    }
    
}

package DocumentManagementSystem;

public class TextElement extends DocumentElement {
    private String text;

    public TextElement(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void render() {
        System.out.println("Rendering text element: " + text);
    }
    
}

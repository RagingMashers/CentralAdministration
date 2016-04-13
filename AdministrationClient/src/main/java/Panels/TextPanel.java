package Panels;

import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

/**
 * Created by frank on 06/04/2016.
 */
public class TextPanel extends Panel implements IPanel {
    private TextArea textArea = new TextArea();

    /**
     * Constructor of a text panel
     * @param headerText the header text of this panel
     */
    public TextPanel(String headerText, String contentTexts, VBox parentBox) {
        // Set the header text
        setHeaderText(headerText);
        setTextAreaText(contentTexts);

        textArea.setLayoutY(20);
        textArea.setPrefWidth(parentBox.getPrefWidth());
        textArea.setEditable(false);
        textArea.setWrapText(true);

        AddNode(textArea);
    }

    /**
     * Get the text are of the panel
     * @return the textarea
     */
    public TextArea getTextArea() {
        return textArea;
    }

    /**
     * Set the text area of the panel
     * @param textArea the text area
     */
    public void setTextArea(TextArea textArea) {
        this.textArea = textArea;
    }

    public void setTextAreaText(String text) {
        textArea.setText(text);
    }

    /**
     * Get the parent node of the panel
     * @return the node of the panel
     */
    @Override
    public Node getParentNode() {
        return getBackground();
    }
}

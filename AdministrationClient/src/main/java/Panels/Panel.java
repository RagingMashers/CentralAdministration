package Panels;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Created by frank on 06/04/2016.
 */
public abstract class Panel {
    private Pane background;
    private Label header;

    // Panel settings
    private final String BACKGROUNDCOLOR = "#477cd4";
    private final String HEADERCOLOR = "#f2f2f2";


    /**
     * The base constructor of the panel
     */
    public Panel() {
        // Add the background of the panel
        background = new Pane();
        background.setStyle("-fx-background-color: " + BACKGROUNDCOLOR);

        // Add the header to the panel
        header = new Label();
        header.setStyle("-fx-font-weight: bold");
        header.setTextFill(Color.web(HEADERCOLOR));
        header.setLayoutX(10);

        // Add the label to the panel
        AddNode(header);

    }

    /**
     * Add the node to the panel
     * @param node the node that will be added to the panel
     */
    public void AddNode(Node node) {
        background.getChildren().add(node);
    }

    /**
     * Get the background of the panel
     * @return the background
     */
    public Pane getBackground() {
        return background;
    }

    /**
     * Set the background of the panel
     * @param background the background
     */
    public void setBackground(Pane background) {
        this.background = background;
    }

    /**
     * Get the header of the panel
     * @return the header of the panel
     */
    public Label getHeader() {
        return header;
    }

    /**
     * Set the header of the panel
     * @param header the header of the panel
     */
    public void setHeader(Label header) {
        this.header = header;
    }

    /**
     * Set the text of the header of the panel
     * @param text the text that will become the header text
     */
    public void setHeaderText(String text) {
        header.setText(text);
    }
}

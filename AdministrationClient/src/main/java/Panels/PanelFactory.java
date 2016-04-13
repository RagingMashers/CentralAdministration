package Panels;

import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

/**
 * Created by frank on 06/04/2016.
 */
public class PanelFactory {
    public enum Type {text, image};


    /**
     * Get a panel from the panel factory
     * @param type the type of the panel
     * @param headerText the header text of the panel
     * @param image the image that will be displayed
     * @param parentBox the vbox where the panel belongs to
     * @return the panel
     */
    public static IPanel getPanel(Type type, String headerText, Image image, VBox parentBox) {
        switch (type) {
            case image:
                return new ImagePanel(image, headerText, parentBox);
            default:
                return null;
        }
    }

    /**
     * Get a panel from the panel factory
     * @param type the type of the panel
     * @param headerText the header text of the panel
     * @return the panel
     */
    public static IPanel getPanel(Type type, String headerText, String contentText, VBox parentBox) {
        switch (type) {
            case text:
                return new TextPanel(headerText, contentText, parentBox);
            default:
                return null;
        }
    }

}

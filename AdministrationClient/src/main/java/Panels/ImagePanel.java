package Panels;


import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Created by frank on 06/04/2016.
 */
public class ImagePanel extends Panel implements IPanel {
    private ImageView image;

    /**
     * Constructor of the imagepanel
     * @param img the image that will be set
     * @param headerText the text that will be displayed at the header
     * @param parentBox the vbox where the panel belongs to
     */
    public ImagePanel(Image img,String headerText, VBox parentBox, int id) {
        // Set the header text
        setHeaderText(headerText);
        setId(id);

        // Create the image view
        ImageView image = new ImageView(img);

        // The imageview settings
        image.setY(30);
        image.fitWidthProperty().bind(parentBox.widthProperty());
        image.setPreserveRatio(true);
        image.setSmooth(true);
        image.setCache(true);

        // Add the imageview to the panel
        AddNode(image);
    }

    /**
     * Get the image view
     * @return the image view
     */
    public ImageView getImage() {
        return image;
    }

    /**
     * Set the imageview
     * @param image the image
     */
    public void setImage(ImageView image) {
        this.image = image;
    }

    /**
     * get the parent node
     * @return the node that belongs to the parent
     */
    @Override
    public Node getParentNode() {
        return getBackground();
    }

    @Override
    public boolean isSelected() {
        return getSelected();
    }
}

package Panels;

import javafx.scene.Node;

/**
 * Created by frank on 06/04/2016.
 */
public interface IPanel {

    Node getParentNode();
    boolean isSelected();
    int getId();
    void setSelectedValue(boolean value);
}

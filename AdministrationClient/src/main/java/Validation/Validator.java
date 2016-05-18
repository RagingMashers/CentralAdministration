package Validation;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.base.ValidatorBase;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.io.File;

/**
 * Created by MBoon on 6-4-2016.
 * Use this class if you want to add validators to any control
 * Add custum validators to the "Validators" folder
 */
public class Validator {
    // Image for the error message
    private ImageView imageView(){
        Image image = new Image(String.valueOf(getClass().getClassLoader().getResource("warning.png")));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(20.0);
        imageView.setFitWidth(20.0);
        return imageView;
    }

    /**
     * Default method for creating an error message
     * @param errorMessage The string that tells the error message
     * @param validatorBase The type of validation
     * @return The validator that can be applied to controls
     */
    private ValidatorBase validatorForTextbox(String errorMessage, ValidatorBase validatorBase) {
        validatorBase.setMessage(errorMessage);
        validatorBase.setIcon(imageView());
        return validatorBase;
    }

    public JFXTextField setTextBoxStyles(JFXTextField jfxTextField, String fieldName, String errorText, ValidatorBase validatorBase, boolean setEvent){
        jfxTextField.setStyle("-fx-label-float:true;");
        jfxTextField.setPromptText(fieldName);
        jfxTextField.getValidators().add(validatorForTextbox(errorText,validatorBase));
        if(setEvent){
            jfxTextField.focusedProperty().addListener((o,oldVal,newVal)->{
                if(!newVal)jfxTextField.validate();
            });
        }
        return jfxTextField;
    }

    public JFXTextArea setTextAreaStyles(JFXTextArea jfxTextArea, String fieldName, String errorText, ValidatorBase validatorBase){
        jfxTextArea.setStyle("-fx-label-float:true;");
        jfxTextArea.setPromptText(fieldName);
        jfxTextArea.getValidators().add(validatorForTextbox(errorText,validatorBase));
        return jfxTextArea;
    }
}

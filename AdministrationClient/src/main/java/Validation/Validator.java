package Validation;

import com.jfoenix.validation.base.ValidatorBase;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.io.File;

/**
 * Created by MBoon on 6-4-2016.
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
    public ValidatorBase validatorForTextbox(String errorMessage, ValidatorBase validatorBase){
        ValidatorBase validator = validatorBase;
        validator.setMessage(errorMessage);
        validator.setIcon(imageView());
        return validator;
    }
}

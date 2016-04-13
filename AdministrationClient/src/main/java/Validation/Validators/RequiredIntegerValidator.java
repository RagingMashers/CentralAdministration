package Validation.Validators;

import com.jfoenix.validation.base.ValidatorBase;
import javafx.scene.control.TextInputControl;

/**
 * Created by MBoon on 13-4-2016.
 */
public class RequiredIntegerValidator extends ValidatorBase {
    public RequiredIntegerValidator(){}

    @Override
    protected void eval() {
        if(this.srcControl.get() instanceof TextInputControl) {
            this.evalTextInputField();
        }
    }

    protected void evalTextInputField() {
        TextInputControl textField = (TextInputControl)this.srcControl.get();

        String value = textField.getText();
        if(value.matches("[0-9]{1,3}"))this.hasErrors.set(false);
        else this.hasErrors.set(true);
    }

}

package Validation.Validators;

import com.jfoenix.validation.base.ValidatorBase;
import javafx.scene.control.TextInputControl;

/**
 * Created by MBoon on 6-4-2016.
 */
public class IntegerValidator extends ValidatorBase {
    public IntegerValidator(){}

    @Override
    protected void eval() {
        if(this.srcControl.get() instanceof TextInputControl) {
            this.evalTextInputField();
        }
    }

    protected void evalTextInputField() {
        TextInputControl textField = (TextInputControl)this.srcControl.get();

        String value = textField.getText();
        if(value.matches("[0-9]{1,3}") || value.isEmpty())this.hasErrors.set(false);
        else this.hasErrors.set(true);
    }
}

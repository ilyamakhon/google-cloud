package bean;

import java.util.HashMap;

public class ValidationFormWrapper {
    private HashMap<String, ValidationFormModel> validationFormCases = new HashMap<>();

    public ValidationFormWrapper() {
    }

    public ValidationFormWrapper(HashMap<String, ValidationFormModel> validationFormCases) {
        this.validationFormCases = validationFormCases;
    }

    public HashMap<String, ValidationFormModel> getValidationFormCases() {
        return validationFormCases;
    }

    public void setValidationFormCases(HashMap<String, ValidationFormModel> validationFormCases) {
        this.validationFormCases = validationFormCases;
    }

    public void addValidationFormCase(String validationFormCaseID, ValidationFormModel validationFormModel) {
        validationFormCases.put(validationFormCaseID, validationFormModel);
    }
}

package bean;

import java.util.HashMap;

public class ValidationFormWrapper {
    private HashMap<String, ValidationFormCase> validationFormCases = new HashMap<>();

    public ValidationFormWrapper() {
    }

    public ValidationFormWrapper(HashMap<String, ValidationFormCase> validationFormCases) {
        this.validationFormCases = validationFormCases;
    }

    public HashMap<String, ValidationFormCase> getValidationFormCases() {
        return validationFormCases;
    }

    public void setValidationFormCases(HashMap<String, ValidationFormCase> validationFormCases) {
        this.validationFormCases = validationFormCases;
    }

    public void addValidationFormCase(String validationFormCaseID, ValidationFormCase validationFormCase) {
        validationFormCases.put(validationFormCaseID, validationFormCase);
    }
}

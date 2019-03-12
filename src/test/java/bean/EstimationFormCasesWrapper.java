package bean;

import java.util.HashMap;

public class EstimationFormCasesWrapper {
    private HashMap<String, EstimationFormModel> estimationFormCases = new HashMap<>();

    public EstimationFormCasesWrapper() {

    }

    public EstimationFormCasesWrapper(HashMap<String, EstimationFormModel> estimationFormCases) {
        this.estimationFormCases = estimationFormCases;
    }

    public void addEstimationCase(String estimationCaseID, EstimationFormModel estimationFormModel) {
        estimationFormCases.put(estimationCaseID, estimationFormModel);
    }

    public HashMap<String, EstimationFormModel> getEstimationFormCases() {
        return estimationFormCases;
    }

    public void setEstimationFormCases(HashMap<String, EstimationFormModel> estimationFormCases) {
        this.estimationFormCases = estimationFormCases;
    }
}

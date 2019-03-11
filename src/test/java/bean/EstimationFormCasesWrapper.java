package bean;

import java.util.HashMap;

public class EstimationFormCasesWrapper {
    private HashMap<String, EstimationFormModel> estimationFormCases = new HashMap<>();

    public EstimationFormCasesWrapper() {

    }

    public EstimationFormCasesWrapper(HashMap<String, EstimationFormModel> estimationFormCases) {
        this.estimationFormCases = estimationFormCases;
    }

    public void addEstimationCase(String caseID, EstimationFormModel estimationFormModel) {
        estimationFormCases.put(caseID, estimationFormModel);
    }

    public HashMap<String, EstimationFormModel> getEstimationFormCases() {
        return estimationFormCases;
    }

    public void setEstimationFormCases(HashMap<String, EstimationFormModel> estimationFormCases) {
        this.estimationFormCases = estimationFormCases;
    }
}

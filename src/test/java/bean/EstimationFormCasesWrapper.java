package bean;

import java.util.HashMap;

public class EstimationFormCasesWrapper {
    private HashMap<String, EstimationFormCase> estimationFormCases = new HashMap<>();

    public EstimationFormCasesWrapper() {

    }

    public EstimationFormCasesWrapper(HashMap<String, EstimationFormCase> estimationFormCases) {
        this.estimationFormCases = estimationFormCases;
    }

    public void addEstimationCase(String estimationCaseID, EstimationFormCase estimationFormCase) {
        estimationFormCases.put(estimationCaseID, estimationFormCase);
    }

    public HashMap<String, EstimationFormCase> getEstimationFormCases() {
        return estimationFormCases;
    }

    public void setEstimationFormCases(HashMap<String, EstimationFormCase> estimationFormCases) {
        this.estimationFormCases = estimationFormCases;
    }
}

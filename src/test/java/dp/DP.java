package dp;

import bean.EstimationFormCase;
import bean.ValidationFormCase;
import csvparser.CSVParser;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.HashMap;

public class DP {

    private CSVParser csvParser = CSVParser.getInstance();

    @DataProvider
    public Object[][] dataProvider(Method method) {
        HashMap<String, EstimationFormCase> estimationFormCases = csvParser.parseEstimationCases();
        HashMap<String, ValidationFormCase> validationFormModelCases = csvParser.parseValidationFromCases();

        switch (method.getName()) {
            case "testProductEstimation":
                return new Object[][]{
                        { estimationFormCases.get("1") },
                        { estimationFormCases.get("2") }
                };
            case "testEstimationFormValidation":
                return new Object[][] {
                        { validationFormModelCases.get("1") },
                        { validationFormModelCases.get("2") }
                };
        }
        return new Object[][]{};
    }

}

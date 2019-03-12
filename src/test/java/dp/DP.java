package dp;

import bean.EstimationFormModel;
import bean.ValidationFormModel;
import csvparser.CSVParser;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.HashMap;

public class DP {

    private CSVParser csvParser = CSVParser.getInstance();

    @DataProvider
    public Object[][] dataProvider(Method method) {
        HashMap<String, EstimationFormModel> estimationFormCases = csvParser.parseEstimationCases();
        HashMap<String, ValidationFormModel> validationFormModelCases = csvParser.parseValidationFromCases();

        switch (method.getName()) {
            case "testProductEstimation":
                return new Object[][]{
                        {
                            estimationFormCases.get("1")
                        }
                };
            case "testEstimationFormValidation":
                return new Object[][] {
                        {
                            validationFormModelCases.get("1")
                        }
                };
        }
        return new Object[][]{};
    }

}

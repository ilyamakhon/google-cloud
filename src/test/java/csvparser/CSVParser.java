package csvparser;

import bean.EstimationFormModel;
import bean.ValidationFormModel;

import java.util.HashMap;

public interface CSVParser {

    static CSVParser getInstance() {
        return CSVParserImpl.getInstance();
    }

    HashMap<String, EstimationFormModel> parseEstimationCases();

    HashMap<String, ValidationFormModel> parseValidationFromCases();
}

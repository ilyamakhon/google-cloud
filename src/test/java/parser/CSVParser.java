package parser;

import bean.EstimationFormCase;
import bean.ValidationFormCase;

import java.util.HashMap;

public interface CSVParser {

    static CSVParser getInstance() {
        return CSVParserImpl.getInstance();
    }

    HashMap<String, EstimationFormCase> parseEstimationCases();

    HashMap<String, ValidationFormCase> parseValidationFromCases();
}

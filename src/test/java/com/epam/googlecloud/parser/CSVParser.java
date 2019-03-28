package com.epam.googlecloud.parser;

import com.epam.googlecloud.bean.EstimationFormCase;
import com.epam.googlecloud.bean.ValidationFormCase;

import java.util.HashMap;

public interface CSVParser {

    static CSVParser getInstance() {
        return CSVParserImpl.getInstance();
    }

    HashMap<String, EstimationFormCase> parseEstimationCases();

    HashMap<String, ValidationFormCase> parseValidationFromCases();
}

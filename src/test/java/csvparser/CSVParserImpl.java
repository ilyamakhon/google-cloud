package csvparser;

import bean.EstimationFormCase;
import bean.EstimationFormCasesWrapper;
import bean.ValidationFormCase;
import bean.ValidationFormWrapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class CSVParserImpl implements CSVParser {

    private static final CSVParserImpl INSTANCE = new CSVParserImpl();
    private EstimationFormCasesWrapper estimationFormCasesWrapper = new EstimationFormCasesWrapper();
    private ValidationFormWrapper validationFormWrapper = new ValidationFormWrapper();

    private final static String ESTIMATION_CASES_URL = "C:\\Users\\ilya_makhon\\Desktop\\cases.csv";
    private final static String VALIDATION_CASES_URL = "C:\\Users\\ilya_makhon\\Desktop\\validation.csv";
    private final static String[] ESTIMATION_CASES_HEADERS = {
            "Number Of Instances",
            "Operating system and software",
            "VM Class", "Instance type",
            "Add Gpu", "Number of GPUs",
            "GPU type", "Local SSD",
            "Datacenter Location",
            "Commitment term"
    };

    private final static String[] VALIDATION_FORM_HEADERS = {
            "validationFormCaseID",
            "VM class", "Instance type",
            "Region", "Total available local SSD space",
            "Commitment term"
    };

    public static CSVParserImpl getInstance() {
        return INSTANCE;
    }

    private CSVParserImpl() {

    }

    @Override
    public HashMap<String, EstimationFormCase> parseEstimationCases() {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(ESTIMATION_CASES_URL));
            org.apache.commons.csv.CSVParser csvParser = new org.apache.commons.csv.CSVParser(reader, CSVFormat.DEFAULT.withHeader(ESTIMATION_CASES_HEADERS).withFirstRecordAsHeader());

            for (CSVRecord csvRecord : csvParser) {

                EstimationFormCase estimationFormCase = new EstimationFormCase(
                        csvRecord.get("Number of instances"),
                        csvRecord.get("Operating system and software"),
                        csvRecord.get("VM Class"),
                        csvRecord.get("Instance type"),
                        csvRecord.get("Add GPU"),
                        csvRecord.get("Number of GPUs"),
                        csvRecord.get("GPU type"),
                        csvRecord.get("Local SSD"),
                        csvRecord.get("Datacenter Location"),
                        csvRecord.get("Commitment term")
                );

                estimationFormCasesWrapper.addEstimationCase(csvRecord.get("estimationCaseID"), estimationFormCase);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return estimationFormCasesWrapper.getEstimationFormCases();
    }

    @Override
    public HashMap<String, ValidationFormCase> parseValidationFromCases() {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(VALIDATION_CASES_URL));
            org.apache.commons.csv.CSVParser csvParser = new org.apache.commons.csv.CSVParser(reader, CSVFormat.DEFAULT.withHeader(VALIDATION_FORM_HEADERS).withFirstRecordAsHeader());

            for (CSVRecord csvRecord : csvParser) {
                ValidationFormCase validationFormCase = new ValidationFormCase(
                        csvRecord.get("VM class"),
                        csvRecord.get("Instance type"),
                        csvRecord.get("Region"),
                        csvRecord.get("Total available local SSD space"),
                        csvRecord.get("Commitment term"),
                        csvRecord.get("Total estimated cost")
                );

                validationFormWrapper.addValidationFormCase(csvRecord.get("validationFormCaseID"), validationFormCase);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return validationFormWrapper.getValidationFormCases();
    }
}
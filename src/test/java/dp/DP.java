package dp;

import bean.EstimationFormCasesWrapper;
import bean.EstimationFormModel;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class DP {

    private EstimationFormCasesWrapper estimationFormCasesWrapper;
    private final static String CASES_IN_CSV_URL = "C:\\Users\\ilya_makhon\\Desktop\\cases.csv";
    private final static String[] HEADERS = {
            "Number Of Instances",
            "Operating system and software",
            "VM Class", "Instance type",
            "Add Gpu", "Number of GPUs",
            "GPU type", "Local SSD",
            "Datacenter Location",
            "Commitment term"
    };

    private HashMap<String, EstimationFormModel> parseEstimationCasesFromCSV() {
        try {
            estimationFormCasesWrapper = new EstimationFormCasesWrapper();
            BufferedReader reader = Files.newBufferedReader(Paths.get(CASES_IN_CSV_URL));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(HEADERS).withFirstRecordAsHeader());

            for (CSVRecord csvRecord : csvParser) {

                EstimationFormModel estimationFormModel = new EstimationFormModel(
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

                estimationFormCasesWrapper.addEstimationCase(csvRecord.get("CaseID"), estimationFormModel);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return estimationFormCasesWrapper.getEstimationFormCases();
    }

    @DataProvider
    public Object[][] dataProvider(Method method) {
        HashMap<String, EstimationFormModel> estimationFormCases = parseEstimationCasesFromCSV();

        switch (method.getName()) {
            case "testProductEstimation":
                return new Object[][]{
                        {estimationFormCases.get("1") }
                };

        }
        return new Object[][]{};
    }

}

package rahulshettyacademy.date;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReader {
    public List<HashMap<String, String>> getJsaonDataToMap() throws IOException {
        String jsonContetnt = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "src/test/java/rahulshettyacademy/date/PurchaseOrder.json"),
                StandardCharsets.UTF_8);
        //String to HashMap Jackson Databind
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonContetnt, new TypeReference<>() {
        });


    }
}

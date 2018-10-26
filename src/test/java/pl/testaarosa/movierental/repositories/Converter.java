package pl.testaarosa.movierental.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Converter<T> {

    public String jsonInString(T object) {

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";

        try {
            jsonInString = mapper.writeValueAsString(object);
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonInString;
    }
}

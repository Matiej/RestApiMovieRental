package pl.testaarosa.movierental.cfg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OmbdapiConfig {

    @Value("${ombd.api.endpoint.prod}")
    private String ombdEndPoint;
    @Value("${ombd.app.key}")
    private String ombdKey;

    public String getOmbdEndPoint() {
        return ombdEndPoint;
    }

    public String getOmbdKey() {
        return ombdKey;
    }
}

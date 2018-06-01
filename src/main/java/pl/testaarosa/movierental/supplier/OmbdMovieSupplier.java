package pl.testaarosa.movierental.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import pl.testaarosa.movierental.cfg.OmbdapiConfig;

import java.net.URI;

@Service
public class OmbdMovieSupplier {

    @Autowired
    private OmbdapiConfig ombdapiConfig;

    public URI OmbdSupplierSource(int page, String title){
        return UriComponentsBuilder.fromHttpUrl(ombdapiConfig.getOmbdEndPoint())
                .queryParam("s",title)
                .queryParam("type","movie")
                .queryParam("page", page)
                .queryParam("apikey", ombdapiConfig.getOmbdKey())
                .build()
                .encode()
                .toUri();
    }

    public URI OmbdSupplierDetails(String movieId){
        return UriComponentsBuilder.fromHttpUrl(ombdapiConfig.getOmbdEndPoint())
                .queryParam("i",movieId)
                .queryParam("plot","full")
                .queryParam("apikey", ombdapiConfig.getOmbdKey())
                .build()
                .encode()
                .toUri();
    }
}

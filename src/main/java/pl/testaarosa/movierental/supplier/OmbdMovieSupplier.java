package pl.testaarosa.movierental.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import pl.testaarosa.movierental.cfg.OmbdApiConfig;

import java.net.URI;

@Service
public class OmbdMovieSupplier {

    @Autowired
    private OmbdApiConfig ombdApiConfig;

    public URI OmbdSupplierSource(int page, String title){
        return UriComponentsBuilder.fromHttpUrl(ombdApiConfig.getOmbdEndPoint())
                .queryParam("s",title)
                .queryParam("type","movie")
                .queryParam("page", page)
                .queryParam("apikey", ombdApiConfig.getOmbdKey())
                .build()
                .encode()
                .toUri();
    }

    public URI OmbdSupplierDetails(String movieId){
        return UriComponentsBuilder.fromHttpUrl(ombdApiConfig.getOmbdEndPoint())
                .queryParam("i",movieId)
                .queryParam("plot","full")
                .queryParam("apikey", ombdApiConfig.getOmbdKey())
                .build()
                .encode()
                .toUri();
    }
}

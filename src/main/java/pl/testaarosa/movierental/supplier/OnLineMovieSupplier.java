package pl.testaarosa.movierental.supplier;

import org.springframework.stereotype.Service;

@Service
public class OnLineMovieSupplier {

    //TODO URI url = UriComponetnsBuilder - zrobić zrpbić omdbapi supplier i wspólne dla online i blue
    public String OnlineSupplierSource(int page, String title){
        return "http://www.omdbapi.com/?s="+title+"&type=movie&&page="+page+"&apikey=701de894";
    }

    public String OnLineSourceDetail(String movieId){
        return "http://www.omdbapi.com/?i="+movieId+"&plot=full&apikey=701de894";
    }
}

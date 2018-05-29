package pl.testaarosa.movierental.supplier;

import org.springframework.stereotype.Service;

@Service
public class BlueRayMovieSupplier {
//TODO URI url = UriComponetnsBuilder - zrobić
    public String BlueRaySupplierSource(int page, String title){
        return "http://www.omdbapi.com/?s="+title+"&type=movie&&page="+page+"&apikey=701de894";
    }

    public String BlueRaySourceDetail(String movieId){
        return "http://www.omdbapi.com/?i="+movieId+"&plot=full&apikey=701de894";
    }
}

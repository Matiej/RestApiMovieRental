package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.DvdMovie;
import pl.testaarosa.movierental.domain.dto.OneDvdDto;
import pl.testaarosa.movierental.mapper.DvdMovieMapper;
import pl.testaarosa.movierental.supplier.DvdMovieSupplier;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


@Service
public class DvdMovieRetriver {

    @Autowired
    private DvdMovieSupplier dvdMovieSupplier;
    @Autowired
    private DvdMovieMapper dvdMovieMapper;

    public List<DvdMovie> DvdFillStructure() throws IOException, URISyntaxException {
        List<DvdMovie> dvdMovies = new ArrayList<>();
        List<String> lines = dvdMovieSupplier.DvdSupplierSource();
        lines.remove(0);
        lines.forEach(l-> {
            String[] value = l.split("\t");
            OneDvdDto oneDvdDto = new OneDvdDto.Builder()
                    .movieId(value[0])
                    .title(value[1])
                    .countryOfOrigin(value[2])
                    .filmGenre(value[3])
                    .price(Double.parseDouble(value[4]))
                    .build();
            dvdMovies.add(dvdMovieMapper.mapToDvdMovie(oneDvdDto));
        });
        return dvdMovies;
    }


}

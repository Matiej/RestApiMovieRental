package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.dto.DvdMovieDto;
import pl.testaarosa.movierental.supplier.DvdMovieSupplier;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


@Service
public class DvdMovieRetriver {
    @Autowired
    private DvdMovieSupplier dvdMovieSupplier = new DvdMovieSupplier();

    public List<DvdMovieDto> DvdFillStructure() throws IOException, URISyntaxException {
        List<DvdMovieDto> dvdMovieDtos = new ArrayList<>();
        List<String> lines = dvdMovieSupplier.DvdSupplierSource();
        lines.remove(0);
        for (String s : lines) {
            String[] value = s.split("\t");
            DvdMovieDto movieOne = new DvdMovieDto.Builder()
                    .movieId(value[0])
                    .title(value[1])
                    .countryOfOrigin(value[2])
                    .filmGenre(value[3])
                    .price(Double.parseDouble(value[4]))
                    .build();
            dvdMovieDtos.add(movieOne);
        }
        return dvdMovieDtos;
    }


}

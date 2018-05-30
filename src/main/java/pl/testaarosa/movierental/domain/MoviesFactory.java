package pl.testaarosa.movierental.domain;

public class MoviesFactory {
    public static final String BLURAYMOIVE = "BLURAYMOVIE";
    public static final String DVDMOIVE = "DVDMOIVE";
    public static final String ONLINEMOIVE = "ONLINEMOIVE";

    public final Movies makeMovie(final String movieClass) {
        switch (movieClass) {
            case BLURAYMOIVE:
//                return new BlueRayMovie();
            case DVDMOIVE:
                return new DvdMovie();
            default:
                return null;
        }
    }
}

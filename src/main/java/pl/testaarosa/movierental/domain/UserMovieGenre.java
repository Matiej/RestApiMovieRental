package pl.testaarosa.movierental.domain;

public enum UserMovieGenre {
    COMEDY("comedy"),
    SCI_FI("sci-fi"),
    HORROR("horro"),
    THILER("thiler"),
    ACTION("action"),
    ROMANCE("romance"),
    DRAMA("drama"),
    CRIME("crime"),
    ADVENTURE("adventure"),
    FANTASY("fantasy");

    private String name;

    UserMovieGenre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

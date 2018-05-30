package pl.testaarosa.movierental.domain;

public enum  UserGender {

    FEMALE("female"),
    MALE("male"),
    NOTSURE("notsure");

    private String name;

    UserGender(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

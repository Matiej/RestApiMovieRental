//package pl.testaarosa.movierental.domain;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "WISH_LIST")
//public class MoviesWish {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String supId;
//    private String title;
//    private String filmGenre;
//    private String poster;
//    private String supplier;
//
//    public MoviesWish() {
//    }
//
//    public MoviesWish(String supId, String title, String filmGenre, String poster, String supplier) {
//        this.supId = supId;
//        this.title = title;
//        this.filmGenre = filmGenre;
//        this.poster = poster;
//        this.supplier = supplier;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getSupId() {
//        return supId;
//    }
//
//    public void setSupId(String supId) {
//        this.supId = supId;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getFilmGenre() {
//        return filmGenre;
//    }
//
//    public void setFilmGenre(String filmGenre) {
//        this.filmGenre = filmGenre;
//    }
//
//    public String getPoster() {
//        return poster;
//    }
//
//    public void setPoster(String poster) {
//        this.poster = poster;
//    }
//
//    public String getSupplier() {
//        return supplier;
//    }
//
//    public void setSupplier(String supplier) {
//        this.supplier = supplier;
//    }
//
//    @Override
//    public String toString() {
//        return "MoviesWish{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", filmGenre='" + filmGenre + '\'' +
//                ", poster='" + poster + '\'' +
//                ", supplier='" + supplier + '\'' +
//                '}';
//    }
//}

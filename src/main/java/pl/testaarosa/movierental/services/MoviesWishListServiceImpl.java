//package pl.testaarosa.movierental.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import pl.testaarosa.movierental.domain.MoviesWish;
//import pl.testaarosa.movierental.repositories.MoviesWishListRepository;
//
//import java.util.List;
//
//@Service
//public class MoviesWishListServiceImpl implements MoviesWishListService{
//    @Autowired
//    private MoviesWishListRepository wishListRepository;
//
//    @Override
//    public List<MoviesWish> findAllBlueRay() {
//        return wishListRepository.findAllBlueRay();
//    }
//
//    @Override
//    public void addWish(MoviesWish moviesWish) {
//        wishListRepository.save(moviesWish);
//    }
//
//    @Override
//    public void delWish(Long id) {
//        wishListRepository.delete(id);
//    }
//}

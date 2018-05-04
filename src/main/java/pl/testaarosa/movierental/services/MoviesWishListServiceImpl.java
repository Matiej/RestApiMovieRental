package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.MoviesWishList;
import pl.testaarosa.movierental.repositories.MoviesWishListRepository;

import java.util.List;

@Service
public class MoviesWishListServiceImpl implements MoviesWishListService{
    @Autowired
    private MoviesWishListRepository wishListRepository;

    @Override
    public List<MoviesWishList> findAll() {
        return wishListRepository.findAll();
    }

    @Override
    public void addWish(MoviesWishList moviesWishList) {
        wishListRepository.save(moviesWishList);
    }

    @Override
    public void delWish(Long id) {
        wishListRepository.delete(id);
    }
}

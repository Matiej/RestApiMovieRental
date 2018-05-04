package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.UserMovie;
import pl.testaarosa.movierental.repositories.UserMovieRepository;

import java.util.List;

@Service
public class UserMovieServiceImpl implements UserMovieService {
    @Autowired
    private UserMovieRepository userMovieRepository;

    @Override
    public List<UserMovie> findAll() {
        return userMovieRepository.findAll();
    }

    @Override
    public UserMovie finaOne(Long id) {
        return userMovieRepository.findById(id);
    }

    @Override
    public void add(UserMovie userMovie) {
        userMovieRepository.save(userMovie);
    }

    @Override
    public void delete(Long id) {
        userMovieRepository.delete(id);
    }

    @Override
    public List<UserMovie> findAllByTitleContaining(String title) {
        return userMovieRepository.findAllByTitleContaining(title);
    }
}

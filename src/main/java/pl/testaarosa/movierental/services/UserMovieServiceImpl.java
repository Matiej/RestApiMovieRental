package pl.testaarosa.movierental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.testaarosa.movierental.domain.UserMovie;
import pl.testaarosa.movierental.domain.UserMovieDetails;
import pl.testaarosa.movierental.form.UserMovieForm;
import pl.testaarosa.movierental.mapper.UserMovieFormMapper;
import pl.testaarosa.movierental.repositories.UserMovieRepository;

import java.util.List;

@Service
public class UserMovieServiceImpl implements UserMovieService {
    @Autowired
    private UserMovieRepository userMovieRepository;
    @Autowired
    private UserMovieFormMapper userMovieFormMapper;

    @Override
    public List<UserMovie> findAll() {
        return userMovieRepository.findAll();
    }

    @Override
    public UserMovie finaOne(Long id) {
        return userMovieRepository.findById(id);
    }

    @Override
    public void add(UserMovieForm movieForm) {
        UserMovie userMovie1 = userMovieFormMapper.mapToUserMovie(movieForm);
        UserMovieDetails details = userMovieFormMapper.mapToUserMovieDetails(movieForm);
        userMovie1.setUserMovieDetails(details);
        userMovie1.getUserMovieDetails().setUserMovie(userMovie1);
        userMovieRepository.save(userMovie1);
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

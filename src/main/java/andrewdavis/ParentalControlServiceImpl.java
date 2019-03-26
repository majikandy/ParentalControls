package andrewdavis;

public class ParentalControlServiceImpl implements ParentalControlService {
    private MovieService movieService;

    public ParentalControlServiceImpl(MovieService movieService) {
        this.movieService = movieService;
    }

    public boolean IsAllowed(ParentalControlLevel customerParentalControlLevelPreference, String movieId) {
        return true;
    }
}

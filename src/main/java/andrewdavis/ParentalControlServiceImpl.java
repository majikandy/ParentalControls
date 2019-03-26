package andrewdavis;

public class ParentalControlServiceImpl implements ParentalControlService {
    private MovieService movieService;

    public ParentalControlServiceImpl(MovieService movieService) {
        this.movieService = movieService;
    }

    public MovieWatchableResult IsMovieWatchable(ParentalControlLevel customerParentalControlLevelPreference, String movieId) throws MovieService.TitleNotFoundException {
        try {
            String movieParentalControlLevel = this.movieService.getParentalControlLevel(movieId);

            ParentalControlLevel level = ParentalControlLevel.valueOf(movieParentalControlLevel);

            if (movieParentalControlLevel == "U") {
                return MovieWatchableResult.Watchable();
            }

            if (customerParentalControlLevelPreference == ParentalControlLevel.U) {
                return MovieWatchableResult.UnWatchable(Reason.ParentalControlLevel);
            }

            return MovieWatchableResult.Watchable();
        } catch (MovieService.TechnicalFailureException e) {
            return MovieWatchableResult.UnWatchable(Reason.TechnicalFailure);
        }
    }
}

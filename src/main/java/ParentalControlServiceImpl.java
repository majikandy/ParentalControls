public class ParentalControlServiceImpl implements ParentalControlService {
    private MovieService movieService;

    public ParentalControlServiceImpl(MovieService movieService) {
        this.movieService = movieService;
    }

    public MovieWatchableResult IsMovieWatchable(ParentalControlLevelEnum customerParentalControlLevelPreference, String movieId) throws MovieService.TitleNotFoundException {
        try {

            ParentalControlLevelEnum movieParentalControlLevel = ParentalControlLevelEnum.parse(this.movieService.getParentalControlLevel(movieId));

            if (movieParentalControlLevel.ordinal() <= customerParentalControlLevelPreference.ordinal()) {
                return MovieWatchableResult.Watchable();
            }

            return MovieWatchableResult.UnWatchable(Reason.ParentalControlLevel);

        } catch (MovieService.TechnicalFailureException e) {
            return MovieWatchableResult.UnWatchable(Reason.TechnicalFailure);
        }
    }
}

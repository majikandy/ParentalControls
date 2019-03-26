package andrewdavis;

public class ParentalControlServiceImpl implements ParentalControlService {
    private MovieService movieService;

    public ParentalControlServiceImpl(MovieService movieService) {
        this.movieService = movieService;
    }

    public boolean IsAllowed(ParentalControlLevel customerParentalControlLevelPreference, String movieId) {
        try {
            String movieParentalControlLevel = this.movieService.getParentalControlLevel(movieId);

            if (movieParentalControlLevel == "U") {
                return true;
            }

            if (customerParentalControlLevelPreference == ParentalControlLevel.U) {
                return false;
            }

            return true;
        } catch (MovieService.TitleNotFoundException e) {
            e.printStackTrace();
        } catch (MovieService.TechnicalFailureException e) {
            e.printStackTrace();
        }

        return false;
    }
}

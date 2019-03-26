public class ParentalControlServiceImpl implements ParentalControlService {
    public ParentalControlServiceImpl(MovieService movieService) {
    }

    public boolean IsAllowed(ParentalControlLevel customerParentalControlLevelPreference, String movieId) {
        return true;
    }
}

public interface ParentalControlService {
    MovieWatchableResult IsMovieWatchable(ParentalControlLevelEnum customerParentalControlLevelPreference, String movieId) throws MovieService.TitleNotFoundException;
}


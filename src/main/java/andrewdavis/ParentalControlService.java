package andrewdavis;

public interface ParentalControlService {
    MovieWatchableResult IsMovieWatchable(ParentalControlLevel customerParentalControlLevelPreference, String movieId) throws MovieService.TitleNotFoundException;
}


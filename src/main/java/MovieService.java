public interface MovieService {
    String getParentalControlLevel(String movieId)
            throws TitleNotFoundException,
            TechnicalFailureException;

    class TechnicalFailureException extends Exception {
    }

    class TitleNotFoundException extends Exception {
    }
}

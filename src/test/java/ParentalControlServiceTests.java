import andrewdavis.MovieService;
import andrewdavis.ParentalControlLevel;
import andrewdavis.ParentalControlService;
import andrewdavis.ParentalControlServiceImpl;
import org.junit.jupiter.api.Test;

public class ParentalControlServiceTests {

    private ParentalControlService parentalControlService;
    private boolean result;

    @Test
    public void when_movie_PG_and_customer_level_is_PG_then_customer_CAN_watch_movie(){
        given_movie_level_is("PG");
        when_requesting_if_movie_allowed_for(ParentalControlLevel.PG);
        movie_CAN_be_watched();
    }

    @Test
    public void when_movie_PG_and_customer_level_is_U_then_customer_CANNOT_watch_movie(){
        given_movie_level_is("PG");
        when_requesting_if_movie_allowed_for(ParentalControlLevel.U);
        movie_CANNOT_be_watched();
    }

    @Test
    public void when_movie_U_and_customer_level_is_U_then_customer_CAN_watch_movie(){
        given_movie_level_is("U");
        when_requesting_if_movie_allowed_for(ParentalControlLevel.U);
        movie_CAN_be_watched();
    }

    private void given_movie_level_is(final String movieParentalControlLevel) {
        parentalControlService = new ParentalControlServiceImpl(new MovieService() {
            public String getParentalControlLevel(String movieId) {
                return movieParentalControlLevel;
            }
        });
    }

    private void when_requesting_if_movie_allowed_for(ParentalControlLevel parentalControlLevel) {
        result = parentalControlService.IsAllowed(parentalControlLevel, "any_movie_id");
    }

    private void movie_CAN_be_watched() {
        assert result == true;
    }

    private void movie_CANNOT_be_watched() {
        assert result == false;
    }
}


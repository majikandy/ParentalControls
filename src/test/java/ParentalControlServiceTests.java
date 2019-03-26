import andrewdavis.*;
import org.junit.jupiter.api.Test;

public class ParentalControlServiceTests {

    private ParentalControlService parentalControlService;
    private MovieWatchableResult result;
    private Exception caughtException;

    @Test
    public void when_movie_PG_and_customer_level_is_PG_then_customer_CAN_watch_movie(){
        given_movie_level_is("PG");
        when_requesting_if_movie_allowed_for(ParentalControlLevel.PG);
        then_movie_CAN_be_watched();
    }

    @Test
    public void when_movie_PG_and_customer_level_is_U_then_customer_CANNOT_watch_movie(){
        given_movie_level_is("PG");
        when_requesting_if_movie_allowed_for(ParentalControlLevel.U);
        then_movie_CANNOT_be_watched();
        and_reason_is(Reason.ParentalControlLevel);
    }

    @Test
    public void when_movie_U_and_customer_level_is_U_then_customer_CAN_watch_movie(){
        given_movie_level_is("U");
        when_requesting_if_movie_allowed_for(ParentalControlLevel.U);
        then_movie_CAN_be_watched();
    }

    @Test
    public void when_movie_U_and_customer_level_is_PG_then_customer_CAN_watch_movie(){
        given_movie_level_is("U");
        when_requesting_if_movie_allowed_for(ParentalControlLevel.U);
        then_movie_CAN_be_watched();
    }

    @Test
    public void when_movie_service_has_system_error_details_are_hidden_from_the_user_just_indicates_they_cannot_watch_it_for_technical_reasons(){
        // NOTE: I'm not sure I agree with this requirement, I would debate the pros and cons of this
        // In reality, I would expect this to be decision to be closer to the end client call rather than wrapped here - but the spec really leads us this way
        // Also worth noting that although this is a contrived example, should a movie service really be throwing a TechnicalFailureException, it sounds far too generic
        given_movie_level_has_system_error();
        when_requesting_if_movie_allowed_for(ParentalControlLevel.U);
        then_movie_CANNOT_be_watched();
        and_reason_is(Reason.TechnicalFailure);
        // NOTE: We should have the code raise an event in the code if we are choosing to catch and wrap
        // so that it can be handled to fix the underlying cause of the problem
        // (eg. How a movie is returning an unknown parental control level string for example)
    }

    @Test
    public void when_movie_service_cannot_find_the_movie_then_the_exception_bubbles_up(){
        given_movie_cannot_be_found();
        when_requesting_if_movie_allowed_for(ParentalControlLevel.U);
        then_title_not_found_exception_is_bubbled_up();
    }

    @Test
    public void when_movie_service_returns_unknown_parental_control_level(){
        given_movie_level_is("something unknown");
        when_requesting_if_movie_allowed_for(ParentalControlLevel.U);
        then_illegal_argument_exception_is_bubbled_up();
        // reason being here that it is probably isn't the right place to catch all exceptions for logging/alerting -
        // I would expect that to be closer to the top level client call
        // the "we need to ensure that we are always failsafe" requirement is great, but that doesn't mean classes should catch
        // all exceptions and hide all error details, better that it breaks and gets fixed
        // OR in this case, even better that the MovieService doesn't use a string for the parental control level
    }

    private void then_illegal_argument_exception_is_bubbled_up() {
        assert this.caughtException instanceof IllegalArgumentException;
    }

    private void then_title_not_found_exception_is_bubbled_up() {
        assert this.caughtException instanceof MovieService.TitleNotFoundException;
    }

    private void given_movie_cannot_be_found() {
        parentalControlService = new ParentalControlServiceImpl(new MovieService() {
            public String getParentalControlLevel(String movieId) throws TitleNotFoundException {
                throw new TitleNotFoundException();
            }
        });
    }

    private void given_movie_level_has_system_error() {
        parentalControlService = new ParentalControlServiceImpl(new MovieService() {
            public String getParentalControlLevel(String movieId) throws TechnicalFailureException {
                throw new TechnicalFailureException();
            }
        });
    }

    private void given_movie_level_is(final String movieParentalControlLevel) {
        parentalControlService = new ParentalControlServiceImpl(new MovieService() {
            public String getParentalControlLevel(String movieId) {
                return movieParentalControlLevel;
            }
        });
    }

    private void when_requesting_if_movie_allowed_for(ParentalControlLevel parentalControlLevel) {
        try {
            result = parentalControlService.IsMovieWatchable(parentalControlLevel, "any_movie_id");
        } catch (Exception e)
        {
            this.caughtException = e;
        }
    }

    private void then_movie_CAN_be_watched() {
        assert result.isWatchable() == true;
    }

    private void then_movie_CANNOT_be_watched() {
        assert result.isWatchable() == false;
    }

    private void and_reason_is(Reason reason) {
        assert result.getReason() == reason;
    }
}


import org.junit.jupiter.api.Test;

public class ParentalControlServiceTests {

    private ParentalControlService parentalControlService;
    private MovieWatchableResult result;
    private Exception caughtException;

    @Test
    public void when_movie_U_and_customer_level_is_U_then_customer_CAN_watch_movie(){
        given_movie_level_is("U");
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.U);
        then_movie_CAN_be_watched();
    }

    @Test
    public void when_movie_U_and_customer_level_is_PG_then_customer_CAN_watch_movie(){
        given_movie_level_is("U");
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.PG);
        then_movie_CAN_be_watched();
    }

    @Test
    public void when_movie_U_and_customer_level_is_12_then_customer_CAN_watch_movie(){
        given_movie_level_is("U");
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.Twelve);
        then_movie_CAN_be_watched();
    }

    @Test
    public void when_movie_U_and_customer_level_is_15_then_customer_CAN_watch_movie(){
        given_movie_level_is("U");
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.Fifteen);
        then_movie_CAN_be_watched();
    }

    @Test
    public void when_movie_U_and_customer_level_is_18_then_customer_CAN_watch_movie(){
        given_movie_level_is("U");
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.Eighteen);
        then_movie_CAN_be_watched();
    }

    @Test
    public void when_movie_PG_and_customer_level_is_U_then_customer_CANNOT_watch_movie(){
        given_movie_level_is("PG");
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.U);
        then_movie_CANNOT_be_watched();
        and_reason_is(Reason.ParentalControlLevel);
    }

    @Test
    public void when_movie_PG_and_customer_level_is_PG_then_customer_CAN_watch_movie(){
        given_movie_level_is("PG");
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.PG);
        then_movie_CAN_be_watched();
    }

    @Test
    public void when_movie_PG_and_customer_level_is_12_then_customer_CAN_watch_movie(){
        given_movie_level_is("PG");
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.Twelve);
        then_movie_CAN_be_watched();
    }

    @Test
    public void when_movie_PG_and_customer_level_is_15_then_customer_CAN_watch_movie(){
        given_movie_level_is("PG");
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.Fifteen);
        then_movie_CAN_be_watched();
    }

    @Test
    public void when_movie_PG_and_customer_level_is_18_then_customer_CAN_watch_movie(){
        given_movie_level_is("PG");
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.Eighteen);
        then_movie_CAN_be_watched();
    }

    @Test
    public void when_movie_12_and_customer_level_is_U_then_customer_CANNOT_watch_movie(){
        given_movie_level_is("12");
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.U);
        then_movie_CANNOT_be_watched();
        and_reason_is(Reason.ParentalControlLevel);
    }

    @Test
    public void when_movie_12_and_customer_level_is_PG_then_customer_CANNOT_watch_movie(){
        given_movie_level_is("12");
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.PG);
        then_movie_CANNOT_be_watched();
        and_reason_is(Reason.ParentalControlLevel);
    }

    @Test
    public void when_movie_12_and_customer_level_is_12_then_customer_CAN_watch_movie(){
        given_movie_level_is("12");
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.Twelve);
        then_movie_CAN_be_watched();
    }

    @Test
    public void when_movie_12_and_customer_level_is_15_then_customer_CAN_watch_movie(){
        given_movie_level_is("12");
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.Fifteen);
        then_movie_CAN_be_watched();
    }

    @Test
    public void when_movie_12_and_customer_level_is_18_then_customer_CAN_watch_movie(){
        given_movie_level_is("12");
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.Eighteen);
        then_movie_CAN_be_watched();
    }


    @Test
    public void when_movie_15_and_customer_level_is_U_then_customer_CANNOT_watch_movie(){
        given_movie_level_is("15");
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.U);
        then_movie_CANNOT_be_watched();
        and_reason_is(Reason.ParentalControlLevel);
    }

    @Test
    public void when_movie_15_and_customer_level_is_PG_then_customer_CANNOT_watch_movie(){
        given_movie_level_is("15");
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.PG);
        then_movie_CANNOT_be_watched();
        and_reason_is(Reason.ParentalControlLevel);
    }

    @Test
    public void when_movie_15_and_customer_level_is_12_then_customer_CANNOT_watch_movie(){
        given_movie_level_is("15");
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.Twelve);
        then_movie_CANNOT_be_watched();
        and_reason_is(Reason.ParentalControlLevel);
    }

    @Test
    public void when_movie_15_and_customer_level_is_15_then_customer_CAN_watch_movie(){
        given_movie_level_is("15");
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.Fifteen);
        then_movie_CAN_be_watched();
    }

    @Test
    public void when_movie_15_and_customer_level_is_18_then_customer_CAN_watch_movie(){
        given_movie_level_is("15");
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.Eighteen);
        then_movie_CAN_be_watched();
    }

    @Test
    public void when_movie_18_and_customer_level_is_U_then_customer_CANNOT_watch_movie(){
        given_movie_level_is("18");
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.U);
        then_movie_CANNOT_be_watched();
        and_reason_is(Reason.ParentalControlLevel);
    }

    @Test
    public void when_movie_18_and_customer_level_is_PG_then_customer_CANNOT_watch_movie(){
        given_movie_level_is("18");
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.PG);
        then_movie_CANNOT_be_watched();
        and_reason_is(Reason.ParentalControlLevel);
    }

    @Test
    public void when_movie_18_and_customer_level_is_12_then_customer_CANNOT_watch_movie(){
        given_movie_level_is("18");
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.Twelve);
        then_movie_CANNOT_be_watched();
        and_reason_is(Reason.ParentalControlLevel);
    }

    @Test
    public void when_movie_18_and_customer_level_is_15_then_customer_CANNOT_watch_movie(){
        given_movie_level_is("18");
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.Fifteen);
        then_movie_CANNOT_be_watched();
        and_reason_is(Reason.ParentalControlLevel);
    }

    @Test
    public void when_movie_18_and_customer_level_is_18_then_customer_CAN_watch_movie(){
        given_movie_level_is("15");
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.Eighteen);
        then_movie_CAN_be_watched();
    }


    /* NOTE: comments only in the below Tests for purposes of this Technical Test.

       Problems are usually better dealt with by communication, and the design decision demonstrated in the code
       (or recorded on the board for planning and prioritising if a bigger change needed) rather than littering comments.

       However other than an email, which could get lost by the recruiter, this is the easiest way to express intention for this test. */

    @Test
    public void when_movie_service_has_system_error_details_are_hidden_and_it_just_indicates_they_cannot_watch_it_for_technical_reasons(){
        given_movie_level_has_system_error();
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.U);
        then_movie_CANNOT_be_watched();
        and_reason_is(Reason.TechnicalFailure);

        // NOTE: I'm not sure I agree with this requirement, I would debate the pros and cons of this
        // In reality, I would expect this to be decision to be closer to the end client call rather than wrapped here - but the spec really leads us this way
        // Also worth noting that although this is a contrived example, should a movie service really be throwing a TechnicalFailureException, it sounds far too generic

        // NOTE: We should have the code raise an event in the code if we are choosing to catch and wrap - furthermore maybe MovieService responsibility.
        // so that it can be handled to fix the underlying cause of the problem
    }

    @Test
    public void when_movie_service_cannot_find_the_movie_then_the_exception_bubbles_up(){
        given_movie_cannot_be_found();
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.U);
        then_title_not_found_exception_is_bubbled_up();

        // The reason here is that this layer cannot add any more value to this particular exception.
        // It could be converted to a result with reason: TitleNotFound,
        // but if the decision is that TitleNotFound is Exceptional at the MovieService
        // then this layer wrapping that exception, adds nothing.
    }

    @Test
    public void when_movie_service_returns_unknown_parental_control_level(){
        given_movie_level_is("something unknown");
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.U);
        then_illegal_argument_exception_is_bubbled_up();

        // The reason here for this design that it is probably isn't the right place to catch all exceptions for logging/alerting -
        // I would expect that to be closer to the top level client call
        // the "we need to ensure that we are always failsafe" requirement is great, but that doesn't mean all classes should catch
        // all exceptions and hide all error details, better that it bubble up the real error and gets fixed
        // OR in this case, even better that the MovieService doesn't use a string for the parental control level
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

    private void when_requesting_if_movie_allowed_for(ParentalControlLevelEnum parentalControlLevel) {
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

    private void then_illegal_argument_exception_is_bubbled_up() {
        assert this.caughtException instanceof IllegalArgumentException;
    }

    private void then_title_not_found_exception_is_bubbled_up() {
        assert this.caughtException instanceof MovieService.TitleNotFoundException;
    }
}

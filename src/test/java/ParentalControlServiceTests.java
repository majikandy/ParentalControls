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

    @Test
    public void when_movie_service_has_system_error_details_are_hidden_and_it_just_indicates_they_cannot_watch_it_for_technical_reasons(){
        given_movie_level_has_system_error();
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.U);
        then_movie_CANNOT_be_watched();
        and_reason_is(Reason.TechnicalFailure);
    }

    @Test
    public void when_movie_service_cannot_find_the_movie_then_the_exception_bubbles_up(){
        given_movie_cannot_be_found();
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.U);
        then_title_not_found_exception_is_bubbled_up();
    }

    @Test
    public void when_movie_service_returns_unknown_parental_control_level(){
        given_movie_level_is("something unknown");
        when_requesting_if_movie_allowed_for(ParentalControlLevelEnum.U);
        then_illegal_argument_exception_is_bubbled_up();
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

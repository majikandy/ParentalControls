# Parental Control Service

## Scenario

The company is developing a next generation Video on Demand platform. You are
part of a software engineering team, developing services for the platform
and working on the story below.

Prevent access to movies based on parental control level:

As a customer I don’t want my account to be able to access movies that
have a higher parental control level than my current preference setting.
Your team has partnered with the Movie Meta Data team that provides a
service that can return parental control information for a given movie.

## Parental Control Levels
U, PG, 12, 15, 18


## Acceptance Criteria

The following table describes the expected ParentalControlService result

**It also describes the design decision of the implementation**

| Movie Service Response      | Description                                      | Result                                                                                                                                                       | ParentalControlService Design Decision                                                                                                                                                                                                                                                                                                                                                                                       |
|-----------------------------|--------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Parental Control level      | A string e.g. “PG”                               | If the parental control level of the  movie is equal to or less than the customer’s preference indicate to  the caller that the customer can watch the movie | Result object containing Watchable:true                                                                                                                                                                                                                                                                                                                                                               |
| TitleNotFound Exception     | The movie service could not find the given movie | Indicate the error to the calling client.                                                                                                                    | Let this bubble up as can't add much  value by wrapping it.  Since decision at Movie Service is that this is exceptional,  then there is no reason to handle that here rather than  closer to the top level calling client code.                                                                                                                                                                      |
| Technical failure exception | System Error                                     | Indicate that the customer cannot watch this movie                                                                                                           | Wrap this one as a Result with Watchable: false  and a reason of Technical Failure. - Assume that alerting / logging taken care of  in the Movie Service implementation. Requirement suggests it should not bubble up  but I think this decision would be a point of  discussion as to the best thing to do here.  Also Technical Failure Exception is a bit contrived  so definitely one to discuss. |


**Specified Requirement:** We need to ensure that we always failsafe.

**ParentalControlService Design Decision:** This service probably isn't the right place to catch all exceptions for logging/alerting -
I would expect that to be closer to the top level client call and prefer all other Exceptions to bubble up.
The requirement is great, but that doesn't mean all classes should catch all exceptions and hide all error details,
better that it bubble up the real error and gets fixed OR fix certain flaws like primative abuse; e.g. MovieService uses a string for the parental control level but really it isn't a free string, it is one of the 5 choices (i.e. an Enum). Of course then be failsafe at the application level and don't crash the UI or anthing but not necessarily a catch all at this level (one for discussion).

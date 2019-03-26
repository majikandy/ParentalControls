package andrewdavis;

public class MovieWatchableResult {
    private final boolean watchable;
    private final Reason reason;

    private MovieWatchableResult(boolean watchable, andrewdavis.Reason reason) {
        this.watchable = watchable;
        this.reason = reason;
    }

    public static MovieWatchableResult Watchable() {
        return new MovieWatchableResult(true, andrewdavis.Reason.None);
    }

    public static MovieWatchableResult UnWatchable(Reason reason) {
        return new MovieWatchableResult(false, reason);
    }

    public boolean isWatchable() {
        return watchable;
    }

    public Reason getReason() {
        return reason;
    }
}

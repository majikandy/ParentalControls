package andrewdavis;

public enum ParentalControlLevelEnum {
    U ("U", 1),
    PG ("PG", 2),
    Twelve ("12", 3);

    private String rating;

    ParentalControlLevelEnum(String rating, int comparison) {
        this.rating = rating;
    }

    public static ParentalControlLevelEnum parse(String value) {
        for(ParentalControlLevelEnum v : values())
            if(v.rating.equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException();
    }
}
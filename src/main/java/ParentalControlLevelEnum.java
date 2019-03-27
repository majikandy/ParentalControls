public enum ParentalControlLevelEnum {
    U ("U"),
    PG ("PG"),
    Twelve ("12"),
    Fifteen("15"),
    Eighteen("18");

    private String rating;

    ParentalControlLevelEnum(String rating) {
        this.rating = rating;
    }

    public static ParentalControlLevelEnum parse(String value) {
        for(ParentalControlLevelEnum v : values())
            if(v.rating.equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException();
    }
}
package ch.hslu.ta.prg2.Gamestate;

public enum Field {
    WATER(true),
    SHIPHIT(false),
    SHIPDESTROYED(false),
    HIT(false),
    SHIP(true),
    GAP(true);

    private final boolean shotable;

    private Field(final boolean shotable) {
        this.shotable = shotable;
    }

    public boolean isShootable() {
        return this.shotable;
    }
}

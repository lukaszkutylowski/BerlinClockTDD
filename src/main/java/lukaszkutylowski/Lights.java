package lukaszkutylowski;

public enum Lights {
    OFF('O'),
    YELLOW('Y'),
    RED('R'),
    INITIAL('O');

    private final char light;

    Lights(char lightClock) {
        light = lightClock;
    }

    public char getLight() {
        return light;
    }
}

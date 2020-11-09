package lukaszkutylowski;

public class Converter {

    public static int convertCharsToInt(String time, int hoursMinutesSecondsIndex) {
        int hoursOrMinutesOrSeconds;
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(time.substring(hoursMinutesSecondsIndex, hoursMinutesSecondsIndex + 2));
        hoursOrMinutesOrSeconds = Integer.parseInt(stringBuilder.toString());

        return hoursOrMinutesOrSeconds;
    }
}

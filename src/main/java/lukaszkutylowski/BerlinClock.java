package lukaszkutylowski;

import lukaszkutylowski.ResizableCharArray.ResizableCharArray;

public class BerlinClock implements Clock{

    public BerlinClock() {}

    public String convertTime(String time) {
        int[] hoursMinutesSecondsTab = new int[3];
        int hoursMinutesSecondsIndex = 0;

        for (int index = 0; index <=2; index++) {
            hoursMinutesSecondsTab[index] = Converter.convertCharsToInt(time, hoursMinutesSecondsIndex);
            hoursMinutesSecondsIndex += 3;
        }

        ResizableCharArray list = new ResizableCharArray();

        processingSeconds(hoursMinutesSecondsTab[2], list);
        processingFiveHrs(hoursMinutesSecondsTab[0], list);
        processingSingleHrs(hoursMinutesSecondsTab[0], list);
        processingFiveMinutes(hoursMinutesSecondsTab[1], list);
        processingSingleMinutes(hoursMinutesSecondsTab[1], list);

        return list.toStringBerlinClock();
    }

    private ResizableCharArray processingSeconds(int secondsInt, ResizableCharArray list) {
        return EngineBerlinClock.convertSeconds(secondsInt, list);
    }

    private ResizableCharArray processingFiveHrs(int hoursInt, ResizableCharArray list) {
        return EngineBerlinClock.convertFiveHrs(hoursInt, list);
    }

    private ResizableCharArray processingSingleHrs(int hoursInt, ResizableCharArray list) {
        return EngineBerlinClock.convertIntToHoursOrMinutesString(hoursInt, Flag.HOURS, list);
    }

    private ResizableCharArray processingFiveMinutes(int minutesInt, ResizableCharArray list) {
        return EngineBerlinClock.fiveMinutesLightBuilder(minutesInt, list);
    }

    private ResizableCharArray processingSingleMinutes(int minutesInt, ResizableCharArray list) {
        return EngineBerlinClock.convertIntToHoursOrMinutesString(minutesInt, Flag.MINUTES, list);
    }
}

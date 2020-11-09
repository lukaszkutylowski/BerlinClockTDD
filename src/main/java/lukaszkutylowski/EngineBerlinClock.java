package lukaszkutylowski;

import lukaszkutylowski.ResizableCharArray.ResizableCharArray;

public class EngineBerlinClock {

    public static ResizableCharArray convertSeconds(int secondsInt, ResizableCharArray list) {
        if (secondsInt % 2 == 0) {
            list.save(Lights.YELLOW.getLight());
        } else {
            list.save(Lights.OFF.getLight());
        }
        return list;
    }

    public static ResizableCharArray convertFiveHrs(int hoursInt, ResizableCharArray list) {
        int howManyHrsLight = hoursInt / 5;
        int howManyOffLight = 4 - howManyHrsLight;

        for (int i = 0; i < howManyHrsLight; i++) {
            list.save(Lights.RED.getLight());
        }

        for (int j = 0; j < howManyOffLight; j++) {
            list.save(Lights.OFF.getLight());
        }
        return list;
    }

    public static ResizableCharArray convertIntToHoursOrMinutesString(int hoursInt, Flag FLAG, ResizableCharArray list) {
        int howMuchFiveHrs = hoursInt % 5;
        int howMuchOff = 4 - howMuchFiveHrs;

        for (int i = 0; i < howMuchFiveHrs; i++) {
            if (FLAG == FLAG.HOURS) {
                list.save(Lights.RED.getLight());
            } else {
                list.save(Lights.YELLOW.getLight());
            }
        }

        for (int j = 0; j < howMuchOff; j++) {
            list.save(Lights.OFF.getLight());
        }

        return list;
    }

    public static ResizableCharArray fiveMinutesLightBuilder(int minutesInt, ResizableCharArray list) {
        int howMuchYellow = minutesInt / 5;
        int howMuchYYR = howMuchYellow / 3;
        int addedLightCounter = 0;

        for (int i = 0; i < howMuchYYR; i++) {
            list.save(Lights.YELLOW.getLight());
            list.save(Lights.YELLOW.getLight());
            list.save(Lights.RED.getLight());
            addedLightCounter += 3;
        }

        for (int j = 0; j < howMuchYellow - howMuchYYR * 3; j++) {
            list.save(Lights.YELLOW.getLight());
            addedLightCounter++;
        }

        for (int k = 0; k < 11 - addedLightCounter; k++) {
            list.save(Lights.OFF.getLight());
        }

        return list;
    }
}

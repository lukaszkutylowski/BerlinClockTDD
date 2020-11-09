package lukaszkutylowski;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BerlinClockTest {

    BerlinClock berlinClock;

    @Before
    public void setUp() {
        berlinClock = new BerlinClock();
    }

    @Test
    public void should_return_seconds_light() {
        // given
        final char expectedLightMarkerEven = 'Y';
        final char expectedLightMarkerOdd = 'O';
        final String testTimeEven = "11:37:10";
        final String testTimeOdd = "11:37:11";

        // when
        String actualStringEven = berlinClock.convertTime(testTimeEven);
        String actualStringOdd = berlinClock.convertTime(testTimeOdd);
        char actualMarkerEven = actualStringEven.charAt(0);
        char actualMarkerOdd = actualStringOdd.charAt(0);

        // then
        assertEquals(expectedLightMarkerEven, actualMarkerEven);
        assertEquals(expectedLightMarkerOdd, actualMarkerOdd);
    }

    @Test
    public void should_return_five_hours_when_hour_is_00() {
        // given
        final String expectedLightMarker0to4H = "OOOO";
        final String testTime1 = "00:37:10";

        // when
        String actualString = berlinClock.convertTime(testTime1);
        String actualMarkerEven = actualString.substring(1,5);

        // then
        assertEquals(expectedLightMarker0to4H, actualMarkerEven);
    }

    @Test
    public void should_return_five_hours_when_hour_is_23() {
        // given
        final String expectedLightMarker0to4H = "RRRR";
        final String testTime = "23:37:10";

        // when
        String actualString = berlinClock.convertTime(testTime);
        String actualMarkerEven = actualString.substring(1,5);

        // then
        assertEquals(expectedLightMarker0to4H, actualMarkerEven);
    }

    @Test
    public void should_return_five_hours_when_is_08() {
        // given
        final String expectedLightMarker0to4H = "ROOO";
        final String testTime = "08:37:10";

        // when
        String actualString = berlinClock.convertTime(testTime);
        String actualMarkerEven = actualString.substring(1,5);

        // then
        assertEquals(expectedLightMarker0to4H, actualMarkerEven);
    }

    @Test
    public void should_return_five_hours_when_hr_is_16() {
        // given
        final String expectedLightMarker0t04H = "RRRO";
        final String testTime = "16:37:10";

        // when
        String actualString = berlinClock.convertTime(testTime);
        String actualMarkerEven = actualString.substring(1,5);

        // then
        assertEquals(expectedLightMarker0t04H, actualMarkerEven);
    }

    @Test
    public void should_return_single_hours_when_hr_is_23() {
        // given
        final String expectedLightMarker0t04H = "RRRO";
        final String testTime = "23:37:10";

        // when
        String actualString = berlinClock.convertTime(testTime);
        String actualMarkerEven = actualString.substring(5,9);

        // then
        assertEquals(expectedLightMarker0t04H,actualMarkerEven);
    }

    @Test
    public void should_return_single_hours_when_hr_is_02() {
        // given
        final String expectedLightMarker0t04H = "RROO";
        final String testTime = "02:37:10";

        // when
        String actualString = berlinClock.convertTime(testTime);
        String actualMarkerEven = actualString.substring(5,9);

        // then
        assertEquals(expectedLightMarker0t04H,actualMarkerEven);
    }

    @Test
    public void should_return_single_hours_when_hr_is_08() {
        // given
        final String expectedLightMarker0t04H = "RRRO";
        final String testTime = "08:37:10";

        // when
        String actualString = berlinClock.convertTime(testTime);
        String actualMarkerEven = actualString.substring(5,9);

        // then
        assertEquals(expectedLightMarker0t04H,actualMarkerEven);
    }

    @Test
    public void should_return_single_hours_when_hr_is_14() {
        // given
        final String expectedLightMarker0t04H = "RRRR";
        final String testTime = "14:37:10";

        // when
        String actualString = berlinClock.convertTime(testTime);
        String actualMarkerEven = actualString.substring(5,9);

        // then
        assertEquals(expectedLightMarker0t04H,actualMarkerEven);
    }

    @Test
    public void should_return_five_minutes_when_min_is_00() {
        // given
        final String expectedLightMarker = "OOOOOOOOOOO";
        final String testTime = "23:00:10";

        // when
        String actualString = berlinClock.convertTime(testTime);
        String actualMarkerEven = actualString.substring(9,20);

        // then
        assertEquals(expectedLightMarker,actualMarkerEven);
    }

    @Test
    public void should_return_five_minutes_when_min_is_59() {
        // given
        final String expectedLightMarker = "YYRYYRYYRYY";
        final String testTime = "23:59:10";

        // when
        String actualString = berlinClock.convertTime(testTime);
        String actualMarkerEven = actualString.substring(9,20);

        // then
        assertEquals(expectedLightMarker,actualMarkerEven);
    }

    @Test
    public void should_return_five_minutes_when_min_is_04() {
        // given
        final String expectedLightMarker = "OOOOOOOOOOO";
        final String testTime = "23:04:10";

        // when
        String actualString = berlinClock.convertTime(testTime);
        String actualMarkerEven = actualString.substring(9,20);

        // then
        assertEquals(expectedLightMarker,actualMarkerEven);
    }

    @Test
    public void should_return_five_minutes_when_min_is_23() {
        // given
        final String expectedLightMarker = "YYRYOOOOOOO";
        final String testTime = "23:23:10";

        // when
        String actualString = berlinClock.convertTime(testTime);
        String actualMarkerEven = actualString.substring(9,20);

        // then
        assertEquals(expectedLightMarker,actualMarkerEven);
    }

    @Test
    public void should_return_five_minutes_when_min_is_35() {
        // given
        final String expectedLightMarker = "YYRYYRYOOOO";
        final String testTime = "23:35:10";

        // when
        String actualString = berlinClock.convertTime(testTime);
        String actualMarkerEven = actualString.substring(9,20);

        // then
        assertEquals(expectedLightMarker,actualMarkerEven);
    }

    @Test
    public void should_return_single_minutes_when_min_is_00() {
        // given
        final String expectedLightMarker = "OOOO";
        final String testTime = "23:00:10";

        // when
        String actualString = berlinClock.convertTime(testTime);
        String actualMarkerEven = actualString.substring(20,24);

        // then
        assertEquals(expectedLightMarker,actualMarkerEven);
    }

    @Test
    public void should_return_single_minutes_when_min_is_59() {
        // given
        final String expectedLightMarker = "YYYY";
        final String testTime = "23:59:10";

        // when
        String actualString = berlinClock.convertTime(testTime);
        String actualMarkerEven = actualString.substring(20,24);

        // then
        assertEquals(expectedLightMarker,actualMarkerEven);
    }

    @Test
    public void should_return_single_minutes_when_min_is_32() {
        // given
        final String expectedLightMarker = "YYOO";
        final String testTime = "23:32:10";

        // when
        String actualString = berlinClock.convertTime(testTime);
        String actualMarkerEven = actualString.substring(20,24);

        // then
        assertEquals(expectedLightMarker,actualMarkerEven);
    }

    @Test
    public void should_return_single_minutes_when_min_is_34() {
        // given
        final String expectedLightMarker = "YYYY";
        final String testTime = "23:34:10";

        // when
        String actualString = berlinClock.convertTime(testTime);
        String actualMarkerEven = actualString.substring(20,24);

        // then
        assertEquals(expectedLightMarker,actualMarkerEven);
    }

    @Test
    public void should_return_single_minutes_when_min_is_35() {
        // given
        final String expectedLightMarker = "OOOO";
        final String testTime = "23:35:10";

        // when
        String actualString = berlinClock.convertTime(testTime);
        String actualMarkerEven = actualString.substring(20,24);

        // then
        assertEquals(expectedLightMarker,actualMarkerEven);
    }

    @Test
    public void should_return_time_lights_when_time_is_00_00_00() {
        // given
        final String expectedMarker1 = "YOOOOOOOOOOOOOOOOOOOOOOO";
        final String testTime1 = "00:00:00";

        // when
        final String actualMarker1 = berlinClock.convertTime(testTime1);

        // then
        assertEquals(expectedMarker1,actualMarker1);
    }

    @Test
    public void should_return_time_lights_when_time_is_23_59_59() {
        // given
        final String expectedMarker2 = "ORRRRRRROYYRYYRYYRYYYYYY";
        final String testTime2 = "23:59:59";

        // when
        final String actualMarker2 = berlinClock.convertTime(testTime2);

        // then
        assertEquals(expectedMarker2,actualMarker2);
    }

    @Test
    public void should_return_time_lights_when_time_is_16_50_06() {
        // given
        final String expectedMarker3 = "YRRROROOOYYRYYRYYRYOOOOO";
        final String testTime3 = "16:50:06";

        // when
        final String actualMarker3 = berlinClock.convertTime(testTime3);

        // then
        assertEquals(expectedMarker3,actualMarker3);
    }

    @Test
    public void should_return_time_lights_when_time_is_11_37_01() {
        // given
        final String expectedMarker4 = "ORROOROOOYYRYYRYOOOOYYOO";
        final String testTime4 = "11:37:01";

        // when
        final String actualMarker4 = berlinClock.convertTime(testTime4);

        // then
        assertEquals(expectedMarker4,actualMarker4);
    }
}
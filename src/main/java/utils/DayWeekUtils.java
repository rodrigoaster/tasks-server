package utils;

import java.time.DayOfWeek;
import java.util.List;

public class DayWeekUtils {
    public static DayOfWeek validateDayOfWeek(String inputDay) {
        List<DayOfWeek> allDaysOfWeek = List.of(DayOfWeek.values());
        return allDaysOfWeek
                .stream()
                .filter(day -> inputDay.equalsIgnoreCase(day.name()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid day of week: " + inputDay));
    }
}

package org.example;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class EraUtil {
    private EraUtil() {
    }

    public static String getEraDateString(Instant date) {

        if (date.isBefore(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse("1868-01-25T00:00:00.000+09:00", Instant::from))) {
            throw new RuntimeException("date is too old.");
        }

        if (date.isBefore(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse("1912-07-30T00:00:00.000+09:00", Instant::from))) {
            return getEraDateString(date, "明治", 1867);
        }

        if (date.isBefore(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse("1926-12-25T00:00:00.000+09:00", Instant::from))) {
            return getEraDateString(date, "大正", 1911);
        }

        if (date.isBefore(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse("1989-01-08T00:00:00.000+09:00", Instant::from))) {
            return getEraDateString(date, "昭和", 1925);
        }

        if (date.isBefore(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse("2019-05-01T00:00:00.000+09:00", Instant::from))) {
            return getEraDateString(date, "平成", 1988);
        }

        return getEraDateString(date, "令和", 2018);


    }

    private static String getEraDateString(
            Instant date,
            String Era,
            Integer offset
    ) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date, ZoneId.of("Asia/Tokyo"));
        if ((localDateTime.getYear() - offset) == 1) {
            return String.format(
                    "%s元年%02d月%02d日",
                    Era,
                    localDateTime.getMonthValue(),
                    localDateTime.getDayOfMonth()
            );
        }
        return String.format(
                "%s%02d年%02d月%02d日",
                Era,
                localDateTime.getYear() - offset,
                localDateTime.getMonthValue(),
                localDateTime.getDayOfMonth()
        );
    }
}

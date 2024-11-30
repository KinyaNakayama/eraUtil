package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {


        writeTestResult("");

        writeTestResult("明治元年初日：" + EraUtil.getEraDateString(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse("1868-01-25T00:00:00.000+09:00",Instant::from)));
        writeTestResult("明治元年終日：" + EraUtil.getEraDateString(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse("1868-12-31T00:00:00.000+09:00",Instant::from)));
        writeTestResult("明治通常初日：" + EraUtil.getEraDateString(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse("1869-01-01T00:00:00.000+09:00",Instant::from)));
        writeTestResult("明治通常終日：" + EraUtil.getEraDateString(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse("1912-07-29T23:59:59.999+09:00",Instant::from)));

        writeTestResult("大正元年初日：" + EraUtil.getEraDateString(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse("1912-07-30T00:00:00.000+09:00",Instant::from)));
        writeTestResult("大正元年終日：" + EraUtil.getEraDateString(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse("1912-12-31T00:00:00.000+09:00",Instant::from)));
        writeTestResult("大正通常初日：" + EraUtil.getEraDateString(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse("1913-01-01T00:00:00.000+09:00",Instant::from)));
        writeTestResult("大正通常終日：" + EraUtil.getEraDateString(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse("1926-12-24T23:59:59.999+09:00",Instant::from)));

        writeTestResult("昭和元年初日：" + EraUtil.getEraDateString(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse("1926-12-25T00:00:00.000+09:00",Instant::from)));
        writeTestResult("昭和元年終日：" + EraUtil.getEraDateString(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse("1926-12-31T00:00:00.000+09:00",Instant::from)));
        writeTestResult("昭和通常初日：" + EraUtil.getEraDateString(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse("1927-01-01T00:00:00.000+09:00",Instant::from)));
        writeTestResult("昭和通常終日：" + EraUtil.getEraDateString(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse("1989-01-07T23:59:59.999+09:00",Instant::from)));

        writeTestResult("平成元年初日：" + EraUtil.getEraDateString(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse("1989-01-08T00:00:00.000+09:00",Instant::from)));
        writeTestResult("平成元年終日：" + EraUtil.getEraDateString(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse("1989-12-31T00:00:00.000+09:00",Instant::from)));
        writeTestResult("平成通常初日：" + EraUtil.getEraDateString(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse("1990-01-01T00:00:00.000+09:00",Instant::from)));
        writeTestResult("平成通常終日：" + EraUtil.getEraDateString(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse("2019-04-30T23:59:59.999+09:00",Instant::from)));

        writeTestResult("令和元年初日：" + EraUtil.getEraDateString(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse("2019-05-01T00:00:00.000+09:00",Instant::from)));
        writeTestResult("令和元年終日：" + EraUtil.getEraDateString(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse("2019-12-31T00:00:00.000+09:00",Instant::from)));
        writeTestResult("令和通常初日：" + EraUtil.getEraDateString(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse("2020-01-01T00:00:00.000+09:00",Instant::from)));
        writeTestResult("令和通常終日：" + EraUtil.getEraDateString(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse("2100-12-31T23:59:59.999+09:00",Instant::from)));

    }

    private static void writeTestResult(String data) {
        try {
            if (data.isEmpty()) {
                Files.deleteIfExists(Path.of("build/testResult.txt"));
                Files.write(
                        Path.of("build/testResult.txt"),
                        data.getBytes(StandardCharsets.UTF_8),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.WRITE
                );
            } else {
                Files.write(
                        Path.of("build/testResult.txt"),
                        data.getBytes(StandardCharsets.UTF_8),
                        StandardOpenOption.APPEND,
                        StandardOpenOption.WRITE
                );
                Files.write(
                        Path.of("build/testResult.txt"),
                        "\n".getBytes(StandardCharsets.UTF_8),
                        StandardOpenOption.APPEND,
                        StandardOpenOption.WRITE
                );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
package eCourse.clientusermanagement.domain;

import org.threeten.bp.Year;

import java.util.concurrent.atomic.AtomicInteger;

public class MecanographicNumberDomainService {

    private static final String DATE_FORMAT_DEFAULT = "%tY";
    private static final String NUMBER_FORMAT_DEFAULT = "%05d";

    private static final String format;

    static {
        format = DATE_FORMAT_DEFAULT + NUMBER_FORMAT_DEFAULT;
    }

    public static String generate() {
        return String.format(format, Year.now(), generateNumber());
    }

    private static AtomicInteger sequence = new AtomicInteger(0);


    private static int generateNumber() {
        return sequence.incrementAndGet();
    }


}

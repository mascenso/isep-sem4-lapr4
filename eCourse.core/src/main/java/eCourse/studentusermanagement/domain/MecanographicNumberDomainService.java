package eCourse.studentusermanagement.domain;

import java.time.Year;
import java.util.concurrent.atomic.AtomicInteger;

public class MecanographicNumberDomainService {

    private static final String DATE_FORMAT_DEFAULT = "%04d";
    private static final String NUMBER_FORMAT_DEFAULT = "%05d";

    private static final String format;

    static {
        format = DATE_FORMAT_DEFAULT + NUMBER_FORMAT_DEFAULT;
    }

    public static MecanographicNumber generateFirst() {
        return new MecanographicNumber(String.format(format, java.time.Year.now().getValue(), 1));
    }

    public static MecanographicNumber generateFromLast(MecanographicNumber mecanographicNumber) {
        java.time.Year year = mecanographicNumber.year();

        if (year.equals(java.time.Year.now())) {
            return new MecanographicNumber(String.format(format, java.time.Year.now().getValue(), mecanographicNumber.numberInYear() + 1));
        } else {
            return generateFirst();
        }
    }


}

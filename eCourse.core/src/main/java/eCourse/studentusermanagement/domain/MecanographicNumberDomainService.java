package eCourse.studentusermanagement.domain;

import org.threeten.bp.Year;

import java.util.concurrent.atomic.AtomicInteger;

public class MecanographicNumberDomainService {


    // placing domain logic in the appropriate domain layer, and not in the application layer or even database.
    // Todo very urgently!!
    // should retrieve from the database the last mecanographic number used, as this is not being persisted!
    // and to avoid inconsistencies

    private static final String DATE_FORMAT_DEFAULT = "%04d";
    private static final String NUMBER_FORMAT_DEFAULT = "%05d";

    private static final String format;

    static {
        format = DATE_FORMAT_DEFAULT + NUMBER_FORMAT_DEFAULT;
    }

    public static String generate() {
        return String.format(format, Year.now().getValue(), generateNumber());
    }

    private static AtomicInteger sequence = new AtomicInteger(0);


    private static int generateNumber() {
        return sequence.incrementAndGet();
    }


}

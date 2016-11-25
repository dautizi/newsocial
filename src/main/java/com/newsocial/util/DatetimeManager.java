package com.newsocial.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatetimeManager {

    protected static final Logger logger = LoggerFactory.getLogger(DatetimeManager.class);

    /**
     * Get now datetime in Joda Time in String.
     * Format example: 2015-03-22T11:42:25.943Z
     * @return now in Joda Time
     */
    public static String getJodaNowInString() {
        String now = "";
        try {
            DateTime dateTime = new DateTime(DateTimeZone.UTC);
            now = dateTime.toString();
        } catch(Exception ex) {
            logger.error("Datetime error: " + ex);
        }
        return now;
    }

    /**
     * Get now datetime in Joda Time in long.
     * @return now in Joda Time
     */
    public static long getJodaNowInLong() {
        long datetime = 0;
        try {
            DateTime dateTime = new DateTime(DateTimeZone.UTC);
            datetime = dateTime.getMillis();
        } catch(Exception ex) {
            logger.error("Datetime error: " + ex);
        }
        return datetime;
    }

    /**
     * Get now datetime in Joda Time in String.
     * Format example: 2015-03-22T11:42:25.943Z
     * @return now in Joda Time
     */
    public static String getJodaDatetimeInString(long datetime) {
        String datetimeFormat = "";
        try {
            DateTime dateTime = new DateTime(datetime, DateTimeZone.UTC);
            datetimeFormat = dateTime.toString();
        } catch(Exception ex) {
            logger.error("Datetime error: " + ex);
        }
        return datetimeFormat;
    }

}

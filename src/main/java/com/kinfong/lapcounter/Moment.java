package com.kinfong.lapcounter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Class that simply captures a moment in time for use in the LapCounter app.
 * First run sets final static mFirstTimestamp to use to calculate the passage of time since start.
 *
 * Created by Kin on 8/8/13.
 */
public class Moment {

    private long mTimestamp;
    private final static long mFirstTimestamp = System.currentTimeMillis();
    private int mNumberOfTimestamps = 0;
    public static int mTotalNumberOfTimeStamps = 0;

    /**
     * Default constructor.
     * Captures current timestamp and increments total number of timestamps.
     */
    public Moment() {
        mTimestamp = System.currentTimeMillis();
        mTotalNumberOfTimeStamps++;
    }

    /**
     * Calculates the difference between the most recent timestamp and the first timestamp.
     * @return String time since first timestamp
     */
    public String getTimeSinceString() {
        long diff = mTimestamp - mFirstTimestamp;
        return mTotalNumberOfTimeStamps - mNumberOfTimestamps + ". " + convertTimestampToTimeString(diff);
    }

    /**
     * Method takes a timestamp and converts to String representation organized as a readable time.
     * @param timestamp
     * @return String converted timestamp
     */
    public String convertTimestampToTimeString(long timestamp) {
        DateFormat df = new SimpleDateFormat("HH' hours', mm' minutes', ss' seconds'");
        df.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        String currentTime = df.format(new Date(timestamp));
        return currentTime;
    }
}

package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar=new ArrayList<>(); // Stores all the meetings

    public ArrayList<Meeting> getCalendar() {
        return calendar;
    }

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId,2147483647);
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        getCalendar().add(meeting);
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
        Collections.sort(getCalendar(), (a, b) -> a.getEndTime().compareTo(b.getEndTime()));

        int cnt = 0;
        LocalTime endTime = LocalTime.of(0, 0);

        for (Meeting meet : getCalendar()) {
            if (meet.getStartTime().compareTo(endTime) >= 0) {
                // This meeting can be attended as it starts after the previous one ends
                endTime = meet.getEndTime();
                cnt++;
            }
        }

        return cnt;
    }
}

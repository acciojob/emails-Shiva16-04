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
        Collections.sort(getCalendar(), (a,b)->{
            return a.getStartTime().compareTo(b.getStartTime());
        });
        int cnt=0;
        LocalTime ps=LocalTime.of(0, 0);
        LocalTime pe=LocalTime.of(0,0);
        for(Meeting meet:getCalendar()){
            LocalTime i=meet.getStartTime();
            LocalTime j=meet.getEndTime();
            int comp1=pe.compareTo(i);
            int comp2=j.compareTo(pe);
            if(comp1>=0){
                if(comp2<0){
                    ps=i;
                    pe=j;
                }else{
                    ps=i;
                    pe=j;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings
    private static int maxCapacity = Integer.MAX_VALUE;
    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId, maxCapacity);
        this.calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
        int cnt = 1;

        ArrayList<Meeting> copyCalender = new ArrayList<>(List.copyOf(calendar));
        Collections.sort(copyCalender, (a,b) -> {
            return a.getEndTime().compareTo(b.getEndTime());
        });

        LocalTime prevEndTime = copyCalender.get(0).getEndTime();
        LocalTime prevStartTime = copyCalender.get(0).getStartTime();
        for (int i = 1; i < copyCalender.size(); i++) {
            LocalTime currStartTime = copyCalender.get(i).getStartTime();
            LocalTime currEndTime = copyCalender.get(i).getEndTime();
            if (currStartTime.compareTo(prevEndTime) > 0) {
                cnt++;
                prevEndTime = currEndTime;
                prevStartTime = currStartTime;
            }
        }
        return cnt;
    }
}

package com.example.barcamprefactored.dummy;

import android.support.v7.util.SortedList;

import com.example.barcamprefactored.ScheduleService;
import com.example.barcamprefactored.dto.Event;
import com.example.barcamprefactored.dto.ScheduleElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
//        for (int i = 1; i <= COUNT; i++) {
//            addItem(createDummyItem(i));  //we should call this addItem inside the onReponse callback of the request, and modify the DummyItem.DummyContent as needed to suite our preferences
//        }

//        final List<Workshop> events = new ArrayList<>();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://api.barcamp.am/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        ScheduleService service = retrofit.create(ScheduleService.class);
//
//        final Call<List<ScheduleElement>> scheduleCall = service.getSchedule();
//
//        //final retrofit2.Response<List<ScheduleElement>> schedule = null;
//
//        scheduleCall.enqueue(new Callback<List<ScheduleElement>>() {
//            @Override
//            public void onResponse(Call<List<ScheduleElement>> call, retrofit2.Response<List<ScheduleElement>> response) {
//                if (response.isSuccessful()) {
//                    System.out.println(response.body());
//                    //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//
//                    int count = 1;
//                    for(ScheduleElement scheduleElement: response.body()) {
//                        //if (count ==26) break;
//                        String speaker = (scheduleElement.getEn().getSpeaker()!=null) ? scheduleElement.getEn().getSpeaker() : "No Speaker Specified";
//                        String from = scheduleElement.getFrom().getDate();
//                        String to = scheduleElement.getTo().getDate();
//                        //String startsAt = from.format(formatter);
//                        String start = from.substring(0, from.lastIndexOf(':'));
//                        String finish = to.substring(0, to.lastIndexOf(':'));
//                        //System.out.println(start);
//                        //System.out.println(from);
//                        events.add(new Workshop(count+"", speaker, scheduleElement.getEn().getTopic()));
//                        DummyItem item = new DummyItem(String.valueOf(count), "Workshop " + count, "details", speaker, scheduleElement.getEn().getTopic(), start, finish, scheduleElement.getRoom());
//                        ITEMS.add(item);
//                        ITEM_MAP.put(String.valueOf(count), item);
//
//                        //addItem(count, new Workshop(speaker, scheduleElement.getEn().getTopic()));
//                        count++;
//                    }
//                    System.out.println("*******THE WORKSHOPS**********");
//                    System.out.println(events);
//                    System.out.println("*******THE WORKSHOPS**********");
//                    System.out.println("ITEMS IS: " + ITEMS);
//                    System.out.println("ITEM_MAP IS: " + ITEM_MAP);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<ScheduleElement>> call, Throwable t) {
//                System.out.println("FAILUREEEEEEEEEEEEEEEEEEEEEE");
//                System.out.println("THE CAUSE IS: " + t.getCause());
//            }
//        });
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

//    private static DummyItem createDummyItem(int position) {
//        return new DummyItem(String.valueOf(position), "Item " + position, makeDetails(position));
//    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;
        public final String speaker;
        public final String topic;
        public final String start;
        public final String finish;
        public final String room;

//        public DummyItem(String id, String content, String details) {
//            this.id = id;
//            this.content = content;
//            this.details = details;
//        }

        public DummyItem(String id, String content, String details, String speaker, String topic, String start, String finish, String room) {
            this.id = id;
            this.content = content;
            this.details = details;
            this.speaker = speaker;
            this.topic = topic;
            this.start = start;
            this.finish = finish;
            this.room = room;
        }

        @Override
        public String toString() {
            return content;
        }
    }

    /**
     * An object representing a single workshop
     * */
    public static class Workshop {
        public final String id;
        public final String speaker;
        public final String topic;

        public Workshop(String id, String speaker, String topic) {
            this.id = id;
            this.speaker = speaker;
            this.topic = topic;
        }

        @Override
        public String toString() {
            return "speaker: " + speaker + " topic: " + topic;
        }
    }
}

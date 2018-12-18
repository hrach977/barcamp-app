package com.example.barcamprefactored;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

import com.example.barcamprefactored.dummy.DummyContent;

/**
 * An activity representing a single Workshop detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link WorkshopListActivity}.
 */
public class WorkshopDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("inside WorkshopDetailActivity::onCreate");
        setContentView(R.layout.activity_workshop_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Stex pti notificationi pahy lini", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

//works for sure
                NotificationCompat.Builder builder = new NotificationCompat.Builder(WorkshopDetailActivity.this, "123")
                        .setContentTitle("Barcamp Unconference")
                        .setContentText("There is a workshop today, you are interested in")
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setTimeoutAfter(20000);

                System.out.println("going to show the notification");
//works for sure
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(WorkshopDetailActivity.this);
                notificationManager.notify(123, builder.build());
//works for sure

              //new version
//                NotificationCompat.Builder builder = new NotificationCompat.Builder(WorkshopDetailActivity.this, "123")
//                        .setContentText("BARCAMP NOTIFICATION")
//                        .setContentText("There is a cool workshop today!!!")
//                        .setTimeoutAfter(10000)
//                        .setSmallIcon(R.drawable.ic_launcher_background)
//                       // .setLargeIcon(((BitmapDrawable) WorkshopDetailActivity.this.getResources().getDrawable(R.drawable.ic_launcher_background)).getBitmap())
//                        .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
//
//                Intent intent = new Intent(WorkshopDetailActivity.this, WorkshopDetailActivity.class);
//                PendingIntent activity = PendingIntent.getActivity(WorkshopDetailActivity.this, 321, intent, PendingIntent.FLAG_CANCEL_CURRENT);
//                builder.setContentIntent(activity);
//
//                Notification notification = builder.build();
//
//                System.out.println("getting ready to show the notification");
//
//                Intent notificationIntent = new Intent(WorkshopDetailActivity.this, MyNotificationPublisher.class);
//                notificationIntent.putExtra(MyNotificationPublisher.NOTIFICATION_ID, 321);
//                notificationIntent.putExtra(MyNotificationPublisher.NOTIFICATION, notification);
//                PendingIntent pendingIntent = PendingIntent.getBroadcast(WorkshopDetailActivity.this, 321, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);
//                AlarmManager alarmManager = (AlarmManager) WorkshopDetailActivity.this.getSystemService(Context.ALARM_SERVICE);
//                alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, 5000, pendingIntent);
            }
        });


        //                Intent intent = new Intent(WorkshopDetailActivity.this, WorkshopDetailActivity.class);
//                PendingIntent activity = PendingIntent.getActivity(WorkshopDetailActivity.this, 123, intent, PendingIntent.FLAG_CANCEL_CURRENT);
//
//                Notification notification = builder.build();
//
//                AlarmManager alarmManager = (AlarmManager) WorkshopDetailActivity.this.getSystemService(Context.ALARM_SERVICE);
//                //alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, 1000);
//
//                NotificationManager notificationManager = (NotificationManager) WorkshopDetailActivity.this.getSystemService(Context.NOTIFICATION_SERVICE);
//
//                notificationManager.notify(123, notification);



        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(WorkshopDetailFragment.ARG_ITEM_ID,
                    getIntent().getStringExtra(WorkshopDetailFragment.ARG_ITEM_ID));
            WorkshopDetailFragment fragment = new WorkshopDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.workshop_detail_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            NavUtils.navigateUpTo(this, new Intent(this, WorkshopListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

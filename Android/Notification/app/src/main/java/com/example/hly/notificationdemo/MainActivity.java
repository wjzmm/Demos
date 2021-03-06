package com.example.hly.notificationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private NotificationCompatImpl mNotificationCompatImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TaskStackNotification.TAG, "MainActivity onCreat");
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        findViewById(R.id.normal).setOnClickListener(this);
        findViewById(R.id.bigtext).setOnClickListener(this);
        findViewById(R.id.inbox).setOnClickListener(this);
        findViewById(R.id.pic).setOnClickListener(this);
        findViewById(R.id.message).setOnClickListener(this);
        findViewById(R.id.custom).setOnClickListener(this);
        findViewById(R.id.task_stack).setOnClickListener(this);
        findViewById(R.id.process).setOnClickListener(this);
        findViewById(R.id.hands_up).setOnClickListener(this);
        findViewById(R.id.visible).setOnClickListener(this);


        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.custom_notification_big);
        FrameLayout layout = (FrameLayout)findViewById(R.id.expanded);
        View view = remoteViews.apply(this,layout);
        layout.addView(view);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.normal:
                mNotificationCompatImpl = new NormalNotification(MainActivity.this);
                break;
            case R.id.bigtext:
                mNotificationCompatImpl = new BigTextNotification(MainActivity.this);
                break;
            case R.id.inbox:
                mNotificationCompatImpl = new InBoxNotification(MainActivity.this);
                break;
            case R.id.pic:
                mNotificationCompatImpl = new PicNotification(MainActivity.this);
                break;
            case R.id.custom:
                mNotificationCompatImpl = new CustomNotification(MainActivity.this);
                break;
            case R.id.task_stack:
                mNotificationCompatImpl = new TaskStackNotification(MainActivity.this);
                break;
            case R.id.process:
                mNotificationCompatImpl = new ProcessNotification(MainActivity.this);
                break;
            case R.id.hands_up:
                mNotificationCompatImpl = new FloatNotification(MainActivity.this);
                break;
            case R.id.visible:
                mNotificationCompatImpl = new VisibleNotification(MainActivity.this);
                break;
            case R.id.message:
                mNotificationCompatImpl = new MessagingNotification(MainActivity.this);
                ((MessagingNotification)mNotificationCompatImpl).showTwo();
                break;
        }
        mNotificationCompatImpl.showNotification();
    }

    public interface NotificationCompatImpl {
        void showNotification();
    }
}

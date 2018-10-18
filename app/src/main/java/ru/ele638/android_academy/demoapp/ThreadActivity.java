package ru.ele638.android_academy.demoapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ThreadActivity extends AppCompatActivity {
    static Boolean side = false;
    Thread leftThread, rightThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
    }

    @Override
    public void onStart() {
        super.onStart();

        leftThread = new Thread(new LeftLeg());
        rightThread = new Thread(new RightLeg());
        leftThread.start();
        rightThread.start();
    }

    @Override
    protected void onStop() {
        leftThread.interrupt();
        rightThread.interrupt();
        super.onStop();
    }

    private static class LeftLeg implements Runnable {
        boolean isRunning = true;


        @Override
        synchronized public void run() {
            while (isRunning) {
                if (Thread.interrupted()) return;
                synchronized (side) {
                    if (!side) {
                        System.out.println("Left step");
                        side = true;
                    }
                }
            }
        }
    }

    private static class RightLeg implements Runnable {
        boolean isRunning = true;

        @Override
        public void run() {
            while (isRunning) {
                if (Thread.interrupted()) return;
                synchronized (side) {
                    if (side) {
                        System.out.println("Right step");
                        side = false;
                    }
                }
            }
        }

    }
}

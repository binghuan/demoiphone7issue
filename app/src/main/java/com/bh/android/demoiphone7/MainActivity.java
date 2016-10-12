package com.bh.android.demoiphone7;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    public static final String TAG = "MainActivity";
    public static final boolean DBG = false;

    private SensorManager mSensorManager = null;
    private Sensor mSensor = null;

    private Context mContext = null;

    private MediaPlayer mMediaPlayer = null;

    class MySensorEventListener implements SensorEventListener {

        @Override
        public void onSensorChanged(SensorEvent event) {
            if (DBG) Log.v(TAG, ">> onSensorChanged: " + event.values[0]);

            if (event.values[0] == 0) {

                if (mMediaPlayer == null) {
                    mMediaPlayer = MediaPlayer.create(mContext, R.raw.noise);
                    mMediaPlayer.setLooping(true);
                }

                // Ready to play sound
                if (!mMediaPlayer.isPlaying()) {
                    mMediaPlayer.start();
                }

            } else {
                // Ready to play sound
                if (mMediaPlayer != null) {
                    mMediaPlayer.stop();
                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }

    private MySensorEventListener mMySensorEventListener = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DBG) Log.v(TAG, ">> onCreate");

        if (mContext == null) {
            mContext = this;
        }

        setContentView(R.layout.activity_main);

        if (mSensorManager == null) {
            mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        }
        if (mSensor == null) {
            mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (DBG) Log.v(TAG, ">> onResume");

        if (mMySensorEventListener == null) {
            mMySensorEventListener = new MySensorEventListener();
        }
        mSensorManager.registerListener(mMySensorEventListener, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (DBG) Log.v(TAG, ">> onPause");
        mSensorManager.unregisterListener(mMySensorEventListener);
        mMySensorEventListener = null;

        // Try to stop playing sound
        if (mMediaPlayer != null & mMediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (DBG) Log.v(TAG, ">> onDestroy");
    }
}

package com.example.android.counterHomework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    // Class name for Log tag
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    // EditText view for the message
    private EditText mMessageEditText;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }
    /**
     * Maintains the Activity state across configuration changes.
     *
     * @param outState Activity state data to save
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mMessageEditText.getVisibility() == View.VISIBLE) {
            outState.putBoolean("edit_text", true);
            outState.putString("edit_text", mMessageEditText.getText().toString());
        }
    }

    /**
     * Initializes the activity.
     *
     * @param savedInstanceState The current state data
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = findViewById(R.id.show_count);



        // Log the start of the onCreate() method.
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");

        // Initialize all the view variables.
        mMessageEditText = findViewById(R.id.editText_main);


        // Restore the state.
        if (savedInstanceState != null) {
            boolean isVisible = savedInstanceState
                    .getBoolean("reply_visible");
            if (isVisible) {
                mMessageEditText.setVisibility(View.VISIBLE);
                mMessageEditText.setText(savedInstanceState
                        .getString("reply_text"));

            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
}

package com.kinfong.lapcounter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * MainActivity class. Sets up GUI with button to start and collect times.
 */
public class MainActivity extends Activity {

    private LinearLayout mLayout;
    public Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLayout = (LinearLayout) findViewById(R.id.mainView);

        mButton = new Button(this);
        mButton.setText("Start");

        mButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                mButton.setText(String.valueOf(Moment.mTotalNumberOfTimeStamps + " total laps"));
                Moment m = new Moment();
                mLayout.addView(createNewTextView(m));
            }
        });

        mLayout.addView(mButton);
    }

    /**
     * Creates new TextView based on new moment.
     * @param myMoment
     * @return TextView new TextView from myMoment
     */
    private TextView createNewTextView(Moment myMoment) {
        TextView textView = new TextView(this);
        textView.setText(myMoment.getTimeSinceString());
        return textView;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

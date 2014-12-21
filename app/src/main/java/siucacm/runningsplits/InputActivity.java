package siucacm.runningsplits;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InputActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        /*
        Intent activityThatCalled = getIntent();
        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");
        TextView callingActivityMessage = (TextView) findViewById(R.id.calling_activity_info_text_view);
        callingActivityMessage.append(" " + previousActivity);
        */
    }

    public void onSendUsersName(View view) {

        EditText trackSizeET = (EditText) findViewById(R.id.track_size_edit_text);
        EditText targetTimeET = (EditText) findViewById(R.id.target_time_edit_text);
        EditText targetDistanceET = (EditText) findViewById(R.id.target_distance_edit_text);

        String trackSize = String.valueOf(trackSizeET.getText());
        String targetDistance = String.valueOf(targetDistanceET.getText());
        String targetTime = String.valueOf(targetTimeET.getText());

        Intent goingBack = new Intent();

        goingBack.putExtra("TrackSize",trackSize);
        goingBack.putExtra("TargetDistance",targetDistance);
        goingBack.putExtra("TargetTime",targetTime);

        setResult(RESULT_OK, goingBack);

        finish();
    }
}

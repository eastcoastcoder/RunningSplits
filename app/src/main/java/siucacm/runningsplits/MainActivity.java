package siucacm.runningsplits;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //OnIntent: what I want to do, how to do it, go do it
    public void onGetNameClick(View view) {

        Intent getNameScreenIntent = new Intent(this, InputActivity.class);

        final int result = 1;

        getNameScreenIntent.putExtra("callingActivity", "MainActivity");

        startActivityForResult(getNameScreenIntent, result);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView lapCount = (TextView) findViewById(R.id.lap_count);

        RunningModel m = new RunningModel();
        String trackSizeSentBack = data.getStringExtra("TrackSize");
        String targetDistanceSentBack = data.getStringExtra("TargetDistance");
        String targetTimeSentBack = data.getStringExtra("TargetTime");

        m.setTrackSize(Integer.parseInt(trackSizeSentBack));
        m.setDistance(Integer.parseInt(targetDistanceSentBack));
        m.calcNumberLaps();

        lapCount.append(" " + m.getNumberLaps() + ":");

        /* Dealing With Time:
        calc.setTotalTime(targetTimeSentBack);
        calc.calcLapSeconds();
        calc.calcLapTime();
        //calc.getLapTime() + " or " + calc.getLapSeconds()

        //Lap Printer Needs to Populate A ListView
        calc.lapPrinter();
        */

    }

}
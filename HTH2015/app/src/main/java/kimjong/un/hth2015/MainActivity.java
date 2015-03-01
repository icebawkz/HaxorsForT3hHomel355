package kimjong.un.hth2015;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.TrafficStats;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

    SmsManager smsManager = SmsManager.getDefault();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView data_tutorial = (ImageView)findViewById(R.id.settings_screenshot);

        Button topleft =  (Button) (findViewById(R.id.button));
        topleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WebApp.class);
                intent.putExtra("website", "http://pranavbheda.github.io/HTH2015/index.html");
                startActivity(intent);
            }
        });

        Button topright = (Button) findViewById(R.id.button2);
        topright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tutorialintent = new Intent(MainActivity.this, WebApp.class);
                tutorialintent.putExtra("website", "https://www.youtube.com/watch?v=uaz8A9Bu-pA");
                startActivity(tutorialintent);
            }
        });

        ImageView HTHlogo = (ImageView)findViewById(R.id.imageView);
        HTHlogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logointent = new Intent(MainActivity.this, WebApp.class);
                logointent.putExtra("website", "http://hackforthehomeless.com");
                startActivity(logointent);
            }
        });

        Button numbers = (Button) findViewById(R.id.button3);
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numberIntent = new Intent(MainActivity.this, UsefulNumbers.class);
                startActivity(numberIntent);
            }
        });

        Button data = (Button) findViewById(R.id.data_usage);
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendText();
                // data_tutorial.setVisibility(View.VISIBLE);
                // startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS));
                // data_tutorial.setVisibility(View.GONE);
            }
        });
    }


    public void sendText(){
        long bytes_usage = TrafficStats.getTotalRxBytes() + TrafficStats.getTotalTxBytes();
        Log.v("sendText()", getTotalTxBytes + " " + getTotalRxBytes);
        smsManager.sendTextMessage("9164757254", null,
                    "Data Usage since last reboot: " + bytes_usage, null, null);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

    private String getMyPhoneNumber(){
        TelephonyManager mTelephonyMgr;
        mTelephonyMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        return mTelephonyMgr.getLine1Number();
    }

    private String getMy10DigitPhoneNumber(){
        String s = getMyPhoneNumber();
        return s.substring(2);
    }
}

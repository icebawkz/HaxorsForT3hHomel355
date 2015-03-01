package kimjong.un.hth2015;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.net.TrafficStats;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

    SmsManager smsManager = SmsManager.getDefault();
    SharedPreferences sharedpreferences;
    private boolean first_launch = true;
    private String phone_number = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView data_tutorial = (ImageView)findViewById(R.id.settings_screenshot);

        sharedpreferences = getApplicationContext().getSharedPreferences("HITH_PREFERENCES", Context.MODE_PRIVATE);

        if (sharedpreferences.contains("Phone_No"))
            phone_number = sharedpreferences.getString("Phone_No", "");


        if (sharedpreferences.contains("FirstLaunch"))
            first_launch = sharedpreferences.getBoolean("FirstLaunch", first_launch);

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
                tutorialintent.putExtra("website", "http://i.imgur.com//5c22RvF.gif");
                startActivity(tutorialintent);
            }
        });

        ImageView HTHlogo = (ImageView)findViewById(R.id.imageView);
        HTHlogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logointent = new Intent(MainActivity.this, WebApp.class);
                logointent.putExtra("website", "http://acm.engr.scu.edu/h4h/index.html");
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
            }
        });
    }


    public void sendText(){

            firstLaunch();
            long bytes_usage = TrafficStats.getTotalRxBytes();
            Log.v("sendText()", TrafficStats.getTotalTxBytes() + " " + TrafficStats.getTotalRxBytes());
            smsManager.sendTextMessage(phone_number, null,
                        "Data Usage since last reboot: " + bytes_usage/100000 + "MB", null, null);
//
//        firstLaunch();
//        long bytes_usage = TrafficStats.getTotalRxBytes();
//        Log.v("sendText()", TrafficStats.getTotalTxBytes() + " " + TrafficStats.getTotalRxBytes());
//        smsManager.sendTextMessage("9164757254", null,
//                    "Data Usage since last reboot: " + bytes_usage/100000 + "MB", null, null);

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

    private void firstLaunch(){

        SharedPreferences.Editor editor = sharedpreferences.edit();


        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        Log.v("firstLaunch()", "Initialized SharedPreferences and AlertDialog");
        alert.setMessage("Enter your phone number");
        final EditText phone = new EditText(this);
        phone.setInputType(InputType.TYPE_CLASS_PHONE);
        phone.setHint("10 Digit Phone Number");
        alert.setView(phone);
        alert.setPositiveButton("Ok", null);
        alert.setNegativeButton("Cancel", null);
        alert.show();

        Log.v("firstLaunch()", "Rendered and Set View");
        phone_number = phone.getText().toString();

        editor.putString("Phone_No", phone_number);
        editor.putBoolean("FirstLaunch", false);
        editor.commit();

    }
}

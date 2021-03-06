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
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    double total_bytes_month= 0;
    int counter_days = 29;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                tutorialintent.putExtra("website", "https://www.youtube.com/watch?v=mD5RDFsPDTo");
                startActivity(tutorialintent);
            }
        });

        ImageView HTHlogo = (ImageView)findViewById(R.id.imageView);
        HTHlogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logointent = new Intent(MainActivity.this, WebApp.class);
                logointent.putExtra("website", "http://www.ctagroup.org");
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
                total_bytes_month = 600000;
                long bytes_usage = TrafficStats.getTotalRxBytes();
                total_bytes_month += bytes_usage;
                counter_days++;
                if (counter_days == 30){
                    Toast.makeText(getApplicationContext(), "Data Usage over the last 30 checks: " + total_bytes_month / 100000 + "MB", Toast.LENGTH_LONG).show();
                    Log.v("data button", "is " + total_bytes_month/100000);
                    counter_days = 0;
                }else
                    Toast.makeText(getApplicationContext(), "Data Usage since last reboot: " + bytes_usage/100000 + "MB", Toast.LENGTH_LONG).show();
            }
        });
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
}

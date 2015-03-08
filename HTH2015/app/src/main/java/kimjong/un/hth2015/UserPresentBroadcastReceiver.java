package kimjong.un.hth2015;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

/**
 * Created by Alex on 2/16/2015.
 */
public class UserPresentBroadcastReceiver extends BroadcastReceiver {

    public UserPresentBroadcastReceiver(){}

    Context mContext;
    public UserPresentBroadcastReceiver(Context mContext){
        this.mContext = mContext;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_USER_PRESENT)){


//            WifiManager wifi = (WifiManager)mContext.getSystemService(Context.WIFI_SERVICE);
//            Log.v("UserPresentBroadcast","Started WifiManager");
//            if (!wifi.isWifiEnabled()){
//                Log.v("UserPresentBroadcast", "Wifi should be enabled");
//                wifi.setWifiEnabled(true);

            //}
        }

    }
}

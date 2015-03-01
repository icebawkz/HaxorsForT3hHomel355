package kimjong.un.hth2015;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

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

            
//            NotificationManager notificationManager = (NotificationManager) context
//                    .getSystemService(Context.NOTIFICATION_SERVICE);
//            Notification notification = new Notification(android.R.drawable.stat_notify_more, "Would you like to draw something?", System.currentTimeMillis());
//
//            Intent notificationIntent = new Intent(context, MainActivity.class);
//
//            notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
//                    | Intent.FLAG_ACTIVITY_SINGLE_TOP);
//
//            PendingIntent Pintent = PendingIntent.getActivity(context, 0,
//                    notificationIntent, 0);
//
//            notification.setLatestEventInfo(context, "ArtTherapy", "Would you like to draw something?", Pintent);
//            notification.flags |= Notification.FLAG_AUTO_CANCEL;
//            notificationManager.notify(0, notification);
        }

    }
}

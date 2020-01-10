package cordova.plugin.raqmiyat.custom.notification;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;

import android.app.AlertDialog;
import android.app.Application;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import io.ionic.starter.R;

/**
 * This class echoes a string called from JavaScript.
 */
public class CustomNotification extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("showAlert")) {
            JSONObject arg_object = args.getJSONObject(0);
            
            Application app=cordova.getActivity().getApplication();
            String package_name = app.getPackageName();
            Resources resources = app.getResources();

            int layoutID = resources.getIdentifier("my_dialog", "layout", package_name);
            int header = resources.getIdentifier("header_section", "id", package_name);
            int titleID = resources.getIdentifier("title", "id", package_name);
            int messageID = resources.getIdentifier("message", "id", package_name);
            int btnID = resources.getIdentifier("ok_button", "id", package_name);

            LayoutInflater inflater = cordova.getActivity().getLayoutInflater();
            final View customLayout = inflater.inflate(layoutID, null);

            TextView title = (TextView) customLayout.findViewById(titleID);
            title.setText(arg_object.getString("title"));

            TextView message = (TextView) customLayout.findViewById(messageID);
            message.setText(arg_object.getString("message"));

            RelativeLayout rel = (RelativeLayout) customLayout.findViewById(header);
            rel.setBackgroundColor(Color.parseColor(arg_object.getString("headerColor")));

            Button btn = (Button) customLayout.findViewById(btnID);
            btn.setText("OK");
            btn.setBackgroundColor(Color.parseColor(arg_object.getString("btnColor")));

            AlertDialog dialog = new AlertDialog.Builder(this.cordova.getActivity(), AlertDialog.THEME_HOLO_LIGHT).create();
            dialog.setView(customLayout);
            dialog.show();

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            callbackContext.success("<<<<<<<Notifcation success>>>>>");
            return true;
        }
        callbackContext.error("Expected one non-empty string argument.");
        return false;
    }
}

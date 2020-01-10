package cordova-plugin-raqmiyat-custom-notification;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import android.app.AlertDialog;
import android.content.DialogInterface;
import org.json.JSONException;

/**
 * This class echoes a string called from JavaScript.
 */
public class CustomNotification extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("displayNotification")) {
            
            AlertDialog.Builder dialog = new AlertDialog.Builder(this.cordova.getActivity());
            dialog.setTitle("Succcess");
            dialog.setMessage("You are successfully created a custom notification!");

            dialog.setPositiveButton("CLOSE", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int id) {
                    //do thing
                }
            });

            dialog.show();

            callbackContext.success("success");
            return true;
        }
        callbackContext.error("Expected one non-empty string argument.");
        return false;
    }
}

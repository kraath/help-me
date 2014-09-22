package com.example.Help_me;

import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.push.PushManager;

import android.app.Application;

public class GlobalClass extends Application{
    
    private String name;
    private String email;
     


	@Override
	public void onCreate(){

		AirshipConfigOptions options = AirshipConfigOptions.loadDefaultOptions(this);
		options.developmentAppKey = "rQWMxUXhQqu1hAyN3G2nFA";
		options.developmentAppSecret = "mbaZsC-fRSCf2y-2ro4KEw";
		options.pushServiceEnabled = true;
		options.inProduction = false;
		UAirship.takeOff(this, options);
		PushManager.enablePush();

		PushManager.shared().setIntentReceiver(IntentReceiver.class);

		String apid = PushManager.shared().getAPID();
		Logger.info("My Application onCreate - App APID: " + apid);
	}
    public String getName() {
         
        return name;
    }
     
    public void setName(String aName) {
        
       name = aName;
         
    }
    
    public String getEmail() {
         
        return email;
    }
     
    public void setEmail(String aEmail) {
        
      email = aEmail;
    }
 
}
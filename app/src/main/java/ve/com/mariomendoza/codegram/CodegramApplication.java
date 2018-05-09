package ve.com.mariomendoza.codegram;

import android.app.Application;

import com.facebook.FacebookSdk;

public class CodegramApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        FacebookSdk.sdkInitialize(getApplicationContext());

    }



}

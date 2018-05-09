package ve.com.mariomendoza.codegram.login.interactor;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;

public interface LoginInteractor {
    void SingIn(String username, String password, Activity activity,FirebaseAuth firebaseAuth);
}

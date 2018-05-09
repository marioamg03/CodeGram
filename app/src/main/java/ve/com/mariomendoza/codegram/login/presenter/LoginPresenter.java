package ve.com.mariomendoza.codegram.login.presenter;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;

public interface LoginPresenter {
    void SingIn(String username, String password, Activity activity,FirebaseAuth firebaseAuth);
    void loginSuccess();
    void loginError(String error);
}

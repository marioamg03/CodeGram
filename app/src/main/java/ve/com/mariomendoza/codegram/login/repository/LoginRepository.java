package ve.com.mariomendoza.codegram.login.repository;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;


public interface LoginRepository {
    void SignIn(String username, String password, Activity activity,FirebaseAuth firebaseAuth);
}

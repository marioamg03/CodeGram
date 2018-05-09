package ve.com.mariomendoza.codegram.login.repository;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import ve.com.mariomendoza.codegram.login.presenter.LoginPresenter;

public class LoginRepositoryImpl implements LoginRepository {

    LoginPresenter loginPresenter;

    public LoginRepositoryImpl(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }

    @Override
    public void SignIn(String username, String password, Activity activity,FirebaseAuth firebaseAuth) {

        firebaseAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    loginPresenter.loginSuccess();
                } else {
                    loginPresenter.loginError("Ocurrió un Error");
                }
            }
        });
    }
}

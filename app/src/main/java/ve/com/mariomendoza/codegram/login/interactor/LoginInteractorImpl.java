package ve.com.mariomendoza.codegram.login.interactor;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;

import ve.com.mariomendoza.codegram.login.presenter.LoginPresenter;
import ve.com.mariomendoza.codegram.login.repository.LoginRepository;
import ve.com.mariomendoza.codegram.login.repository.LoginRepositoryImpl;

/**
 * Created by PC 4 on 31/3/2018.
 */

public class LoginInteractorImpl implements LoginInteractor{

    private LoginPresenter loginPresenter;
    private LoginRepository loginRepository;

    public LoginInteractorImpl(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
        loginRepository = new LoginRepositoryImpl(loginPresenter);
    }

    @Override
    public void SingIn(String username, String password, Activity activity,FirebaseAuth firebaseAuth) {
        loginRepository.SignIn(username,password,activity,firebaseAuth);
    }
}

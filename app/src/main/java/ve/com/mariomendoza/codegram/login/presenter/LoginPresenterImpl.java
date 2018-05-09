package ve.com.mariomendoza.codegram.login.presenter;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;

import ve.com.mariomendoza.codegram.login.interactor.LoginInteractor;
import ve.com.mariomendoza.codegram.login.interactor.LoginInteractorImpl;
import ve.com.mariomendoza.codegram.login.view.LoginView;

public class LoginPresenterImpl implements LoginPresenter{

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        loginInteractor = new LoginInteractorImpl(this);
    }

    @Override
    public void SingIn(String username, String password, Activity activity,FirebaseAuth firebaseAuth) {
        loginView.disableInputs();
        loginView.showProgressBar();
        loginInteractor.SingIn(username,password,activity,firebaseAuth);
    }

    @Override
    public void loginSuccess() {
        loginView.hideProgressBar();
        loginView.goHome();
    }

    @Override
    public void loginError(String error) {
        loginView.enableInputs();
        loginView.hideProgressBar();
        loginView.loginError(error);
    }
}

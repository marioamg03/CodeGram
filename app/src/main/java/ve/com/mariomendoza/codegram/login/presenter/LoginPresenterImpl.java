package ve.com.mariomendoza.codegram.login.presenter;

import ve.com.mariomendoza.codegram.login.interactor.LoginInteractor;
import ve.com.mariomendoza.codegram.login.interactor.LoginInteractorImpl;
import ve.com.mariomendoza.codegram.login.view.LoginView;

/**
 * Created by PC 4 on 31/3/2018.
 */

public class LoginPresenterImpl implements LoginPresenter{

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        loginInteractor = new LoginInteractorImpl(this);
    }

    @Override
    public void SingIn(String username, String password) {
        loginInteractor.SingIn(username,password);
    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public void loginError() {

    }
}

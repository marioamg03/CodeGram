package ve.com.mariomendoza.codegram.login.interactor;

import ve.com.mariomendoza.codegram.login.presenter.LoginPresenter;

/**
 * Created by PC 4 on 31/3/2018.
 */

public class LoginInteractorImpl implements LoginInteractor{

    private LoginPresenter loginPresenter;

    public LoginInteractorImpl(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }

    @Override
    public void SingIn(String username, String password) {

    }
}

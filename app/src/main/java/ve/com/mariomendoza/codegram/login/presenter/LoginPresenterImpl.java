package ve.com.mariomendoza.codegram.login.presenter;

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
    public void SingIn(String username, String password) {
        loginView.disableInputs();
        loginView.showProgressBar();
        loginInteractor.SingIn(username,password);
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

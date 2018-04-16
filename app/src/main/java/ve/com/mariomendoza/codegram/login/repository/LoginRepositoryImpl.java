package ve.com.mariomendoza.codegram.login.repository;

import ve.com.mariomendoza.codegram.login.presenter.LoginPresenter;

/**
 * Created by PC 4 on 31/3/2018.
 */

public class LoginRepositoryImpl implements LoginRepository {

    LoginPresenter loginPresenter;

    public LoginRepositoryImpl(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }

    @Override
    public void SignIn(String username, String password) {
        boolean success = true;

        if ( success ){
            loginPresenter.loginSuccess();
        }else{
            loginPresenter.loginError("Ocurrió un Error");
        }


    }
}

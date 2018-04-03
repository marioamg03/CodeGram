package ve.com.mariomendoza.codegram.login.presenter;

public interface LoginPresenter {
    void SingIn(String username,String password);
    void loginSuccess();
    void loginError(String error);
}

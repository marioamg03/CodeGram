package ve.com.mariomendoza.codegram.login.view;

public interface LoginView {

    void enableInputs();
    void disableInputs();

    void showProgressBar();
    void hideProgressBar();

    void loginError();

    void goCreateAccount();
    void goHome();
}

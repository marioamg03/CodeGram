package ve.com.mariomendoza.codegram.login.view;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import ve.com.mariomendoza.codegram.R;
import ve.com.mariomendoza.codegram.login.presenter.LoginPresenter;
import ve.com.mariomendoza.codegram.login.presenter.LoginPresenterImpl;
import ve.com.mariomendoza.codegram.view.ContainerActivity;
import ve.com.mariomendoza.codegram.view.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements LoginView{


    private TextInputEditText user_name, password;
    private ProgressBar progressLogin;

    private TextView reg_editext;
    private Button login_button;
    private ImageView logo;

    private LoginPresenter loginPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPresenter = new LoginPresenterImpl(this);

        user_name = (TextInputEditText) findViewById(R.id.username);
        password = (TextInputEditText) findViewById(R.id.password);

        progressLogin = (ProgressBar) findViewById(R.id.progressbarLogin);
        hideProgressBar();

        reg_editext = (TextView) findViewById(R.id.createHere);
        reg_editext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goCreateAccount();
            }
        });

        login_button = (Button) findViewById(R.id.login_btn);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.SingIn(user_name.getText().toString(),password.getText().toString());
            }
        });

        logo = (ImageView) findViewById(R.id.logo);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://www.mariomendoza.com.ve";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


    }

    @Override
    public void enableInputs() {
        user_name.setEnabled(true);
        password.setEnabled(true);
        login_button.setEnabled(true);
    }

    @Override
    public void disableInputs() {
        user_name.setEnabled(false);
        password.setEnabled(false);
        login_button.setEnabled(false);
    }

    @Override
    public void showProgressBar() {
        progressLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressLogin.setVisibility(View.GONE);
    }

    @Override
    public void loginError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goCreateAccount() {
        Intent reg_intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(reg_intent);
    }

    @Override
    public void goHome() {
        Intent home_intent = new Intent(LoginActivity.this, ContainerActivity.class);
        startActivity(home_intent);
    }
}

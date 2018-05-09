package ve.com.mariomendoza.codegram.login.view;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.Login;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;

import java.lang.reflect.Array;
import java.util.Arrays;

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
    private LoginButton loginFacebook;
    private ImageView logo;

    private LoginPresenter loginPresenter;

    private CallbackManager callbackManager;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

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

        loginFacebook.setReadPermissions(Arrays.asList("email"));
        loginFacebook = (LoginButton) findViewById(R.id.login_facebook);
        loginFacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.w("FACEBOOK","Logueo de Facebook Exitoso " + loginResult.getAccessToken().getApplicationId());
                signInFacebookFirebase(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Log.w("FACEBOOK","Logueo de Facebook Cancelado");
            }

            @Override
            public void onError(FacebookException error) {
                Log.w("FACEBOOK","OCURRIO UN ERROR CODIGO: " + error.toString());
                error.printStackTrace();
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

    private void signInFacebookFirebase(AccessToken accessToken) {
        AuthCredential authCredential = FacebookAuthProvider.getCredential(accessToken.getToken());
        firebaseAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    goHome();
                    Toast.makeText(LoginActivity.this, "Login Facebook Exitoso!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Login Facebook Erroneo!", Toast.LENGTH_SHORT).show();
                }
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

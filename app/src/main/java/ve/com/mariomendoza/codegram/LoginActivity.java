package ve.com.mariomendoza.codegram;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import ve.com.mariomendoza.codegram.view.ContainerActivity;
import ve.com.mariomendoza.codegram.view.RegisterActivity;

public class LoginActivity extends AppCompatActivity {

    private TextView reg_editext;
    private Button login_button;
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        reg_editext = (TextView) findViewById(R.id.createHere);
        reg_editext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reg_intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(reg_intent);
            }
        });

        login_button = (Button) findViewById(R.id.login_btn);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home_intent = new Intent(LoginActivity.this, ContainerActivity.class);
                startActivity(home_intent);
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
}

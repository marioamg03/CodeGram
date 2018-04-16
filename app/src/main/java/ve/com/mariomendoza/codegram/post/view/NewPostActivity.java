package ve.com.mariomendoza.codegram.post.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import ve.com.mariomendoza.codegram.R;

public class NewPostActivity extends AppCompatActivity {

    private ImageView imageViewPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        imageViewPhoto = (ImageView) findViewById(R.id.imgPhoto);
        if(getIntent().getExtras() != null){
            String photoPath = getIntent().getExtras().getString("PHOTO_PATH_TEMP");
            Picasso.with(this).load(photoPath).into(imageViewPhoto);
        }



    }
}

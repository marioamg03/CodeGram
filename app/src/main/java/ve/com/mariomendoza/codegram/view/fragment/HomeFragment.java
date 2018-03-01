package ve.com.mariomendoza.codegram.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import ve.com.mariomendoza.codegram.R;
import ve.com.mariomendoza.codegram.adapter.PictureAdapterRecyclerView;
import ve.com.mariomendoza.codegram.model.Picture;

public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar("Home",false, view);
        RecyclerView pictureRecycler = (RecyclerView) view.findViewById(R.id.pictureRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        pictureRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecyclerView pictureAdapterRecyclerView =
                new PictureAdapterRecyclerView(buildPictures(),R.layout.cardview_picture,getActivity());
        pictureRecycler.setAdapter(pictureAdapterRecyclerView);


        return view;
    }

    public ArrayList <Picture> buildPictures(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("https://www.marketingdirecto.com/wp-content/uploads/2015/08/londres-2.jpg","Mario Mendoza","3 días","12"));
        pictures.add(new Picture("http://cadenaser00.epimg.net/ser/imagenes/2017/07/07/internacional/1499423602_279221_1499424341_noticia_normal.jpg","Carlos Sionchez","5 días","-4"));
        pictures.add(new Picture("http://insights.la/wp-content/uploads/2015/08/g5-620x400.jpg","Liliana Colls","7 días","125"));
        return  pictures;
    }




    public void showToolbar(String title, boolean upButton,View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}

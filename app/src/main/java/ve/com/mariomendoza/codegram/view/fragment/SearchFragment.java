package ve.com.mariomendoza.codegram.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ve.com.mariomendoza.codegram.R;
import ve.com.mariomendoza.codegram.adapter.PictureAdapterRecyclerView;
import ve.com.mariomendoza.codegram.model.Picture;
import ve.com.mariomendoza.codegram.view.SpacesItemDecoration;

public class SearchFragment extends Fragment {


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        RecyclerView pictureRecycler = (RecyclerView) view.findViewById(R.id.searchRecycler);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2,LinearLayoutManager.VERTICAL,false);

        pictureRecycler.setLayoutManager(gridLayoutManager);

        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
        pictureRecycler.addItemDecoration(new SpacesItemDecoration(spacingInPixels));

        PictureAdapterRecyclerView pictureAdapterRecyclerView =
                new PictureAdapterRecyclerView(buildPictures(),R.layout.cardview_picture,getActivity());
        pictureRecycler.setAdapter(pictureAdapterRecyclerView);

        return view;
    }

    public ArrayList<Picture> buildPictures(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("https://online.cenapec.edu.do/sites/cenapec/files/field_imagen_de_cabecera/programacion_web.jpg","Mario Mendoza","3 días","12"));
        pictures.add(new Picture("https://www.seas.es/sites/seas/files/field_imagen_de_cabecera/c_programacionc.jpg","Carlos Sionchez","5 días","-4"));
        pictures.add(new Picture("http://increaconcept.es/tienda/311-home_default/sistemas-de-almacenamiento.jpg","Liliana Colls","7 días","125"));
        pictures.add(new Picture("https://www.marketingdirecto.com/wp-content/uploads/2015/08/londres-2.jpg","Mario Mendoza","3 días","12"));
        pictures.add(new Picture("http://cadenaser00.epimg.net/ser/imagenes/2017/07/07/internacional/1499423602_279221_1499424341_noticia_normal.jpg","Carlos Sionchez","5 días","-4"));
        pictures.add(new Picture("http://insights.la/wp-content/uploads/2015/08/g5-620x400.jpg","Liliana Colls","7 días","125"));
        pictures.add(new Picture("https://www.marketingdirecto.com/wp-content/uploads/2015/08/londres-2.jpg","Mario Mendoza","3 días","12"));
        pictures.add(new Picture("http://cadenaser00.epimg.net/ser/imagenes/2017/07/07/internacional/1499423602_279221_1499424341_noticia_normal.jpg","Carlos Sionchez","5 días","-4"));
        pictures.add(new Picture("http://insights.la/wp-content/uploads/2015/08/g5-620x400.jpg","Liliana Colls","7 días","125"));
        return  pictures;
    }
}

package com.example.nguyenquanghuy_1911505310224.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.example.nguyenquanghuy_1911505310224.Activity.Activity_BaiHat;
import com.example.nguyenquanghuy_1911505310224.Adapter.CasiAdapter;
import com.example.nguyenquanghuy_1911505310224.Model.Casi;
import com.example.nguyenquanghuy_1911505310224.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Home extends Fragment {
    View view;
    ViewFlipper viewFlipper;
    ListView listViewCasi;
    ArrayList<Casi> arrayListCasi;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,container,false);
        AnhXa();
        ActionViewFlipper();
        return view;
    }



    private void AnhXa() {
        viewFlipper = view.findViewById(R.id.viewflipper);
        listViewCasi = view.findViewById(R.id.listViewCasi);
        arrayListCasi = new ArrayList<>();

        arrayListCasi.add(new Casi("DIMZ", R.drawable.dimz));
        arrayListCasi.add(new Casi("Đình Dũng", R.drawable.dinhdung));
        arrayListCasi.add(new Casi("Phát Huy", R.drawable.phathuy));
        arrayListCasi.add(new Casi("Sơn Tùng", R.drawable.sontung));
        arrayListCasi.add(new Casi("Jack", R.drawable.jack));
        arrayListCasi.add(new Casi("Thiên Tú", R.drawable.thientu));
        arrayListCasi.add(new Casi("Nhật Phong", R.drawable.nhatphong));
        arrayListCasi.add(new Casi("Đinh Đại Vũ", R.drawable.dinhdaivu));
        CasiAdapter casiAdapter = new CasiAdapter(getActivity(),R.layout.list_casi,arrayListCasi);
        listViewCasi.setAdapter(casiAdapter);

        listViewCasi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), Activity_BaiHat.class);
                intent.putExtra("position",i);
                intent.putExtra("tencasi",arrayListCasi.get(i).ten_casi);
                startActivity(intent);
            }
        });
    }


    private void ActionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://znews-photo.zadn.vn/w660/Uploaded/bpcbzivo/2021_05_21/1.jpg");
        mangquangcao.add("https://media-cdn.laodong.vn/storage/newsportal/2019/7/1/741910/Stg02291-15619849253.jpg");
        mangquangcao.add("https://i.ytimg.com/vi/JBj-4at3QwQ/maxresdefault.jpg");
        mangquangcao.add("https://files.wallpaperpass.com/2019/10/synthwave%20wallpaper%20020%20-%201920x1080.jpg");
        mangquangcao.add("https://files.wallpaperpass.com/2019/10/synthwave%20wallpaper%20026%20-%201920x1079.jpg");
        for(int i =0; i<mangquangcao.size();i++){
            ImageView imageView = new ImageView(getContext());
            Picasso.get().load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getActivity(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }
}

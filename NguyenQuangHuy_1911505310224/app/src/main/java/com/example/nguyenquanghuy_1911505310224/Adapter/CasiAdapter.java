package com.example.nguyenquanghuy_1911505310224.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nguyenquanghuy_1911505310224.Model.Casi;
import com.example.nguyenquanghuy_1911505310224.R;

import java.util.ArrayList;
import java.util.List;

public class CasiAdapter extends BaseAdapter {
    Context context;
    int mlayout;
    List<Casi> mListCasi;

    public CasiAdapter(Context context, int mlayout, List<Casi> mListCasi) {
        this.context = context;
        this.mlayout = mlayout;
        this.mListCasi = mListCasi;
    }

    @Override
    public int getCount() {
        return mListCasi.size();
    }

    @Override
    public Object getItem(int i) {
        return mListCasi.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        view = inflater.inflate(mlayout,null);

        //Ánh xạ
        ImageView imgcs = view.findViewById(R.id.imageCasi);
        imgcs.setImageResource(mListCasi.get(i).hinh_casi);

        TextView txtTenCS = view.findViewById(R.id.tvTenCS);
        txtTenCS.setText(mListCasi.get(i).ten_casi);
        return view;
    }
}

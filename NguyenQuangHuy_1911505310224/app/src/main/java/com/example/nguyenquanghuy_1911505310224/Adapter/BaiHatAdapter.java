package com.example.nguyenquanghuy_1911505310224.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.nguyenquanghuy_1911505310224.Model.BaiHat;
import com.example.nguyenquanghuy_1911505310224.R;

import java.util.List;

public class BaiHatAdapter extends BaseAdapter {
    Context context;
    int mlayout;
    List<BaiHat> listBaiHat;

    public BaiHatAdapter(Context context, int mlayout, List<BaiHat> listBaiHat) {
        this.context = context;
        this.mlayout = mlayout;
        this.listBaiHat = listBaiHat;
    }

    @Override
    public int getCount() {
        return listBaiHat.size();
    }

    @Override
    public Object getItem(int i) {
        return listBaiHat.get(i);
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
        TextView tvTenBH = view.findViewById(R.id.tvTenBH);
        tvTenBH.setText(listBaiHat.get(i).tenbaihat);
        TextView tvTime = view.findViewById(R.id.tvtime);
        tvTime.setText(listBaiHat.get(i).tgbaihat);

        return view;
    }
}

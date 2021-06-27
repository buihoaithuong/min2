package com.example.min2;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class thoiTietAdapter extends BaseAdapter {
    private Context context;
    private int Layout;
    List<thoiTiet> ThoiTietList;

    public thoiTietAdapter(Context context, int layout, List<thoiTiet> thoiTietList) {
        this.context = context;
        Layout = layout;
        ThoiTietList = thoiTietList;
    }

    @Override
    public int getCount() {
        return ThoiTietList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(Layout, null);

        // ánh xạ view
        TextView txt1 = (TextView) convertView.findViewById(R.id.textView1);
        TextView txt2 = (TextView) convertView.findViewById(R.id.textView2);
        ImageView img = (ImageView) convertView.findViewById(R.id.imageView);

        // gán giá trị
        thoiTiet thoiTiet = ThoiTietList.get(position);
        txt1.setText(thoiTiet.getNgay());
        txt2.setText(thoiTiet.getNhiet());
        img.setImageResource(thoiTiet.getImg());

        return convertView;
    }
}

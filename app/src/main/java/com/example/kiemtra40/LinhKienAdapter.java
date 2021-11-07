package com.example.kiemtra40;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class LinhKienAdapter extends ArrayAdapter<LinhKien> {

        private Context mContext;
        private int mResource;
                                                                    //I want to use ArrayLists LinhKien[]
    public LinhKienAdapter(@NonNull Context context, int resource, @NonNull ArrayList<LinhKien> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource, parent, false);

        ImageView imageView = convertView.findViewById(R.id.img);

        TextView txtten = convertView.findViewById(R.id.TxtTen);

        TextView txtgia = convertView.findViewById(R.id.TxtDong);

        imageView.setImageResource(getItem(position).getAnh());

        txtten.setText(getItem(position).getTen());

        txtgia.setText(getItem(position).getGia());


        return convertView;

    }
}

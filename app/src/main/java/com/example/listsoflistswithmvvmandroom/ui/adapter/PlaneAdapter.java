package com.example.listsoflistswithmvvmandroom.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listsoflistswithmvvmandroom.R;
import com.example.listsoflistswithmvvmandroom.model.other.Plane;

import java.util.List;

public class PlaneAdapter extends RecyclerView.Adapter<PlaneAdapter.MyViewHolder> {

    private List<Plane> planes;
    AdapterView.OnItemClickListener mListener;

    public PlaneAdapter(List<Plane> planes) {
        this.planes = planes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater
              .from(parent
              .getContext())
              .inflate(R.layout.item_plane, parent, false);

        return new MyViewHolder(view, mListener);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        mListener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Plane plane = planes.get(position);
        holder.itemPlaneTextViewName.setText(plane.getName());
    }

    @Override
    public int getItemCount() {
        return planes.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView itemPlaneTextViewName;

        public MyViewHolder(View itemView, final AdapterView.OnItemClickListener listener) {
            super(itemView);
            itemPlaneTextViewName = itemView.findViewById(R.id.item_plane_textview_name);
        }
    }
}



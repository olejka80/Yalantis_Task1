package com.example.yalantis_task1;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter {
    private ArrayList<Uri> mPhoto;
    private Context mContext;
    private OnItemClickListener mListener;

    public RecyclerAdapter(ArrayList<Uri> photos, Context context, OnItemClickListener listener) {
        mPhoto = photos;
        mContext = context;
        mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Picasso.with(mContext)
                .load(mPhoto.get(position))
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .resize(800, 700) //[Comment] Magic numbers
                .centerCrop()
                .into(viewHolder.ivPhoto);

        viewHolder.ivPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.OnPhotoClick(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mPhoto.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPhoto;

        public ViewHolder(View itemView) {
            super(itemView);
            ivPhoto = (ImageView) itemView.findViewById(R.id.ivPhoto);

        }
    }
}

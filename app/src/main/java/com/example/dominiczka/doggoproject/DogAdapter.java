package com.example.dominiczka.doggoproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dominiczka on 10.01.2018.
 */

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.DogViewHolder> {

    private DogAccess mDogLib;
    private DogActivity dogActivity;
    private ArrayList<Dog> dog;
    private static LayoutInflater inflater = null;
    Context context;




    public DogAdapter(DogAccess mDogLib, Context context) {
            this.mDogLib = mDogLib;
            dogActivity = (DogActivity) context;
            this.context = context;
    }

    @Override
    public DogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.dog_list_row,parent,false);
        DogViewHolder viewHolder = new DogViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final DogViewHolder holder, final int position) {
        final Dog dog = mDogLib.getDog(position);
        holder.mDogBreedTextView.setText((mDogLib.getName(position)));
        holder.mDogShortDescription.setText(mDogLib.getShortDescription(position));
        holder.mDogThumbnail.setImageResource(mDogLib.getImageDirectory(position));


        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  holder.view.setClickable(false);
                fragmentJump(dog);
            }
        });
    }

    DogDetailsFragment mFragment;
    Bundle mBundle;

    private void fragmentJump(Dog mItemSelected) {
        mFragment = new DogDetailsFragment();
        mBundle = new Bundle();

        mBundle.putParcelable("item_selected_key", mItemSelected);
        mFragment.setArguments(mBundle);
        switchContent(R.id.dogContainer, mFragment);
    }


    public void switchContent(int id, Fragment fragment) {
        if (context == null){return; }

        if (context instanceof DogActivity) {

            DogActivity dogActivity = (DogActivity) context;
            Fragment frag = fragment;
            dogActivity.switchContent(id, frag);
        }
    }



    @Override
    public int getItemCount() {
        return mDogLib.getLength();
    }

    public static class DogViewHolder extends RecyclerView.ViewHolder {

        TextView mDogBreedTextView;
        TextView mDogShortDescription;
        ImageView mDogThumbnail;
        View view;

        public DogViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            mDogBreedTextView = (TextView) itemView.findViewById(R.id.dogBreedTextView);
            mDogShortDescription = (TextView) itemView.findViewById(R.id.dogShortDescriptionTextView);
            mDogThumbnail = (ImageView) itemView.findViewById(R.id.dogThumbnailImageView);
        }

    }


}

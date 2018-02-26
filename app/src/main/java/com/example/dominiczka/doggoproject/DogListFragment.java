package com.example.dominiczka.doggoproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class DogListFragment extends Fragment {

    public DogListFragment() {
        // Required empty public constructor
    }

    RecyclerView mRecyclerView;
    DogAdapter dogAdapter;
    DogAccess dogAccess = new DogAccess();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dog_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        dogAccess.initDog(getContext());



        LinearLayoutManager llm = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(llm);

        dogAdapter = new DogAdapter(dogAccess, DogListFragment.super.getActivity());
        mRecyclerView.setAdapter(dogAdapter);

        return view;
    }



}

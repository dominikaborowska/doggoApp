package com.example.dominiczka.doggoproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DogDetailsFragment extends Fragment {

    public DogDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    TextView mDogName;
    TextView mDogDescription;
    ImageView mDogImage;
    Button mShelterButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dog_details, container, false);

        Dog dog = null;

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            dog = bundle.getParcelable("item_selected_key");
        }

        mDogDescription = view.findViewById(R.id.dogLongDescription);
        mDogImage = view.findViewById(R.id.DogImage);
        mDogName = view.findViewById(R.id.DogNameDetails);
        mShelterButton = view.findViewById(R.id.shelterButton);

        mDogName.setText(dog.getBreedName());
        mDogDescription.setText(dog.getLongDescription());
        mDogImage.setImageResource(dog.getImageDirectory());

        mShelterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addressString = "Schronisko dla zwierzat Dolistowska 2, 15-197 Białystok";
                Uri.Builder builder = new Uri.Builder();
                builder.scheme("geo")
                        .path("0,0")
                        .query(addressString);

                Uri addressUri = builder.build();
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(addressUri);

                    if (intent.resolveActivity(getContext().getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Log.d("TAG", "Couldn't call " + addressUri.toString()
                                + ", no receiving apps installed!");
                    }
            }
        });
        return view;
    }

}

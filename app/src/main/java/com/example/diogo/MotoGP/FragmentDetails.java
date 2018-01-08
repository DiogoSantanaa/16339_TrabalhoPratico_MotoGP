package com.example.diogo.MotoGP;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetails extends Fragment {


    public FragmentDetails() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_article, container, false);
    }

    @Override public void onStart() {
        super.onStart();
        // During startup, check if there are arguments passed to the fragment.
        // onStart is a good place to do this because the layout has already been
        // applied to the fragment at this point so we can safely call the method
        // below that sets the article text.
        Bundle args = getArguments();
        if (args != null) {
            // Set article based on argument passed in
            int currentPosition = args.getInt("position");
            //TextView articleTextView = (TextView) getActivity().findViewById(R.id.article_textview);
            //articleTextView.setText(DetailsData.Descricao[currentPosition]);
            updateDetailsView(currentPosition);
        }

    }
    public void updateDetailsView( int position) {
        TextView articleText = (TextView)
                getView().findViewById(R.id.article_textview);
        articleText.setText(DetailsData.Descricao[position]);
    }
}

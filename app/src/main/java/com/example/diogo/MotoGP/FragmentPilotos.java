package com.example.diogo.MotoGP;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPilotos extends ListFragment {

    OnHeadlineSelectedListener mCallback;

    // Container Activity must implement this interface
    public interface OnHeadlineSelectedListener {
        public void onArticleSelected(int position);
    }

    public FragmentPilotos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, DetailsData.Pilotos);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /*@Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        if (getActivity().findViewById(R.id.fragment_container) != null){
            Toast.makeText(getActivity().getBaseContext(), "Clicked Portrait." + DetailsData.Pilotos[position],
                    Toast.LENGTH_SHORT).show();

            FragmentDetails newFragment = new FragmentDetails();
            Bundle args = new Bundle();
            args.putInt("position", position);
            newFragment.setArguments(args);
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);
            // Commit the transaction
            transaction.commit();
        }

        else{
            Toast.makeText(getActivity().getBaseContext(), "Clicked Landscape." + DetailsData.Pilotos[position],
                    Toast.LENGTH_SHORT).show();
            TextView articleTextView = (TextView) getActivity().findViewById(R.id.article_textview);
            articleTextView.setText(DetailsData.Descricao[position]);
        }
    }*/

    @Override
    public void onListItemClick(ListView l, View v, int position,
                                long id) {
        // Send the event to the host activity
        mCallback.onArticleSelected(position);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnHeadlineSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }


}




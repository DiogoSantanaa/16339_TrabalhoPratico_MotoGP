package com.example.diogo.MotoGP;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements FragmentPilotos.OnHeadlineSelectedListener{
    static Boolean firstTimePortait = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            if (! firstTimePortait){
                Toast.makeText(this, "Not first time portait", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this, "FirsTime portait", Toast.LENGTH_SHORT).show();

            firstTimePortait = false;


            // Create a new Fragment to be placed in the activity layout
            FragmentPilotos firstFragment = new FragmentPilotos();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }
    }

    public void onArticleSelected(int position) {
        //Toast.makeText(this, "OnArticleSelected: " + position, Toast.LENGTH_SHORT).show();

        if (findViewById(R.id.fragment_container) != null){
            Toast.makeText(this, "Clicked Portrait." + DetailsData.Pilotos[position],
                    Toast.LENGTH_SHORT).show();

            FragmentDetails newFragment = new FragmentDetails();
            Bundle args = new Bundle();
            args.putInt("position", position);
            newFragment.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);
            // Commit the transaction
            transaction.commit();
        }

        else{
            Toast.makeText(this, "Clicked Landscape." + DetailsData.Pilotos[position],
                    Toast.LENGTH_SHORT).show();

            FragmentDetails detailsFrag = (FragmentDetails)

                    getSupportFragmentManager().findFragmentById(R.id.article_fragment);
            detailsFrag.updateDetailsView(position);
        }
    }
}

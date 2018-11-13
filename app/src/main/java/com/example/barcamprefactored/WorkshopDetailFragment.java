package com.example.barcamprefactored;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.barcamprefactored.dummy.DummyContent;

/**
 * A fragment representing a single Workshop detail screen.
 * This fragment is either contained in a {@link WorkshopListActivity}
 * in two-pane mode (on tablets) or a {@link WorkshopDetailActivity}
 * on handsets.
 */
public class WorkshopDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public WorkshopDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
            System.out.println("inside workshopDetailFragment::onCreate");
            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.content); //the value of the title of the second page (for each workshop separately)
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.workshop_detail, container, false);
        System.out.println("inside workshopDetailFragment::onCreateView");
        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.workshop_detail)).setText("Speaker: " + mItem.speaker + "\n" + "Topic: " + mItem.topic + "\n" + "Room: " + mItem.room + "\n" + "Start: " + mItem.start + "\n" + "Finish: " + mItem.finish);   //mItem.details  the initial value of the argument to setText()
        }

        return rootView;
    }
}

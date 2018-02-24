package com.watashiwa.furanku.moodtracker.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;

import com.watashiwa.furanku.moodtracker.R;
import com.watashiwa.furanku.moodtracker.model.ListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * this class is the main activity
 * it shows all the different views
 */
public class MainActivity extends AppCompatActivity {

	//to make the eventual log
	private final static String TAG = "TestMainActivity";

	/**
	 * the recycler view where are showing all the views as a list
	 */
	private RecyclerView mRecyclerView;

	/**
	 * adapter of this recycler view
	 */
	private RecyclerView.Adapter mAdapter;

	private List<ListItem> listItems = new ArrayList<>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/**
		 * Sets the fullScreen in all the app
		 */
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		/**
		 * Hides the action bar
		 */
		getSupportActionBar().hide();

		/**
		 * this sets the specific layout of this activity
		 */
	     setContentView(R.layout.activity_main);

		/**
		 * references the recycler view to its unique id in the layout
		 */
		mRecyclerView = findViewById(R.id.main_activity_recycler_view);

		/**
		 * this improve the performance
		 * do not change the layout size of the recycler in content
		 */
		mRecyclerView.setHasFixedSize(true);

		/**
		 * this create a linear layout manager
		 * this linear layout manager allows to have a vertical scrolling
		 */
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

		//this specifies an adapter
		mAdapter = new SmileyAdapter(listItems, this);
		mRecyclerView.setAdapter(mAdapter);
		/**
		 * this function is called to initialize the list
		 * @see addItems()
		 */
		addItems();
	}

	/**
	 * This function adds items in the Array list
	 * note that the order is the same we want in the recycler view
	 */
	public void addItems() {
		listItems.add(new ListItem(R.drawable.smiley_sad, "#ffde3c50"));
		listItems.add(new ListItem(R.drawable.smiley_disappointed, "#ff9b9b9b"));
		listItems.add(new ListItem(R.drawable.smiley_normal, "#a5468ad9"));
		listItems.add(new ListItem(R.drawable.smiley_happy, "#ffb8e986"));
		listItems.add(new ListItem(R.drawable.smiley_super_happy, "#fff9ec4f"));
	}
}



package com.watashiwa.furanku.moodtracker.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.watashiwa.furanku.moodtracker.R;

/**
 * This class is the start-up activity
 *	just shows a welcome message for 3s
 */
public class WelcomeActivity extends AppCompatActivity {
	/**
	 * welcome message
	 */
	private TextView mTextView;

	/**
	 * the author of the app
	 */
	private TextView mAuthor;

	/**
	 * the image on this page
	 */
	private ImageView mImageView;

	public static final int MAIN_ACTIVITY_REQUEST_CODE = 1;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		/**
		 * sets the specific layout of this activity
		 */
		setContentView(R.layout.welcome_activity);
		/**
		 * this remove the title MoodTracker on this page
		 */
		setTitle("");

		/**
		 * references the author to its unique id in the layout
		 */
		mAuthor = findViewById(R.id.welcome_activity_author);

		/**
		 * references the image to its unique id in the layout
		 */
		mImageView = findViewById(R.id.welcome_activity_view);

		/**
		 * references the welcome message to its unique id in the layout
		 */
		mTextView = findViewById(R.id.welcome_activity_text);

		/**
		 * this sets a pause of 3s before starting the main activity
		 */
		new Thread(new Runnable() {
			public void run() {
				//catching an eventual error
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				//starting the main activity
				Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
				startActivityForResult(intent, MAIN_ACTIVITY_REQUEST_CODE);
			}
	}).start();
	}
}

package com.watashiwa.furanku.moodtracker.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.watashiwa.furanku.moodtracker.R;

/**
 * Created by Furanku Watashiwa on 04/02/2018.
 */

public class AddComment extends Dialog {

	public AddComment(@NonNull Context context) {
		super(context);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
			//Creates a new AlertDialog
			AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
			//References to the specific layout
		View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.comment_layout, null);
		/**
		 * Sets the view with the specific layout
		 */
		builder.setView(dialogView)
				/**
				 * sets the icon in the title Bar
				 */
				 .setIcon(R.drawable.ic_comment_black_48px)

				/**
				 * sets the positive button and the actions when it is clicked
				 */
				 .setPositiveButton("OK", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							//the user enter and valid its comment
							//the we save it and back to the previous page
						 }
				 })
						/**
						 * set the negative button and the actions when it is clicked
						 */
				 .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							//the user cancel its comment we go back to the previous page
							dialog.cancel();
						}

				 })

			    /**
				 * sets the title of the Alert dialog
				 */
			    .setTitle("Enter your comment please");
		/**
		 * References the edit text of the alert dialog to its unique id in layout
		 */
		final EditText editText = dialogView.findViewById(R.id.comment_edit_text);

		//To make actions when there are changes in EditText
		editText.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				/**
				 * Number max of character the user can enter
				 */
				Character MaxCharacter = 100;
				/**
				 * if the user reached the max number of character a little message is shown as toast
				 */
				if (editText.length()== MaxCharacter){
					Toast toast =Toast.makeText(getContext(), "Number Max of character reached ", Toast.LENGTH_LONG);
					toast.show();
				}
			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});
		//creates the builder just configured
	   builder.create()
				  //shows the builder just created
				 .show();
	}
}
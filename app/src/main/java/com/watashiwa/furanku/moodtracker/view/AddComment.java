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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.watashiwa.furanku.moodtracker.R;

/**
 * Created by Furanku Watashiwa on 04/02/2018.
 */

public class AddComment extends Dialog {
	/**
	 * This constructeur call the method addCommentDialog
	 * @param context
	 */
	public AddComment(@NonNull Context context) {
		super(context);
		addCommentDialog();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	/**
	 * this method creates and sets a new Alert dialog
	 */
	public void addCommentDialog() {
		final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
		//References to the specific layout
		final View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.comment_layout, null);
		/**
		 * Sets the view with the specific layout
		 */
		builder.setView(dialogView)

				  /**
					* the ALertDialog will be cancellable only with a click on the Cancel button
					*/
			    .setCancelable(false)
				  /**
					* sets the icon in the title Bar
					*/
			    .setIcon(R.drawable.ic_comment_black_48px)

				  /**
					* sets the title of the Alert dialog
					*/
			    .setTitle("Enter your comment please")

				  /**
					* This neutral button closes the AlertDialog
					*/
				  .setNeutralButton("CLOSE", new OnClickListener() {
					  @Override
					  public void onClick(DialogInterface dialog, int which) {
					  	//Closes the dialog
						  dialog.cancel();
					  }
				  });
		/**
		 * References the OK button to the id in layout
		 */
		final Button BUTTON_OK = dialogView.findViewById(R.id.ok_btn);

		/**
		 * references the Cancel button to the id in layout
		 */
		final Button BUTTON_CANCEL = dialogView.findViewById(R.id.cancel_btn);

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
				final Character MAX_CHARACTER = 100;
				/**
				 * Disables the Ok button if there is no character entered by the user
				 */
				if (editText.length() > 0) BUTTON_OK.setEnabled(true);
				else BUTTON_OK.setEnabled(false);

				/**
				 * if the user reached the max number of character a little message is shown as toast
				 */
				if (editText.length() == MAX_CHARACTER) {
					Toast toast = Toast.makeText(getContext(), "Number Max of character reached ", Toast.LENGTH_LONG);
					toast.show();
				}
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});

		BUTTON_OK.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//save,notify history
			}
		});

		BUTTON_CANCEL.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//Cancel all the characters entered by the user when clicking
				editText.setText(" ");
			}
		});
		//shows the builder just created
		builder.show();
		//sets the OK button disabled by default
		BUTTON_OK.setEnabled(false);
	}
}

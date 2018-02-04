package com.watashiwa.furanku.moodtracker.model;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.watashiwa.furanku.moodtracker.R;

/**
 * Created by Furanku Watashiwa on 04/02/2018.
 */

public class AddComment extends Dialog{

	public AddComment(@NonNull Context context) {
		super(context);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

		builder.setView(getLayoutInflater().inflate(R.layout.comment_layout, null))
				  .setIcon(R.drawable.ic_comment_black_48px)
		       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							//the user enter and valid its comment
							//the we save it and back to the previous page
						}
				 })
				  .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							//the user cancel its comment we go back to the previous page
							dialog.cancel();
						}
				  }).setTitle("Enter your comment please")
				    .create()
				    .show();
	}
}
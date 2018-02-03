package com.watashiwa.furanku.moodtracker.controller;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.watashiwa.furanku.moodtracker.R;
import com.watashiwa.furanku.moodtracker.model.ListItem;

import java.util.List;

/**
 * Created by Furanku Watashiwa on 29/01/2018.
 */
public class SmileyAdapter extends RecyclerView.Adapter<SmileyAdapter.SmileyViewHolder> {
	private List<ListItem> mListItems;

	/**
	 * to get the length of the drawables list
	 * this number is also the number of view we can have
	 *
	 * @return the total number of items in that list
	 */
	public int getItemCount() {
		return mListItems.size();
	}

	/**
	 * create new views (by the layout manager)
	 * this view is referenced to its specific layout
	 *
	 * @param parent
	 * @param viewType
	 * @return the new views created
	 */
	@Override
	public SmileyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
		SmileyViewHolder svh = new SmileyViewHolder(view);
		return svh;
	}

	public SmileyAdapter(List<ListItem> listItems) {
		mListItems = listItems;
	}

	/**
	 * provide a reference to the views for each list(data) item
	 * provide access to all the views for a data item in a view holder
	 */
	public static class SmileyViewHolder extends RecyclerView.ViewHolder {
		public ImageButton smileyButton, commentButton, historyButton;
		public CardView cardView;

		public SmileyViewHolder(final View itemView) {
			super(itemView);
			//referencing each element of the recycler view with its unique id
			this.smileyButton = itemView.findViewById(R.id.list_layout_smiley_btn);
			this.commentButton = itemView.findViewById((R.id.list_layout_add_note_btn));
			this.historyButton = itemView.findViewById((R.id.list_layout_history_btn));
			this.cardView = itemView.findViewById(R.id.list_layout_card_view);
			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					
				}
			});
		}
	}

	/**
	 * replaces the contents of a view (by layout manager)
	 * get the element from drawable list at this position
	 * replace the contents of the view with that element
	 * @param holder
	 * @param position
	 */
	@Override
	public void onBindViewHolder( SmileyViewHolder holder, int position) {
		ListItem currentItem = mListItems.get(position);
		//getting the elements

		holder.smileyButton.setImageResource(currentItem.getImageResource());
		holder.cardView.setCardBackgroundColor(Color.parseColor(currentItem.getColorResource()));
	}
}



package com.zfdang.zsmth_android;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zfdang.zsmth_android.FavoriteFragment.OnListFragmentInteractionListener;
import com.zfdang.zsmth_android.models.Board;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Board} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class FavoriteRecyclerViewAdapter extends RecyclerView.Adapter<FavoriteRecyclerViewAdapter.ViewHolder> {

    private final List<Board> mValues;
    private final OnListFragmentInteractionListener mListener;

    public FavoriteRecyclerViewAdapter(List<Board> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_favorite_board_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mCategoryView.setText("[" + holder.mItem.getCategoryName() + "]");
        holder.mModeratorView.setText(holder.mItem.getModerator());
        holder.mNameView.setText("[" + holder.mItem.getEngName() + "]" + holder.mItem.getChsName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public Board mItem;
        public final View mView;
        public final TextView mCategoryView;
        public final TextView mModeratorView;
        public final TextView mNameView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mCategoryView = (TextView) view.findViewById(R.id.CategoryName);
            mModeratorView = (TextView) view.findViewById(R.id.ModeratorID);
            mNameView = (TextView) view.findViewById(R.id.BoardName);
        }

        @Override
        public String toString() {
            return mNameView.getText().toString();
        }
    }
}

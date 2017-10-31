package com.example.apollinariia.lab_contentprovider_24082017;

/**
 * Created by Apollinariia on 8/30/2017.
 */

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apollinariia.lab_contentprovider_24082017.data.PresidentContract;

import static android.content.ContentValues.TAG;

public class CustomCursorAdapter extends RecyclerView.Adapter<CustomCursorAdapter.TaskViewHolder> {

    private Cursor mCursor;
    private Context mContext;


    public CustomCursorAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.one_row, parent, false);


        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {

        int idIndex = mCursor.getColumnIndex(PresidentContract.PresidentEntry._ID);
        int surname = mCursor.getColumnIndex(PresidentContract.PresidentEntry.COL_1);
        int name = mCursor.getColumnIndex(PresidentContract.PresidentEntry.COL_2);
        int startDate = mCursor.getColumnIndex(PresidentContract.PresidentEntry.COL_3);
        int endDate = mCursor.getColumnIndex(PresidentContract.PresidentEntry.COL_4);

        mCursor.moveToPosition(position);

        final int id = mCursor.getInt(idIndex);
        String surn = mCursor.getString(surname);
        String n = mCursor.getString(name);
        int sDate = mCursor.getInt(startDate);
        int eDate = mCursor.getInt(endDate);

        holder.itemView.setTag(id);
        holder.surnameView.setText(surn + " ");
        holder.nameView.setText(n);
        holder.sDateView.setText(sDate + " - ");
        holder.eDateView.setText(eDate + " ");
    }

    @Override
    public int getItemCount() {
        if (mCursor == null) {
            return 0;
        }
        return mCursor.getCount();
    }


    public Cursor swapCursor(Cursor c) {
        if (mCursor == c) {
            return null;
        }
        Cursor temp = mCursor;
        this.mCursor = c;

        if (c != null) {
            this.notifyDataSetChanged();
        }
        return temp;
    }


    // Inner class for creating ViewHolders
     class TaskViewHolder extends RecyclerView.ViewHolder {

        TextView surnameView;
        TextView nameView;
        TextView sDateView;
        TextView eDateView;


        public TaskViewHolder(final View itemView) {
            super(itemView);

            surnameView = (TextView) itemView.findViewById(R.id.surname);
            nameView = (TextView) itemView.findViewById(R.id.name);
            sDateView = (TextView) itemView.findViewById(R.id.startDate);
            eDateView = (TextView) itemView.findViewById(R.id.endDate);


            itemView.setOnClickListener (new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, "Item click number: "+getLayoutPosition() + "\n" +
                            surnameView.getText() + " " +
                            nameView.getText() + "  " +
                            sDateView.getText() +
                            eDateView.getText(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}

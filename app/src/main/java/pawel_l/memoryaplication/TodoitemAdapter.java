package pawel_l.memoryaplication;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gosc on 25.11.2016.
 */

public class TodoitemAdapter extends RecyclerView.Adapter<TodoitemAdapter.TodoViewHolder> {
    private List<ToDoTask> mData = Collections.emptyList();

    public void setData(List<ToDoTask> data) {
        mData = data;
        notifyDataSetChanged();
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View rowView = inflater.inflate(R.layout.row_todoitem, parent, false);
        return new TodoViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        ToDoTask task = mData.get(position);
        // ustawienie paska priorytetu
        if (task.isPriority()) {
            holder.itemView.setBackgroundColor(0x20FF0000);
        }else{
            holder.itemView.setBackgroundColor(Color.TRANSPARENT);
        }
        // Lub za pomoca operatora ( znajdujacego sie ponizej) warunkowego:
       // holder.mStripe.setBackgroundColor(task.isPriority() ? Color.RED : Color.TRANSPARENT);


        // Ustawienie checkboxa DONE
        holder.mDone.setChecked(task.isDone());

        // Ustawienie tytulu zadania

        holder.mTitle.setText(task.getTitle());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public  class TodoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.stripe)
        View mStripe;
        @BindView(R.id.done)
        CheckBox mDone;
        @BindView(R.id.task_title)
        TextView mTitle;

        public TodoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

package pawel_l.memoryaplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gosc on 25.11.2016.
 */

public class toDoListFragment extends Fragment {

    private TodoitemAdapter mAdapter;

    @BindView(R.id.todo_list)
    protected RecyclerView mToDoList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_todolist, container, false);
        ButterKnife.bind(this, view);

        mToDoList.setLayoutManager(new LinearLayoutManager(getContext()));

        TodoItemsRepository itemsRepository = new SqlTodoItemsRepository(getContext());

        mAdapter = new TodoitemAdapter();
        mAdapter.setData(itemsRepository.getToDoList());
        mToDoList.setAdapter(mAdapter);

        return view;


    }
}

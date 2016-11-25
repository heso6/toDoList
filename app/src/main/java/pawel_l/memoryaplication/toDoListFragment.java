package pawel_l.memoryaplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gosc on 25.11.2016.
 */

public class toDoListFragment extends Fragment {
    @BindView(R.id.todo_list)
    protected RecyclerView mToDoList;

    private TodoitemAdapter mAdapter;
    private TodoListMenuListener mMenuListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof  TodoListMenuListener) {
            mMenuListener = (TodoListMenuListener) context;
        }else{
            throw new RuntimeException("Activity nie implementuje TodoMenuListener");
        }
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_todolist, container, false);
        ButterKnife.bind(this, view);
        setHasOptionsMenu(true);

        mToDoList.setLayoutManager(new LinearLayoutManager(getContext()));

        TodoItemsRepository itemsRepository = new SqlTodoItemsRepository(getContext());

        mAdapter = new TodoitemAdapter();
        mAdapter.setData(itemsRepository.getToDoList());
        mToDoList.setAdapter(mAdapter);

        return view;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_item_add){
            mMenuListener.onAddClick();
        }
        return super.onOptionsItemSelected(item);
    }

    public interface TodoListMenuListener {

        void onAddClick();


    }

}

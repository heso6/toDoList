package pawel_l.memoryaplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gosc on 25.11.2016.
 */

public class FormFragment extends Fragment {
    @BindView(R.id.task_title)
    protected EditText mTitle;
    @BindView(R.id.task_note)
    protected EditText mNote;
    @BindView(R.id.task_priority)
    protected CheckBox mPriority;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_form, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
    @OnClick(R.id.save)
    protected void onSaveClick(){

    }
}

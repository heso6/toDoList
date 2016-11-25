package pawel_l.memoryaplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements toDoListFragment.TodoListMenuListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new toDoListFragment())
                    .commit();
        }
    }

    @Override
    public void onAddClick() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new FormFragment())
                .addToBackStack(null)
                .commit();

    }
}

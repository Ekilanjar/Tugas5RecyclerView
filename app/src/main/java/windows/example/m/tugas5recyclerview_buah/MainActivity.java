package windows.example.m.tugas5recyclerview_buah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView lsbuah;
    private ArrayList<Buah> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lsbuah = findViewById(R.id.buahan);
        lsbuah.setHasFixedSize(true);

        list.addAll(BuahData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        lsbuah.setLayoutManager(new LinearLayoutManager(this));
        ListBuahAdapter listHeroAdapter = new ListBuahAdapter(list);
        lsbuah.setAdapter(listHeroAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode (int selectedMode){
        switch (selectedMode){
            case R.id.action_list:
                showRecyclerList();
                break;
            case R.id.action_grid:
                showRecyclerGrid();
                break;
            case R.id.action_cardview:
                showRecyclerCardView();
                break;
        }
    }

    private void showRecyclerGrid(){
        lsbuah.setLayoutManager(new GridLayoutManager(this, 2));
        GridBuahAdapter gridHeroAdapter = new GridBuahAdapter(list);
        lsbuah.setAdapter(gridHeroAdapter);
    }

    private void showRecyclerCardView(){
        lsbuah.setLayoutManager(new LinearLayoutManager(this));
        CardViewBuahAdapter cardViewHeroAdapter = new CardViewBuahAdapter(list);
        lsbuah.setAdapter(cardViewHeroAdapter);
    }
}



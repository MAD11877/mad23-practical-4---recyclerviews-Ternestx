package sg.edu.np.mad.prac4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    private static final String Title = "ListActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<user> userlist = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            user user1 = createUser();
            userlist.add(user1);
            Log.i(Title, "1");
        }

        RecyclerView recyclerView = findViewById(R.id.recycler);
        adapter mAdapter = new adapter(ListActivity.this,userlist);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }
    private int randomOTP(){
        Random ran = new Random();
        int value = ran.nextInt(999999999);
        return value;
    }
    private user createUser(){
        user user1 = new user();
        int ran1 = randomOTP();
        int ran2 = randomOTP();
        user1.name = "Name" + ran1;
        user1.followed = false;
        user1.description = "Description " + ran2;
        return user1;
    }
}
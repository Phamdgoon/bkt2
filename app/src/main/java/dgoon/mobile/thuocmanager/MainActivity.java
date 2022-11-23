package dgoon.mobile.thuocmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ThuocAdapter thuocAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Thuoc> options =
                new FirebaseRecyclerOptions.Builder<Thuoc>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Thuoc"), Thuoc.class)
                        .build();

        thuocAdapter = new ThuocAdapter(options);
        recyclerView.setAdapter(thuocAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        thuocAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        thuocAdapter.stopListening();
    }
}
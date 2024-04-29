package sg.edu.np.mad.practical3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Initialize a new User Object
        User user = new User("John Doe","MAD Developer", 1,false);

        //Get the TextViews and Button From Layout
        TextView tvName = findViewById(R.id.tvName);

        TextView tvDescription = findViewById(R.id.tvDescription);

        Button btnFollow = findViewById(R.id.btnFollow);

        //Set the test views with the user's name description and default button message
        tvName.setText(user.name);
        tvDescription.setText(user.description);
        btnFollow.setText("Follow");

        // Challenge 1
        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!user.followed && btnFollow.getText().toString().equals("Follow")) {
                    btnFollow.setText("Unfollow");
                    user.followed = true;
                } else if (user.followed && btnFollow.getText().toString().equals("Unfollow")) {
                    btnFollow.setText("Follow");
                    user.followed = false;
                }
            }
        });
    }
}
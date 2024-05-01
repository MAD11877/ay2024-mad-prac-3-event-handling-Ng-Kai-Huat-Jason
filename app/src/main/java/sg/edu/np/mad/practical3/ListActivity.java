package sg.edu.np.mad.practical3;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.app.AlertDialog;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView imageButton = findViewById(R.id.imagebutton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if the clicked view is the ImageButton
                if (v == imageButton) {

                    // Build and show the AlertDialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);

                    builder.setTitle("Profile");
                    builder.setMessage("MADness");

                    // Add buttons (optional)
                    builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Handle positive button click (e.g., dismiss dialog)

                            Intent MainActivity = new Intent(ListActivity.this, MainActivity.class);

                            startActivity(MainActivity);
                        }
                    });

                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Handle negative button click (e.g., dismiss dialog)
                            dialog.dismiss();
                        }
                    });

                    // Create and show the dialog
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });
    }
}
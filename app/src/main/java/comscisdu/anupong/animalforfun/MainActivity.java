package comscisdu.anupong.animalforfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameEditText;
    Button startButton;
    String nameString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ผูกตัวแปร Java กับอีลิเมนต์ยน XML
        nameEditText = findViewById(R.id.edtName);
        startButton = findViewById(R.id.btStart);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameString = nameEditText.getText().toString().trim();

                //Check Space
                if (nameString.length() == 0) { //ถ้า name เป็นค่าว่าง
                    Toast.makeText(getApplicationContext(), "กรุณาใส่ชื่อ!!", Toast.LENGTH_SHORT).show();
                } else { //ถ้า name ไม่เป็นค่าว่าง
                    Toast.makeText(getApplicationContext(), "ยินดีต้อนรับ " + nameString, Toast.LENGTH_SHORT).show();
                    // Connect to Game Activity
                    Intent startIntent = new Intent(MainActivity.this, GameActivity.class);
                    startIntent.putExtra("Name", nameString);
                    startActivity(startIntent);
                }

            }
        });
    }
}
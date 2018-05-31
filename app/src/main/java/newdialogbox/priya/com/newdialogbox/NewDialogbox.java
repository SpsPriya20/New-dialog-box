package newdialogbox.priya.com.newdialogbox;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewDialogbox extends AppCompatActivity {

    private EditText fname, lname, dob, genderET, emailET, confirm_mail, password;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dialogbox);


        fname = findViewById(R.id.fname);

        lname = findViewById(R.id.lname);

        dob = findViewById(R.id.dob);

        genderET = findViewById(R.id.genderET);

        emailET = findViewById(R.id.emailET);

        confirm_mail = findViewById(R.id.confirm_mail);

        password = findViewById(R.id.password);


        signup = findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();

            }


        });


    }

    private void showToastMessage(String message) {
        Toast.makeText(NewDialogbox.this, message, Toast.LENGTH_SHORT).show();
    }


    private void validate() {

        String firstname = fname.getText().toString();
        String lastname = lname.getText().toString();
        String dateofbirth = dob.getText().toString();
        String gender = genderET.getText().toString();
        String email = emailET.getText().toString();
        String confirmmail = confirm_mail.getText().toString();
        String pass = password.getText().toString();

        if (firstname.length() < 4) {
            showToastMessage("Invalid first name");
            return;
        }

        if (lastname.length() < 3) {
            showToastMessage("Invalid last name");
            return;
        }

        if (dob.length() != 10) {
            showToastMessage("Invalid date of birth");
            return;
        }

        if (gender.length() != 1) {
            showToastMessage("Invalid gender");
            return;
        }


        if (!email.endsWith("@gmail.com")) {
            showToastMessage("Invalid email id");
            return;
        }

        if (!email.equals(confirmmail)){
            showToastMessage("email address donot match try again");
            return;
        }

        if (pass.length() < 6) {
            showToastMessage("Invalid password");
            return;

        }


        showAlertDialog("SIGNUP", " SIGNED UP SUCESSFULLY ");
    }

    private void showAlertDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();
    }
}







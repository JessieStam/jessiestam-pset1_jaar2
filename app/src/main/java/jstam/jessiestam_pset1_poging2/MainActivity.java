package jstam.jessiestam_pset1_poging2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // when checkbox is clicked, change image visibility
    public void CheckButton(View viewCheckbox) {

        // create boolean to check when checkbox is checked
        boolean checked = ((CheckBox) viewCheckbox).isChecked();


        // get checkbox id and make string for clicked checkbox name to match ImageView id name
        String bodyPartBox = getResources().getResourceEntryName(viewCheckbox.getId())
                .replace("_check", "");

        // find matching ImageView by creating integer for checkbox id
        int imageId = getResources().getIdentifier(bodyPartBox, "string", getPackageName());
        ImageView bodyPartImage = (ImageView) findViewById(imageId);

        // if checkbox is checked set ImageView to visible, if not checked set to invisible
        if (checked)
            bodyPartImage.setVisibility(View.VISIBLE);
        else
            bodyPartImage.setVisibility(View.INVISIBLE);
    }
}

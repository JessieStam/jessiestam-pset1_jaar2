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

        // check if it's a new Bundle or a restored one
        if (savedInstanceState != null) {

            //restore (Check which boxes are checked and change visibility)

        }
        else {
            //do nothing??
        }

    }

    // when checkbox is clicked, change image visibility
    public void CheckButton(View viewCheckbox) {

        // create boolean that determines if a checkbox is checked
        boolean checked = ((CheckBox) viewCheckbox).isChecked();

        // get checkbox id and make string for clicked checkbox name to match ImageView id name
        String bodyPartBox = getResources().getResourceEntryName(viewCheckbox.getId())
                .replace("_check", "");

        // find matching ImageView by creating integer for ImageView id
        Integer imageId = getResources().getIdentifier(bodyPartBox, "id", getPackageName());
        ImageView bodyPartImage = (ImageView) findViewById(imageId);

        // use boolean to determine if visibility of ImageView should on or of and change it
        if (checked)
            bodyPartImage.setVisibility(View.VISIBLE);
        else
            bodyPartImage.setVisibility(View.INVISIBLE);
    }

//    @Override
//    protected void onSaveInstanceState(Bundle savedInstanceState) {
//        super.onSaveInstanceState(savedInstanceState);
//
//        // save boolean checked??
//        // savedInstanceState.putBoolean("checked", true);
//
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//
//        // check welke boxes zijn gecheckt en verander ze
//
//    }
}

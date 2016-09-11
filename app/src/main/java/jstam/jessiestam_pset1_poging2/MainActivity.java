package jstam.jessiestam_pset1_poging2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> checked_images_list;
    ImageView bodyPartImage;
    Integer imageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // if savedInstanceState is empty, create new ArrayList for checked checkboxes
        if (savedInstanceState == null) {
            checked_images_list = new ArrayList<>();
        }
        // if savedInstanceState is restores, load list of checked checkboxes
        else {
            checked_images_list = savedInstanceState.getIntegerArrayList("savedList");

            // iterate over list of checked checkboxes
            if (checked_images_list != null) {
                // change each corresponding ImageView to visible
                for (Integer list_item : checked_images_list) {
                    bodyPartImage = (ImageView) findViewById(list_item);
                    bodyPartImage.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    /*
     * when checkbox is clicked, change ImageView visibility
     */
    public void CheckButton(View viewCheckbox) {

        // create boolean that determines if a checkbox is checked
        boolean checked = ((CheckBox) viewCheckbox).isChecked();

        // get checkbox id and make string for clicked checkbox name to match ImageView id
        String bodyPartBox = getResources().getResourceEntryName(viewCheckbox.getId())
                .replace("_check", "");

        // find matching ImageView by creating integer for ImageView id
        imageId = getResources().getIdentifier(bodyPartBox, "id", getPackageName());
        bodyPartImage = (ImageView) findViewById(imageId);

        // use boolean to determine if visibility of ImageView should on or of and change it
        if (checked) {
            bodyPartImage.setVisibility(View.VISIBLE);

            //save imageId in list
            checked_images_list.add(imageId);
        }
        else {
            bodyPartImage.setVisibility(View.INVISIBLE);

            // remove imageId from list
            Iterator<Integer> remove_iterator = checked_images_list.iterator();
            while (remove_iterator.hasNext()) {
                //check_iterator.next();
                Integer list_item = remove_iterator.next();
                // compare list_item to imageId
                if (list_item.equals(imageId))
                    remove_iterator.remove();
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // save ArrayList of visible images
        outState.putIntegerArrayList("savedList", checked_images_list);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // check welke boxes zijn gecheckt en verander ze
        checked_images_list = savedInstanceState.getIntegerArrayList("savedList");
    }
}

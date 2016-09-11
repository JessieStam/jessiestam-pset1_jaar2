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

        // if savedInstanceState is empty, create new ArrayList to put IDs of checked CheckBoxes
        if (savedInstanceState == null) {
            checked_images_list = new ArrayList<>();
        }
        // if savedInstanceState is full, load list of checked CheckBox IDs
        else {
            checked_images_list = savedInstanceState.getIntegerArrayList("savedList");

            // iterate over list of checked CheckBox IDs
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
     * when CheckBox is clicked, change ImageView visibility
     */
    public void CheckButton(View viewCheckbox) {

        // create boolean that determines if CheckBox is checked
        boolean checked = ((CheckBox) viewCheckbox).isChecked();

        // get CheckBox ID and make String for clicked CheckBox name to match ImageView ID
        String bodyPartBox = getResources().getResourceEntryName(viewCheckbox.getId())
                .replace("_check", "");

        // find matching ImageView by creating Integer for ImageView ID
        imageId = getResources().getIdentifier(bodyPartBox, "id", getPackageName());
        bodyPartImage = (ImageView) findViewById(imageId);

        // use boolean to determine if ImageView should be (in)visible and change visibility
        if (checked) {
            bodyPartImage.setVisibility(View.VISIBLE);

            // save CheckBox ID corresponding to visible ImageView in list
            checked_images_list.add(imageId);
        }
        else {
            bodyPartImage.setVisibility(View.INVISIBLE);

            // create Iterator to iterate over list of CheckBox IDs
            Iterator<Integer> remove_iterator = checked_images_list.iterator();

            // iterate over IDs in list to find CheckBox ID to be removed
            while (remove_iterator.hasNext()) {
                Integer list_item = remove_iterator.next();

                // remove CheckBox ID corresponding to invisible ImageView from list
                if (list_item.equals(imageId))
                    remove_iterator.remove();
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // save ArrayList of visible ImageViews
        outState.putIntegerArrayList("savedList", checked_images_list);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // restore ArrayList of visible ImageViews
        checked_images_list = savedInstanceState.getIntegerArrayList("savedList");
    }
}

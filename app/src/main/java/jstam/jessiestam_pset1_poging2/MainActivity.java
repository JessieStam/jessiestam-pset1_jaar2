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

        boolean checked = ((CheckBox) viewCheckbox).isChecked();

        // get id and make string for clicked checkbox
        // Find imageview by id(string) -> imageview id
        // if imageview string is checked -> visible, else -> invisible

        // get id and make string for clicked checkbox to match imageview id name
        String bodyPartBox = getResources().getResourceEntryName(viewCheckbox.getId())
                .replace("_check", "");

        //String title = bodyPartBox.replace("_check", "");
//        String id = getResources().getIdentifier(bodyPartBox, "string", getPackageName());
//        String string = getString(id);
//

        int imageId = getResources().getIdentifier(bodyPartBox, "string", getPackageName());
        ImageView bodyPartImage = (ImageView) findViewById(imageId);




        // get id for clicked checkbox
        switch(viewCheckbox.getId()) {
            // if checkbox is checked make image visible, of not checked make image invisible
            case R.id.check_hat:
                ImageView Hat = (ImageView) findViewById(R.id.hat_id);
                if (checked)
                    Hat.setVisibility(View.VISIBLE);
                else
                    Hat.setVisibility(View.INVISIBLE);
                break;

            //        int getIdentifier (String name,
//                String defType,
//                String defPackage)
//
//        eyebrows_id_check;
//        shoes_id;
//
//        ImageView bodyPartImage = (ImageView) findViewById(R.id.bodyPartBox);
    }
}

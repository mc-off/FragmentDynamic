package mera.hse.mleykin.fragmentlifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    Fragment1 frag1;
    Fragment2 frag2;
    Fragment current;
    FragmentTransaction fTrans;
    CheckBox chbStack;
    StringBuilder sb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frag1 = new Fragment1();
        frag2 = new Fragment2();
    }

    public void onClick(View v) {
        fTrans = getFragmentManager().beginTransaction();
        Fragment fragment = getFragmentManager().findFragmentByTag("R.id.Fragment1");

        switch (v.getId()) {
            case R.id.btnAdd:
                fTrans.add(R.id.frgmCont, frag1);
                current = frag1;
                fTrans.commit();
                break;
            case R.id.btnRemove:
                fTrans.remove(current);
                fTrans.commit();
                break;
            case R.id.btnReplace:
                fTrans.replace(R.id.frgmCont, frag2);
                current = frag2;
                fTrans.commit();
            default:
                break;
        }
    }
}

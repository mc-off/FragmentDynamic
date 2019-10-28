package mera.hse.mleykin.fragmentdynamic;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import java.util.List;


public class MainActivity extends Activity {

    Fragment1 frag1;
    Fragment2 frag2;
    Fragment current;
    FragmentTransaction fTrans;
    CheckBox chbStack;
    StringBuilder sb;
    final String LOG_TAG = "myLogs";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frag1 = new Fragment1();
        frag2 = new Fragment2();
    }

    public void onClick(View v) {
        List<Fragment> lFragm = getFragmentManager().getFragments();
        fTrans = getFragmentManager().beginTransaction();
        Fragment fragment = getFragmentManager().findFragmentByTag("R.id.Fragment1");
        for (Fragment fragm:lFragm) {
            System.out.println(fragm.getTag());
        }

        switch (v.getId()) {
            case R.id.btnAdd:
                if (frag1.isAdded()) {
                    break;
                } else {
                    fTrans.add(R.id.frgmCont, frag1);
                    Log.d(LOG_TAG, "Try to add");
                    current = frag1;
                    fTrans.commit();
                    break;
                }
            case R.id.btnRemove:
                if (frag1.isVisible())
                    current = frag1;
                else
                if (frag2.isVisible())
                    current = frag2;
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

package work.yeshu.englishbook.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import work.yeshu.englishbook.R;
import work.yeshu.englishbook.base.BaseActivity;
import work.yeshu.englishbook.ui.phrase.PhraseTagListFragment;
import work.yeshu.englishbook.ui.profile.ProfileFragment;
import work.yeshu.englishbook.ui.word.WordTagListFragment;

public class MainActivity extends BaseActivity {

    private Fragment mWordTagListFragment;
    private Fragment mPhraseTagListFragment;
    private Fragment mProfileFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_word:
                    showTab(mWordTagListFragment);
                    return true;
                case R.id.navigation_phrase:
                    showTab(mPhraseTagListFragment);
                    return true;
                case R.id.navigation_profile:
                    showTab(mProfileFragment);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWordTagListFragment = WordTagListFragment.newInstance();
        mPhraseTagListFragment = PhraseTagListFragment.newInstance();
        mProfileFragment = ProfileFragment.newInstance();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        showTab(mWordTagListFragment);
    }

    private void showTab(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content, fragment);
        transaction.commit();
    }

}

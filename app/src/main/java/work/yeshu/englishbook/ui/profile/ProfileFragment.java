package work.yeshu.englishbook.ui.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import work.yeshu.englishbook.R;
import work.yeshu.englishbook.base.BaseFragment;

/**
 * Created by yeshu on 2017/11/7.
 * desc:
 */
public class ProfileFragment extends BaseFragment {

    public static ProfileFragment newInstance() {

        Bundle args = new Bundle();

        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        return view;
    }
}

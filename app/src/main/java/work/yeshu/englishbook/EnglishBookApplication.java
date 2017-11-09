package work.yeshu.englishbook;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by yeshu on 2017/11/7.
 * desc:
 */
public class EnglishBookApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        FlowManager.init(this);
    }
}

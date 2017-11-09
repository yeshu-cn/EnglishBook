package work.yeshu.englishbook.ui.word;

import java.util.List;

import work.yeshu.englishbook.base.BasePresenter;
import work.yeshu.englishbook.base.BaseView;
import work.yeshu.englishbook.ui.model.WordTagViewModel;

/**
 * Created by yeshu on 2017/11/8.
 * desc:
 */
public class WordTagListContract {

    interface View extends BaseView<Presenter> {

        void showWordTagList(List<WordTagViewModel> list);
    }


    interface Presenter extends BasePresenter {

        void loadWordTagList();

        void addWordTag(String name);
    }
}

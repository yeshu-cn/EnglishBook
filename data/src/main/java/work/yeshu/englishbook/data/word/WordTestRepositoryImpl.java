package work.yeshu.englishbook.data.word;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import work.yeshu.englishbook.data.converter.WordModelConverter;
import work.yeshu.englishbook.data.db.model.WordModel;
import work.yeshu.englishbook.data.db.model.WordModel_Table;
import work.yeshu.englishbook.domain.model.Word;
import work.yeshu.englishbook.domain.repository.WordRepository;

/**
 * Created by yeshu on 2017/11/3.
 * desc: create test data
 */
public class WordTestRepositoryImpl implements WordRepository {

    private WordModelConverter mWordModelConverter;

    public WordTestRepositoryImpl(WordModelConverter wordModelConverter) {
        mWordModelConverter = wordModelConverter;
    }

    @Override
    public Single<List<Word>> getWordListByTag(String tagId) {
        return Single.just(createTestDataByTag(tagId));
    }

    @Override
    public Completable updateWord(Word word) {
        return Completable.fromAction(() -> {
            mWordModelConverter.domainToWordModel(word).update();
        });
    }

    @Override
    public Completable addWord(Word word) {
        return Completable.fromAction(() -> {
            mWordModelConverter.domainToWordModel(word).save();
        });
    }

    @Override
    public Completable deleteWord(String id) {
        return Completable.fromAction(() -> {
            innerDelete(id);
        });
    }

    private boolean innerDelete(String id) {
        WordModel model = SQLite.select().from(WordModel.class).where(WordModel_Table.id.eq(id)).querySingle();
        if (null != model) {
            return model.delete();
        }

        return false;
    }

    private List<Word> createTestDataByTag(String tagId) {
        List<Word> words = new ArrayList<>();
        words.add(new Word("1", "Monday", "星期一", tagId));
        words.add(new Word("2", "Tuesday", "星期二", tagId));
        words.add(new Word("3", "Wednesday", "星期三", tagId));
        words.add(new Word("4", "Thursday", "星期四", tagId));
        words.add(new Word("5", "Friday", "星期五", tagId));
        words.add(new Word("6", "Saturday", "星期六", tagId));
        words.add(new Word("7", "Sunday", "星期日", tagId));
        return  words;
    }
}

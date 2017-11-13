package work.yeshu.englishbook.data.word;

import com.annimon.stream.Stream;
import com.raizlabs.android.dbflow.sql.language.SQLite;

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
 * desc:
 */
public class WordRepositoryImpl implements WordRepository {

    private WordModelConverter mWordModelConverter;

    public WordRepositoryImpl(WordModelConverter wordModelConverter) {
        mWordModelConverter = wordModelConverter;
    }

    @Override
    public Single<List<Word>> getWordListByTag(String tagId) {
        List<WordModel> wordModelList = SQLite.select().from(WordModel.class).where(WordModel_Table.tagId.eq(tagId)).queryList();
        return Single.just(Stream.of(wordModelList).map(mWordModelConverter::wordModelToDomain).toList());
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
}

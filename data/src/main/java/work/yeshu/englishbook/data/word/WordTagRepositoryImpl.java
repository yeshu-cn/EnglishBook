package work.yeshu.englishbook.data.word;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import work.yeshu.englishbook.data.converter.WordModelConverter;
import work.yeshu.englishbook.data.db.model.WordTagModel;
import work.yeshu.englishbook.data.db.model.WordTagModel_Table;
import work.yeshu.englishbook.domain.model.WordTag;
import work.yeshu.englishbook.domain.repository.WordTagRepository;

/**
 * Created by yeshu on 2017/11/3.
 * desc:
 */
public class WordTagRepositoryImpl implements WordTagRepository {

    private final WordModelConverter mWordModelConverter;

    public WordTagRepositoryImpl(WordModelConverter wordModelConverter) {
        mWordModelConverter = wordModelConverter;
    }

    @Override
    public Completable addWordTag(String name) {
        return Completable.fromAction(() -> innerAddWordTag(name));
    }

    @Override
    public Single<List<WordTag>> getWordTagList() {
        List<WordTagModel> data = SQLite.select().from(WordTagModel.class).queryList();
        return Single.just(Stream.of(data)
                .map(mWordModelConverter::wordTagModelToDomain)
                .collect(Collectors.toList()));
    }

    @Override
    public Completable deleteWordTag(String id) {
        return Completable.fromAction(() -> innerDeleteWordTag(id));
    }

    @Override
    public Completable updateWordTag(WordTag wordTag) {
        return Completable.fromAction(() -> innerUpdateWordTag(wordTag));
    }

    private void innerAddWordTag(String name) {
        WordTagModel wordTag = new WordTagModel(name);
        wordTag.save();
    }

    private void innerUpdateWordTag(WordTag wordTag) {
        WordTagModel wordTagModel = mWordModelConverter.domainToWordTagModel(wordTag);
        wordTagModel.update();
    }

    private boolean innerDeleteWordTag(String id) {
        WordTagModel wordTagModel = SQLite.select().from(WordTagModel.class).where(WordTagModel_Table.id.eq(id)).querySingle();
        if (null != wordTagModel) {
            return wordTagModel.delete();
        }

        return false;
    }
}

package work.yeshu.englishbook.data.converter;

import work.yeshu.englishbook.data.db.model.WordModel;
import work.yeshu.englishbook.data.db.model.WordTagModel;
import work.yeshu.englishbook.domain.model.Word;
import work.yeshu.englishbook.domain.model.WordTag;

/**
 * Created by yeshu on 2017/11/9.
 * desc:
 */
public interface WordModelConverter {
    Word wordModelToDomain(WordModel wordModel);

    WordTag wordTagModelToDomain(WordTagModel wordTagModel);

    WordModel domainToWordModel(Word word);

    WordTagModel domainToWordTagModel(WordTag wordTag);
}

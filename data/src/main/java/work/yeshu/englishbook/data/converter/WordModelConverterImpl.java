package work.yeshu.englishbook.data.converter;

import work.yeshu.englishbook.data.db.model.WordModel;
import work.yeshu.englishbook.data.db.model.WordTagModel;
import work.yeshu.englishbook.domain.model.Word;
import work.yeshu.englishbook.domain.model.WordTag;

/**
 * Created by yeshu on 2017/11/9.
 * desc:
 */
public class WordModelConverterImpl implements WordModelConverter {
    @Override
    public Word wordModelToDomain(WordModel wordModel) {
        return new Word(wordModel.id, wordModel.spell, wordModel.notes, wordModel.tagId);
    }

    @Override
    public WordTag wordTagModelToDomain(WordTagModel wordTagModel) {
        return new WordTag(wordTagModel.id, wordTagModel.name);
    }

    @Override
    public WordModel domainToWordModel(Word word) {
        return new WordModel(word.id, word.spell, word.notes, word.tagId);
    }

    @Override
    public WordTagModel domainToWordTagModel(WordTag wordTag) {
        return new WordTagModel(wordTag.id, wordTag.name);
    }
}

package work.yeshu.englishbook.ui.mapper;

import com.annimon.stream.Stream;

import java.util.List;

import work.yeshu.englishbook.domain.model.Word;
import work.yeshu.englishbook.domain.model.WordTag;
import work.yeshu.englishbook.ui.model.WordTagViewModel;
import work.yeshu.englishbook.ui.model.WordViewModel;

/**
 * Created by yeshu on 2017/11/7.
 * desc:
 */
public class WordViewModelMapperImpl implements WordViewModelMapper {
    @Override
    public WordViewModel mapWordToViewModel(Word word) {
        return new WordViewModel(word.id, word.spell, word.notes, word.tagId);
    }

    @Override
    public List<WordViewModel> mapWordsToViewModels(List<Word> words) {
        return Stream.of(words)
                .map(this::mapWordToViewModel)
                .toList();
    }

    @Override
    public WordTagViewModel mapWordTagToViewModel(WordTag wordTag) {
        return new WordTagViewModel(wordTag.id, wordTag.name);
    }

    @Override
    public List<WordTagViewModel> mapWordTagsToViewModels(List<WordTag> wordTags) {
        return Stream.of(wordTags)
                .map(this::mapWordTagToViewModel)
                .toList();
    }
}

package work.yeshu.englishbook.ui.mapper;

import java.util.List;

import work.yeshu.englishbook.domain.model.Word;
import work.yeshu.englishbook.domain.model.WordTag;
import work.yeshu.englishbook.ui.model.WordTagViewModel;
import work.yeshu.englishbook.ui.model.WordViewModel;

/**
 * Created by yeshu on 2017/11/7.
 * desc:
 */
public interface WordViewModelMapper {

    WordViewModel mapWordToViewModel(Word word);

    List<WordViewModel> mapWordsToViewModels(List<Word> words);

    WordTagViewModel mapWordTagToViewModel(WordTag wordTag);

    List<WordTagViewModel> mapWordTagsToViewModels(List<WordTag> wordTags);
}

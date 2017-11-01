package work.yeshu.englishbook.domain.interactor.word;

import io.reactivex.Completable;
import work.yeshu.englishbook.domain.interactor.type.CompletableUseCaseWithParameter;
import work.yeshu.englishbook.domain.model.Word;
import work.yeshu.englishbook.domain.repository.WordRepository;

/**
 * Created by yeshu on 2017/11/1.
 */

public class AddWordUseCase implements CompletableUseCaseWithParameter<Word>{
    private final WordRepository mWordRepository;

    public AddWordUseCase(WordRepository wordRepository) {
        mWordRepository = wordRepository;
    }

    @Override
    public Completable execute(Word word) {
        return mWordRepository.addWord(word.spell, word.notes);
    }
}

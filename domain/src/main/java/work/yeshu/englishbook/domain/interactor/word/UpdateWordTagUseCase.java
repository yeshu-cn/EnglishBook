package work.yeshu.englishbook.domain.interactor.word;

import io.reactivex.Completable;
import work.yeshu.englishbook.domain.interactor.type.CompletableUseCaseWithParameter;
import work.yeshu.englishbook.domain.model.WordTag;
import work.yeshu.englishbook.domain.repository.WordTagRepository;

/**
 * Created by yeshu on 2017/11/1.
 */

public class UpdateWordTagUseCase implements CompletableUseCaseWithParameter<WordTag>{
    private final WordTagRepository mWordTagRepository;

    public UpdateWordTagUseCase(WordTagRepository wordTagRepository) {
        mWordTagRepository = wordTagRepository;
    }

    @Override
    public Completable execute(WordTag wordTag) {
        return mWordTagRepository.updateWordTag(wordTag);
    }
}

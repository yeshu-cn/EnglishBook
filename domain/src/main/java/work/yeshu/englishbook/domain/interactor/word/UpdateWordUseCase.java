package work.yeshu.englishbook.domain.interactor.word;

import io.reactivex.Completable;
import work.yeshu.englishbook.domain.interactor.type.CompletableUseCaseWithParameter;
import work.yeshu.englishbook.domain.repository.WordRepository;

/**
 * Created by yeshu on 2017/11/1.
 */

public class UpdateWordUseCase implements CompletableUseCaseWithParameter<String> {
    private final WordRepository mWordRepository;

    public UpdateWordUseCase(WordRepository wordRepository) {
        mWordRepository = wordRepository;
    }

    @Override
    public Completable execute(String notes) {
        return null;
    }
}

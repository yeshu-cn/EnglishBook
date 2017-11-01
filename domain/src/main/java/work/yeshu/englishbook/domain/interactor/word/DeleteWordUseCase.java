package work.yeshu.englishbook.domain.interactor.word;

import io.reactivex.Completable;
import work.yeshu.englishbook.domain.interactor.type.CompletableUseCaseWithParameter;
import work.yeshu.englishbook.domain.repository.WordRepository;

/**
 * Created by yeshu on 2017/11/1.
 */

public class DeleteWordUseCase implements CompletableUseCaseWithParameter<String>{
    private final WordRepository mWordRepository;

    public DeleteWordUseCase(WordRepository wordRepository) {
        mWordRepository = wordRepository;
    }

    @Override
    public Completable execute(String id) {
        return mWordRepository.deleteWord(id);
    }
}

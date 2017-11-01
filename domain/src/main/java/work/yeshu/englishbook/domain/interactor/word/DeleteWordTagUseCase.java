package work.yeshu.englishbook.domain.interactor.word;

import io.reactivex.Completable;
import work.yeshu.englishbook.domain.interactor.type.CompletableUseCaseWithParameter;
import work.yeshu.englishbook.domain.repository.WordRepository;
import work.yeshu.englishbook.domain.repository.WordTagRepository;

/**
 * Created by yeshu on 2017/11/1.
 */

public class DeleteWordTagUseCase implements CompletableUseCaseWithParameter<String> {
    private final WordTagRepository mWordTagRepository;
    private final WordRepository mWordRepository;

    public DeleteWordTagUseCase(WordTagRepository wordTagRepository, WordRepository wordRepository) {
        mWordTagRepository = wordTagRepository;
        mWordRepository = wordRepository;
    }

    @Override
    public Completable execute(String id) {
        //ArrayList<Word> wordList = mWordRepository.getWordListByTag(id);
        //级联删除
        return mWordTagRepository.deleteWordTag(id);
    }
}

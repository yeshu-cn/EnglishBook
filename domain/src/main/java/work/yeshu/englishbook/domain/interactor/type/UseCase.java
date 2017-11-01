package work.yeshu.englishbook.domain.interactor.type;


import io.reactivex.Observable;

public interface UseCase<T> {

    //这个抽象的方法，并不能满足所有的情况
    Observable<T> execute();
}

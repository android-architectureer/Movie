package com.tritech.movies.domain.interactor;

import com.tritech.movies.domain.executor.PostExecutionThread;
import com.tritech.movies.domain.executor.ThreadExecutor;
import com.tritech.movies.domain.model.ReviewDomainModel;
import com.tritech.movies.domain.repository.MoviesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetMovieReviewUseCase extends UseCase<List<ReviewDomainModel>,GetMovieReviewUseCase.Param> {

    private final MoviesRepository repository;

    @Inject
    GetMovieReviewUseCase(MoviesRepository repository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    Observable<List<ReviewDomainModel>> buildUseCaseObservable(GetMovieReviewUseCase.Param param) {
        return repository.fetchDataMovieReview(param.movieId,param.api_key) ;
    }

    public static class Param{
        public long movieId;
        public String api_key;
    }
}

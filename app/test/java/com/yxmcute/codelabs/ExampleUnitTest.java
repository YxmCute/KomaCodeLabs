package com.yxmcute.codelabs;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
  @Test
  public void addition_isCorrect() {
    assertEquals(4, 2 + 2);
  }


  @Test
  public void rx() {
   /* Flowable.just("1", "@").subscribe(new Consumer<String>() {
      @Override public void accept(String s) throws Exception {
        System.out.println(s);
      }
    });*/
    Observable observable = Observable.create(new ObservableOnSubscribe<String>() {
      @Override public void subscribe(ObservableEmitter<String> emitter) throws Exception {
        emitter.onNext("Xxx");
        emitter.onNext("11");
        emitter.onNext("@22");
        emitter.onComplete();

      }
    }).subscribeOn(Schedulers.newThread());
    observable.

        subscribe(new Observer() {
          @Override public void onSubscribe(Disposable d) {
            //d.dispose();

          }


          @Override public void onNext(Object o) {
            System.out.println(Thread.currentThread().getId());

            String s = (String) o;
            System.out.println(s);

          }


          @Override public void onError(Throwable e) {

          }


          @Override public void onComplete() {
             System.out.println("onComplete");

          }



        });
    Observable.just("x",1,1l);

  }
}
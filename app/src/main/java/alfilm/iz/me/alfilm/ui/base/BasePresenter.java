package alfilm.iz.me.alfilm.ui.base;

import alfilm.iz.me.alfilm.utils.RxUtils;
import io.reactivex.disposables.CompositeDisposable;
import org.greenrobot.eventbus.EventBus;

public abstract class BasePresenter<T extends MvpView> implements Presenter<T> {

  private T mMvpView;

  protected CompositeDisposable disposables;

  @Override public void attachView(T mvpView) {
    mMvpView = mvpView;
  }

  @Override public void detachView() {
    mMvpView = null;
    if (disposables != null) {
      RxUtils.unsubscribeIfNotNull(disposables);
    }
    onViewDetached();
  }

  public boolean isViewAttached() {
    return mMvpView != null;
  }

  public T getMvpView() {
    checkViewAttached();
    return mMvpView;
  }

  public void checkViewAttached() {
    if (!isViewAttached()) throw new MvpViewNotAttachedException();
  }



  private static class MvpViewNotAttachedException extends RuntimeException {
    MvpViewNotAttachedException() {
      super(
          "Please call Presenter.attachView(MvpView) before" + " requesting data to the Presenter");
    }
  }

  protected abstract void onViewDetached();

  protected void removeStickyEvent(Class clazz) {
    EventBus.getDefault().removeStickyEvent(clazz);
  }
}
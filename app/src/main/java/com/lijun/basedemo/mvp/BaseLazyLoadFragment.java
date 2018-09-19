package com.lijun.basedemo.mvp;

/**
 * Created by Leslie on 2017/5/22.
 *
 * @description:
 */

/*
public abstract class BaseLazyLoadFragment<V extends BaseView, P extends BasePresenter<V>> extends MvpFragment<V, P> {
    protected Context context;
  protected boolean isVisible;
    private View rootView;
    private Unbinder unbinder;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView != null) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);
            }
            return rootView;
        }

        if (getRootViewId() != 0) {
            rootView = inflater.inflate(getRootViewId(), container, false);
        } else {
            rootView = super.onCreateView(inflater, container, savedInstanceState);
        }

        context = getActivity();

        unbinder = ButterKnife.bind(this, rootView);
        LogUtils.d("onCreatedView");
        initUI();
        return rootView;
    }
    public void replaceFragment(@IdRes int id, Fragment fragment) {
        getFragmentManager().beginTransaction().replace(id, fragment).commit();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    protected void onVisible() {
        initData();
    }

    protected void onInvisible() {
      if (unbinder != null) {
        unbinder.unbind();
      }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }

    }

    public View getRootView() {
        return rootView;
    }


  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    public <T> void toSetList(List<T> list, List<T> newList, boolean isMore) {

        if (list != null && newList != null) {
            synchronized (BaseLazyLoadFragment.class) {
                if (!isMore) {
                    list.clear();
                }
                list.addAll(newList);
            }
        }
    }

    public abstract int getRootViewId();

    public abstract void initUI();

    //进行懒加载
    public abstract void initData();
}
*/

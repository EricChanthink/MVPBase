package cn.ericchan.mvpdemo.model;

import cn.ericchan.mvpdemo.api.Api;
import cn.ericchan.mvpdemo.bean.ArticleListBean;
import cn.ericchan.mvpdemo.utils.LP;
import cn.ericchan.mvpdemo.utils.NetUtils;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SingleInterfaceModel implements ISingleInterfaceModel{
    public void getData(int curPage, final ICallback callback) {
        NetUtils.getRetrofit()
                .create(Api.class)
                .getData(curPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ArticleListBean>() {
                    @Override
                    public void onCompleted() {
                        LP.w("completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail("出现错误");
                    }

                    @Override
                    public void onNext(ArticleListBean bean) {
                        if (null == bean) {
                            callback.onFail("出现错误");
                        } else if (bean.errorCode != 0) {
                            callback.onFail(bean.errorMsg);
                        } else {
                            callback.onSuccess(bean);
                        }
                    }
                });
    }
}

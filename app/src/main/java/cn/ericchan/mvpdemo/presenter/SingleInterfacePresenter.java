package cn.ericchan.mvpdemo.presenter;

import cn.ericchan.mvpdemo.bean.ArticleListBean;
import cn.ericchan.mvpdemo.model.Callback;
import cn.ericchan.mvpdemo.model.SingleInterfaceModel;

public class SingleInterfacePresenter {
    private final SingleInterfaceModel singleInterfaceModel;

    public SingleInterfacePresenter() {
        this.singleInterfaceModel = new SingleInterfaceModel();
    }

    public void getData(int curPage) {
        singleInterfaceModel.getData(curPage, new Callback<ArticleListBean, String>() {
            @Override
            public void onSuccess(ArticleListBean loginResultBean) {
                //如果Model层请求数据成功,则此处应执行通知View层的代码

            }

            @Override
            public void onFail(String errorMsg) {
                //如果Model层请求数据失败,则此处应执行通知View层的代码

            }
        });
    }
}
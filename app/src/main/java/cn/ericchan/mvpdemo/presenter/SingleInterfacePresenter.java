package cn.ericchan.mvpdemo.presenter;

import cn.ericchan.mvpdemo.bean.ArticleListBean;
import cn.ericchan.mvpdemo.contract.SingleInterfaceContract;
import cn.ericchan.mvpdemo.model.ICallback;
import cn.ericchan.mvpdemo.model.ISingleInterfaceModel;
import cn.ericchan.mvpdemo.model.SingleInterfaceModel;
import cn.ericchan.mvpdemo.utils.LP;

public class SingleInterfacePresenter extends BasePresenter<SingleInterfaceContract.View> implements SingleInterfaceContract.Presenter{
    private final ISingleInterfaceModel singleInterfaceModel;

    public SingleInterfacePresenter() {
        this.singleInterfaceModel = new SingleInterfaceModel();
    }

    public void getData(int curPage) {
        singleInterfaceModel.getData(curPage, new ICallback<ArticleListBean, String>() {
            @Override
            public void onSuccess(ArticleListBean loginResultBean) {
                //如果Model层请求数据成功,则此处应执行通知View层的代码
                LP.w(loginResultBean.toString());
                if (isViewAttached()) {
                    mView.showArticleSuccess(loginResultBean);
                }
            }

            @Override
            public void onFail(String errorMsg) {
                //如果Model层请求数据失败,则此处应执行通知View层的代码
                LP.w(errorMsg);
                if (isViewAttached()) {
                    mView.showArticleFail(errorMsg);
                }
            }
        });
    }
}

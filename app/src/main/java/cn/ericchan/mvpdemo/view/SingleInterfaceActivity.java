package cn.ericchan.mvpdemo.view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import cn.ericchan.mvpdemo.R;
import cn.ericchan.mvpdemo.bean.ArticleListBean;
import cn.ericchan.mvpdemo.contract.SingleInterfaceContract;
import cn.ericchan.mvpdemo.presenter.SingleInterfacePresenter;

public class SingleInterfaceActivity extends BaseMVPActivity<SingleInterfacePresenter> implements SingleInterfaceContract.View {

    private Button button;
    private TextView textView;

    private SingleInterfacePresenter singleInterfacePresenter;

    @Override
    protected SingleInterfacePresenter createPresenter() {
        return new SingleInterfacePresenter();
    }

    @Override
    protected void init() {
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getData(0);
            }
        });
    }

    @Override
    public void showArticleSuccess(ArticleListBean bean) {
        textView.setText(bean.data.datas.get(0).title);
    }

    @Override
    public void showArticleFail(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }
}

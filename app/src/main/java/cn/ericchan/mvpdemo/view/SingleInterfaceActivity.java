package cn.ericchan.mvpdemo.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import cn.ericchan.mvpdemo.R;
import cn.ericchan.mvpdemo.presenter.SingleInterfacePresenter;

public class SingleInterfaceActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;

    private SingleInterfacePresenter singleInterfacePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        singleInterfacePresenter = new SingleInterfacePresenter();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleInterfacePresenter.getData(0);
            }
        });

    }
}

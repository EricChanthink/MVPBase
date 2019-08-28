package cn.ericchan.mvpdemo.model;

public interface ICallback<K, V> {
    void onSuccess(K data);

    void onFail(V data);
}

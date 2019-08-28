package cn.ericchan.mvpdemo.model;

public interface IResultCallback<K, V> {
    void onSuccess(K data);

    void onFail(V data);
}

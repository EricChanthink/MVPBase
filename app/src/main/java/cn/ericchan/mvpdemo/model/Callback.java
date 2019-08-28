package cn.ericchan.mvpdemo.model;

public interface Callback<K, V> {
    void onSuccess(K data);

    void onFail(V data);
}

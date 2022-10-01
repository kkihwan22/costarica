package me.kkihwan.web.shared.entrypoint;

import lombok.*;

public class SimpleBodyData<T> {

    @Getter @Setter
    private T result;

    public SimpleBodyData(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "SimpleResponseData{" +
                "result=" + result +
                '}';
    }
}

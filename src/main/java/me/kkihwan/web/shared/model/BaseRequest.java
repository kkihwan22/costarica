package me.kkihwan.web.shared.model;

public interface BaseRequest<T extends BaseParameter> {

    T toParameter();
}

package me.kkihwan.web.shared.application;

import lombok.Getter;

import javax.xml.validation.Validator;

@Getter
public abstract class CommandValidator<T> {

    private Validator validator;
}

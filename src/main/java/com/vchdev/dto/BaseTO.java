package com.vchdev.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public abstract class BaseTO<E extends Serializable> {
    private E id;
}

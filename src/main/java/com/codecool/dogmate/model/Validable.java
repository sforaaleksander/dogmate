package com.codecool.dogmate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface Validable {
    @JsonIgnore
    boolean isValid();
}

package com.codecool.dogmate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface Archivable {
    @JsonIgnore
    Boolean getActive();

    void setActive(Boolean active);
}

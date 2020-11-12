package com.codecool.dogmate.service;

import com.codecool.dogmate.model.UserType;
import com.codecool.dogmate.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTypeService extends GenericService<UserType> {

    @Autowired
    UserTypeService(UserTypeRepository repository) {
        super(repository);
    }

    public UserType getByName(String name) {
        return ((UserTypeRepository) repository).findByNameIgnoreCase(name);
    }
}

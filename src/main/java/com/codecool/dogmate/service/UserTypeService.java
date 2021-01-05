package com.codecool.dogmate.service;

import com.codecool.dogmate.model.UserType;
import com.codecool.dogmate.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserTypeService extends GenericPagingAndSortingService<UserType, Long> {

    @Autowired
    UserTypeService(UserTypeRepository repository) {
        super(repository);
    }

    @Override
    @Cacheable("user_types")
    public Iterable<UserType> getAllPagedAndSorted(Integer page, Integer size, String[] sortBy) {
        return super.getAllPagedAndSorted(page, size, sortBy);
    }

    @Override
    @Cacheable("user_types")
    public UserType getById(Long aLong) {
        return super.getById(aLong);
    }
}

package com.codecool.dogmate.service;

import com.codecool.dogmate.model.Archivable;
import com.codecool.dogmate.model.Indexable;
import org.springframework.data.repository.PagingAndSortingRepository;

public abstract class GenericRemovableService<T extends Indexable<ID> & Archivable, ID> extends GenericService<T, ID> {

    public GenericRemovableService(PagingAndSortingRepository<T, ID> repository) {
        super(repository);
    }

    public void removeById(ID id) {
        T t = getById(id);

        t.setActive(false);
        repository.save(t);
    }
}

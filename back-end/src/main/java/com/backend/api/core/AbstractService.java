package com.backend.api.core;

import com.backend.api.pessoa.Pessoa;
import com.backend.api.core.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractService<T extends AbstractEntity, R extends JpaRepository<T, Integer>> {

    @Autowired
    private R repository;

    public Page<T> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    public T save(T o) {
        return this.repository.save(o);
    }

    public T findById(Integer id) {
        return this.repository.findById(id).orElseThrow(() ->
                new ServiceException("Object not found with id", id));
    }

    public void deleteById(Integer id) {
        this.repository.deleteById(id);
    }

    public abstract Pessoa update(Pessoa p);

    public R getRepository() { return this.repository; }
}

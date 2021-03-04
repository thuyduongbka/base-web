package com.duong.demo._web.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public abstract class BaseService<E extends BaseEntity, R extends BaseRepository> {
    @Autowired
    protected R repository;

    /**
     * Create
     */
    public E save(E entity) {
        if (entity == null) {
            return null;
        }
        return (E) repository.save(entity);
    }

    public E saveAndFlush(E entity) {
        if (entity == null) {
            return null;
        }

        return (E) repository.saveAndFlush(entity);
    }

    /**
     * Use to generate mock statistic data. If you want to use, you need to call "preSave" method to create enough information.
     */

    public List<E> saveOrUpdateList(Collection<E> entities) {
        return repository.saveAll(entities);
    }

    public boolean deleteAList(List<E> entities) {

        if (entities == null || entities.size() <= 0) {
            return false;
        } else {
            repository.saveAll(entities);
            return true;
        }
    }

    /**
     * Service Read
     */
    public E findById(Long id) {
        Object entity = repository.findById(id).orElse(null);

        if (entity == null) {
            return null;
        }

        return (E) entity;
    }

    /**
     * Service Read
     */
    public List<E> findByIdIn(List<Long> ids) {

        if (ids == null || ids.isEmpty()) {
            return new ArrayList<>();

        } else {
            return repository.findAllById(ids);
        }
    }

    /**
     * Service Read
     */
    public E findByCode(String code) {
        return findByCode(UUID.fromString(code));
    }

    /**
     * Service Read
     */
    public E findByCode(UUID code) {
        Object entity = repository.findByCode(code);

        if (entity == null) {
            return null;
        }

        return (E) entity;
    }


    /**
     * Update
     */
    public E update(E entity) {
        if (entity == null || entity.getId() == null) {
            return null;
        } else {
            return (E) repository.save(entity);
        }
    }



    /**
     * Get findAll
     *
     * @param page
     * @return
     */
    public Page<E> findAll(Pageable page) {
        return repository.findAll(page);
    }

    /**
     * Get findAll
     *
     * @param page
     * @return
     */
    public Page<E> findAll(Pageable page, boolean isDeleted) {
        return repository.findByIsDeleted(page, isDeleted);
    }

    /**
     * Delete
     */
    public boolean delete(String code) {
        return delete(UUID.fromString(code));
    }

    /**
     * Delete
     */
    public boolean delete(UUID code) {
        Object entityObj = repository.findByCode(code);
        if (entityObj == null) {
            return false;
        } else {
            E entity = (E) entityObj;
            entity.setDeleted(true); // logic delete
            repository.save(entity);
            return true;
        }
    }

}

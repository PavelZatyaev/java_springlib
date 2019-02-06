package ru.javabegin.training.library.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javabegin.training.library.dao.AuthorDao;
import ru.javabegin.training.library.domain.Author;
import ru.javabegin.training.library.spring.repository.AuthorRepository;

import java.util.List;


// сервисный уровень для работы с авторами
// API для реализованных бизнес процессов
// код должен обращаться только через Service (не к Repository напрямую)
@Service // сервисный Spring бин
@Transactional // методы помечаются как транзакционные (для запросов применяются настройки транзакций по-умолчанию, уровень изоляции и пр.)
public class AuthorService implements AuthorDao {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    public List<Author> getAll(Sort sort) {
        return authorRepository.findAll(sort);
    }



    @Override
    public Page<Author> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return authorRepository.findAll(PageRequest.of(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }

    @Override
    public List<Author> search(String... searchString) {
        return authorRepository.findByFioContainingIgnoreCaseOrderByFio(searchString[0]);
    }

    @Override
    public Page<Author> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return authorRepository.findByFioContainingIgnoreCaseOrderByFio(searchString[0], PageRequest.of(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }


    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void delete(Author author) {
        authorRepository.delete(author);
    }

    @Override
    public Author get(long id) {
        return authorRepository.getOne(id);
    }

//package org.springframework.data.repository.query;
//    public interface QueryByExampleExecutor<T> {
//
//        /**
//         * Returns a single entity matching the given {@link Example} or {@literal null} if none was found.
//         *
//         * @param example must not be {@literal null}.
//         * @return a single entity matching the given {@link Example} or {@link Optional#empty()} if none was found.
//         * @throws org.springframework.dao.IncorrectResultSizeDataAccessException if the Example yields more than one result.
//         */
//        <S extends T> Optional<S> findOne(Example<S> example);


//package org.springframework.data.repository;
//
//import java.io.Serializable;
//
//    /**
//     * Interface for generic CRUD operations on a repository for a specific type.
//     *
//     * @author Oliver Gierke
//     * @author Eberhard Wolff
//     */
//    @NoRepositoryBean
//    public interface CrudRepository<T, ID extends Serializable> extends Repository<T, ID> {
//
//        /**
//         * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the
//         * entity instance completely.
//         *
//         * @param entity
//         * @return the saved entity
//         */
//        <S extends T> S save(S entity);
//
//        /**
//         * Saves all given entities.
//         *
//         * @param entities
//         * @return the saved entities
//         * @throws IllegalArgumentException in case the given entity is {@literal null}.
//         */
//        <S extends T> Iterable<S> save(Iterable<S> entities);
//
//        /**
//         * Retrieves an entity by its id.
//         *
//         * @param id must not be {@literal null}.
//         * @return the entity with the given id or {@literal null} if none found
//         * @throws IllegalArgumentException if {@code id} is {@literal null}
//         */
//        T findOne(ID id);



}

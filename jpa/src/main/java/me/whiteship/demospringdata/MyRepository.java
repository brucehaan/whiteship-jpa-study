package me.whiteship.demospringdata;

import jakarta.annotation.Nullable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface MyRepository<T, ID extends Serializable> extends Repository<T, ID> {

    <E extends T> E save(E entity);

    List<T> findAll();

    long count();

    @Nullable
    <E extends T> E findById(ID id);
}

package com.volerde.myweb.service;

import com.volerde.myweb.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * The interface Classification service.
 *
 * @author Volerde
 * @date 2021 /8/19 11:21
 */
public interface ClassificationService {
    /**
     * Save type type.
     *
     * @param type the type
     * @return the type
     */
    Type saveType(Type type);

    /**
     * Gets type.
     *
     * @param id the id
     * @return the type
     */
    Type  getType(Long id);

    Type getTypeByName(String name);

    /**
     * Listtype page.
     *
     * @param pageable the pageable
     * @return the page
     */
    Page<Type> listType(Pageable pageable);

    List<Type> listType();

    List<Type> listTypeTop(Integer size);

    /**
     * Update type type.
     *
     * @param id   the id
     * @param type the type
     * @return the type
     */
    Type updateType(Long id, Type type);

    /**
     * DeleteType.
     *
     * @param id the id
     */
    void deleteType(Long id);
}

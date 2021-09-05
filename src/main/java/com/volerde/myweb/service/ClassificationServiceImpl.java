package com.volerde.myweb.service;

import com.volerde.myweb.NotFoundException;
import com.volerde.myweb.dao.ClassificationRepository;
import com.volerde.myweb.pojo.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * @author Volerde
 * @date 2021/8/19 11:29
 */
@Service
public class ClassificationServiceImpl implements ClassificationService{

    @Autowired
    private ClassificationRepository registry;

    @Override
    @Transactional
    public Type saveType(Type type) {
        return registry.save(type);
    }

    @Override
    @Transactional
    public Type getType(Long id) {
        return registry.getById(id);
    }

    @Override
    @Transactional
    public Type getTypeByName(String name) {
        return registry.findByName(name);
    }

    @Override
    @Transactional
    public Page<Type> listType(Pageable pageable) {
        return registry.findAll(pageable);
    }

    @Override
    public List<Type> listType() {
        return registry.findAll();
    }

    @Override
    public List<Type> listTypeTop(Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC,"blogs.size");
        Pageable pageable = PageRequest.of(0,size,sort);
        return registry.findTop(pageable);
    }

    @Override
    @Transactional
    public Type updateType(Long id, Type type) {
        Type t = registry.getById(id);
        if(t == null){
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(type,t);
        return registry.save(t);
    }

    @Override
    @Transactional
    public void deleteType(Long id) {
        registry.deleteById(id);
    }
}

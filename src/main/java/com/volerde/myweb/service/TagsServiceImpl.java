package com.volerde.myweb.service;

import com.volerde.myweb.NotFoundException;
import com.volerde.myweb.dao.TagsRepository;
import com.volerde.myweb.pojo.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Volerde
 * @date 2021/8/22 21:24
 */
@Service
public class TagsServiceImpl implements TagsService{

    @Autowired
    private TagsRepository repository;

    @Override
    @Transactional
    public Tag saveTag(Tag tag) {
        return repository.save(tag);
    }

    @Override
    @Transactional
    public Tag getTag(Long id) {
        return repository.getById(id);
    }

    @Override
    @Transactional
    public Tag getTagByName(String name) {
        return repository.getTagByName(name);
    }

    @Override
    @Transactional
    public Page<Tag> listTag(Pageable Pageable) {
        return repository.findAll(Pageable);
    }

    @Override
    public List<Tag> listTag() {
        return repository.findAll();
    }

    @Override
    public List<Tag> listTagTop(Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC,"blogs.size");
        Pageable pageable = PageRequest.of(0,size,sort);
        return repository.findTop(pageable);
    }

    @Override
    public List<Tag> listTag(String ids) {
        return repository.findAllById(convertToList(ids));
    }
    private List<Long> convertToList(String ids) {
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null){
            String[] idarray = ids.split(",");
            for (int i = 0; i < idarray.length;i++){
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }

    @Override
    @Transactional
    public Tag updateTag(Long id, Tag tag) throws NotFoundException {
        Tag t = repository.getById(id);
        if (t == null){
            throw new NotFoundException("不存在该标签");
        }
        BeanUtils.copyProperties(tag,t);
        return repository.save(t);
    }

    @Override
    @Transactional
    public void deleteTag(Long id) {
        repository.deleteById(id);
    }
}

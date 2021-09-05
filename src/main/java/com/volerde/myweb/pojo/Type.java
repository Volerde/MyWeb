package com.volerde.myweb.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Type.
 *
 * @author Volerde
 * @date 2021 /8/16 17:51
 */
@Entity
@Table(name = "t_type")
public class Type {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "type")
    private List<Blog> blogs = new ArrayList<Blog>();

    /**
     * Instantiates a new Type.
     */
    public Type() {
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets blogs.
     *
     * @return the blogs
     */
    public List<Blog> getBlogs() {
        return blogs;
    }

    /**
     * Sets blogs.
     *
     * @param blogs the blogs
     */
    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

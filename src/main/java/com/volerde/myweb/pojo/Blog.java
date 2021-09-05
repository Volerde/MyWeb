package com.volerde.myweb.pojo;


import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.core.metrics.StartupStep;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Blog.
 *
 * @author Volerde
 * @date 2021 /8/16 17:37
 */
@Entity
@Table(name = "t_blog")
public class Blog {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Basic(fetch = FetchType.LAZY)
    @Lob
    private String content;
    private String firstPicture;
    private String flag;
    private Integer views;
    /**
     * 是否开启赞赏
     */
    private Boolean appreciationStatus = false;
    /**
     * 是否设置分享
     */
    private Boolean shareStatus = false;
    /**
     * 是否允许评论
     */
    private Boolean commentStatus = false;
    /**
     * 是否推荐
     */
    private Boolean recommendStatus = false;
    /**
     * 是否发布
     */
    private Boolean publishStatus = false;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @ManyToOne
    private Type type;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags = new ArrayList<>();

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();

    @Transient
    private String tagIds;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Instantiates a new Blog.
     */
    public Blog() {
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
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets content.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets content.
     *
     * @param content the content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets first picture.
     *
     * @return the first picture
     */
    public String getFirstPicture() {
        return firstPicture;
    }

    /**
     * Sets first picture.
     *
     * @param firstPicture the first picture
     */
    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    /**
     * Gets flag.
     *
     * @return the flag
     */
    public String getFlag() {
        return flag;
    }

    /**
     * Sets flag.
     *
     * @param flag the flag
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * Gets views.
     *
     * @return the views
     */
    public Integer getViews() {
        return views;
    }

    /**
     * Sets views.
     *
     * @param views the views
     */
    public void setViews(Integer views) {
        this.views = views;
    }

    /**
     * Gets appreciation status.
     *
     * @return the appreciation status
     */
    public Boolean getAppreciationStatus() {
        return appreciationStatus;
    }

    /**
     * Sets appreciation status.
     *
     * @param appreciationStatus the appreciation status
     */
    public void setAppreciationStatus(Boolean appreciationStatus) {
        this.appreciationStatus = appreciationStatus;
    }

    /**
     * Gets share status.
     *
     * @return the share status
     */
    public Boolean getShareStatus() {
        return shareStatus;
    }

    /**
     * Sets share status.
     *
     * @param shareStatus the share status
     */
    public void setShareStatus(Boolean shareStatus) {
        this.shareStatus = shareStatus;
    }

    /**
     * Gets comment status.
     *
     * @return the comment status
     */
    public Boolean getCommentStatus() {
        return commentStatus;
    }

    /**
     * Sets comment status.
     *
     * @param commentStatus the comment status
     */
    public void setCommentStatus(Boolean commentStatus) {
        this.commentStatus = commentStatus;
    }

    /**
     * Gets recommend status.
     *
     * @return the recommend status
     */
    public Boolean getRecommendStatus() {
        return recommendStatus;
    }

    /**
     * Sets recommend status.
     *
     * @param recommendStatus the recommend status
     */
    public void setRecommendStatus(Boolean recommendStatus) {
        this.recommendStatus = recommendStatus;
    }

    /**
     * Gets publish status.
     *
     * @return the publish status
     */
    public Boolean getPublishStatus() {
        return publishStatus;
    }

    /**
     * Sets publish status.
     *
     * @param publishStatus the publish status
     */
    public void setPublishStatus(Boolean publishStatus) {
        this.publishStatus = publishStatus;
    }

    /**
     * Gets created date.
     *
     * @return the created date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * Sets created date.
     *
     * @param createDate the created date
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * Gets updated date.
     *
     * @return the updated date
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * Sets updated date.
     *
     * @param updateDate the updated date
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * Gets tags.
     *
     * @return the tags
     */
    public List<Tag> getTags() {
        return tags;
    }

    /**
     * Sets tags.
     *
     * @param tags the tags
     */
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets comments.
     *
     * @return the comments
     */
    public List<Comment> getComments() {
        return comments;
    }

    /**
     * Sets comments.
     *
     * @param comments the comments
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }

    public void init() {
        this.tagIds = tagsToIds(this.getTags());
    }

    private String tagsToIds(List<Tag> tags) {
        if (!tags.isEmpty()){
            StringBuffer ids = new StringBuffer();
            boolean flag = false;
            for (Tag tag : tags){
                if (flag){
                    ids.append(",");
                }else {
                    flag = true;
                }
                ids.append(tag.getId());
            }
            return ids.toString();
        }else {
            return tagIds;
        }
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", appreciationStatus=" + appreciationStatus +
                ", shareStatus=" + shareStatus +
                ", commentStatus=" + commentStatus +
                ", recommendStatus=" + recommendStatus +
                ", publishStatus=" + publishStatus +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", type=" + type +
                ", tags=" + tags +
                ", user=" + user +
                ", comments=" + comments +
                ", tagIds='" + tagIds + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

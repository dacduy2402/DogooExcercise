package com.dogoo.training.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TODO")
public class TodoEntity {
    @Id
    @Column(name = "TODO_ID", nullable = false)
    private String id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "SELECTED", nullable = false)
    private boolean selected;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}

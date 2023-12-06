package com.bootrest.book_store_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "author")
public class Author {

    public Author() {
    }

    public Author(int authorId, String firstname, String lastname, String language) {
        this.authorId = authorId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.language = language;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private int authorId;

    private String firstname;
    private String lastname;
    private String language;

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Author [authorId=" + authorId + ", firstname=" + firstname + ", lastname=" + lastname + ", language="
                + language + "]";
    }

}

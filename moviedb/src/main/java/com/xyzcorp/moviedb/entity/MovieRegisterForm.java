package com.xyzcorp.moviedb.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="movie_register_form")
public class MovieRegisterForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "User_Id")
    private Long userId;
    @Column(name = "First_Name")
    private String firstname;
    @Column(name = "Last_Name")
    private String lastname;

    public Long getUserId() { return userId; }

    public void setUserId(Long userId) { this.userId = userId; }

    public String getFirstname() { return firstname; }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

}


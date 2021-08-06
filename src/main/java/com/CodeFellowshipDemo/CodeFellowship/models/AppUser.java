package com.CodeFellowshipDemo.CodeFellowship.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class AppUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String profilePic;
    private String username ;
    private String password ;
    private String firstName ;
    private String lastName ;
    private String dateOfBirth ;

    @ElementCollection
    private List<String> followes;




    @Column(columnDefinition = "text")
    private String bio ;

    @OneToMany(mappedBy="applicationUser")
    private List<Post> posts ;

    public AppUser(){}

    public AppUser(String username , String password){
        this.username = username ;
        this.password = password ;
    }

    public AppUser(String profilePic, String username , String password, String firstName , String lastName , String dateOfBirth ){
        this.profilePic = profilePic;
        this.firstName = firstName ;
        this.lastName = lastName ;
        this.dateOfBirth = dateOfBirth ;
        this.username = username ;
        this.password = password ;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getBio() {
        return bio;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setFollowes(List<String> followes) {
        this.followes = followes;
    }

    public List<String> getFollowes() {
        return followes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password ;
    }

    @Override
    public String getUsername() {
        return this.username ;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true ;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true ;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true ;
    }

    @Override
    public boolean isEnabled() {
        return true ;
    }
}

package com.leepuvier.learn.entry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

//@Entity对应数据库中的一个表
@Entity
public class User {

    //@Id配合@GeneratedValue，表示id自增长

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String user_id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    private String wechat_unionid;

    private String wechattmp_openid;

    @Column(nullable = false)
    private String wechat_openid;

    @Column(nullable = false)
    private String avatar_url;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String province;

    private String realname;

    private String id_card;

    private String wechatapp_openid;

    private Date create_time;

    private Date update_time;

    //必须要有一个无参的构造函数，不然数据库会报错

    public User() {
    }

    public User(String user_id, String username, String password, String phone,String email, String wechat_openid, String avatar_url, String city, String nickname, String country, String gender, String province){
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.wechat_openid = wechat_openid;
        this.avatar_url = avatar_url;
        this.city = city;
        this.nickname = nickname;
        this.country = country;
        this.gender = gender;
        this.province = province;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWechat_unionid() {
        return wechat_unionid;
    }

    public void setWechat_unionid(String wechat_unionid) {
        this.wechat_unionid = wechat_unionid;
    }

    public String getWechattmp_openid() {
        return wechattmp_openid;
    }

    public void setWechattmp_openid(String wechattmp_openid) {
        this.wechattmp_openid = wechattmp_openid;
    }

    public String getWechat_openid() {
        return wechat_openid;
    }

    public void setWechat_openid(String wechat_openid) {
        this.wechat_openid = wechat_openid;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getWechatapp_openid() {
        return wechatapp_openid;
    }

    public void setWechatapp_openid(String wechatapp_openid) {
        this.wechatapp_openid = wechatapp_openid;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}

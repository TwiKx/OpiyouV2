package fr.aubin.opiyou.domain;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name="youtuber")
public class Youtuber {

    @Id
    @GeneratedValue
    @Column(name="idYoutuber")
    private int idYoutuber;

    @Column(name="nameYoutuber")
    private String nameYoutuber;

    @Column(name="firstNameYoutuber")
    private String firstnameYoutuber;

    @Column(name="usernameYoutuber")
    private String usernameYoutuber;

    @Column(name="channelNameYoutuber")
    private String channelNameYoutube;

    @Column(name="subscribersCountYoutube")
    private long subscribersCount;

    @Column(name="loginYoutuber")
    private String loginYoutuber;

    @Column(name="pwdYoutuber")
    private String pwdYoutuber;

    @Column(name="linkChannel")
    private String linkChannel;

    public Youtuber(int idYoutuber, String nameYoutuber, String firstnameYoutuber, String usernameYoutuber, String channelNameYoutube, long subscribersCount, String loginYoutuber, String pwdYoutuber, String linkChannel) {
        this.idYoutuber = idYoutuber;
        this.nameYoutuber = nameYoutuber;
        this.firstnameYoutuber = firstnameYoutuber;
        this.usernameYoutuber = usernameYoutuber;
        this.channelNameYoutube = channelNameYoutube;
        this.subscribersCount = subscribersCount;
        this.loginYoutuber = loginYoutuber;
        this.pwdYoutuber = pwdYoutuber;
        this.linkChannel = linkChannel;
    }

    public Youtuber(String nameYoutuber, String firstnameYoutuber, String usernameYoutuber, String channelNameYoutube, long subscribersCount, String loginYoutuber, String pwdYoutuber, String linkChannel) {
        this.nameYoutuber = nameYoutuber;
        this.firstnameYoutuber = firstnameYoutuber;
        this.usernameYoutuber = usernameYoutuber;
        this.channelNameYoutube = channelNameYoutube;
        this.subscribersCount = subscribersCount;
        this.loginYoutuber = loginYoutuber;
        this.pwdYoutuber = pwdYoutuber;
        this.linkChannel = linkChannel;
    }

    public int getIdYoutuber() {
        return idYoutuber;
    }

    public void setIdYoutuber(int idYoutuber) {
        this.idYoutuber = idYoutuber;
    }

    public String getNameYoutuber() {
        return nameYoutuber;
    }

    public void setNameYoutuber(String nameYoutuber) {
        this.nameYoutuber = nameYoutuber;
    }

    public String getFirstnameYoutuber() {
        return firstnameYoutuber;
    }

    public void setFirstnameYoutuber(String firstnameYoutuber) {
        this.firstnameYoutuber = firstnameYoutuber;
    }

    public String getUsernameYoutuber() {
        return usernameYoutuber;
    }

    public void setUsernameYoutuber(String usernameYoutuber) {
        this.usernameYoutuber = usernameYoutuber;
    }

    public String getChannelNameYoutube() {
        return channelNameYoutube;
    }

    public void setChannelNameYoutube(String channelNameYoutube) {
        this.channelNameYoutube = channelNameYoutube;
    }

    public long getSubscribersCount() {
        return subscribersCount;
    }

    public void setSubscribersCount(long subscribersCount) {
        this.subscribersCount = subscribersCount;
    }

    public String getLoginYoutuber() {
        return loginYoutuber;
    }

    public void setLoginYoutuber(String loginYoutuber) {
        this.loginYoutuber = loginYoutuber;
    }

    public String getPwdYoutuber() {
        return pwdYoutuber;
    }

    public void setPwdYoutuber(String pwdYoutuber) {
        this.pwdYoutuber = pwdYoutuber;
    }

    public String getLinkChannel() {
        return linkChannel;
    }

    public void setLinkChannel(String linkChannel) {
        this.linkChannel = linkChannel;
    }
}

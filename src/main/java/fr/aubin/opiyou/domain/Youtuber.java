package fr.aubin.opiyou.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table
public class Youtuber {

    @Id
    @GeneratedValue
    private int idYoutuber;

    private String nameYoutuber;
    private String firstnameYoutuber;
    private String usernameYoutuber;
    private String channelNameYoutube;
    private BigInteger subscribersCount;
    private String loginYoutuber;
    private String pwdYoutuber;
    private String linkChannel;

    public Youtuber(int idYoutuber, String nameYoutuber, String firstnameYoutuber, String usernameYoutuber, String channelNameYoutube, BigInteger subscribersCount, String loginYoutuber, String pwdYoutuber, String linkChannel) {
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

    public Youtuber(String nameYoutuber, String firstnameYoutuber, String channelNameYoutube, String loginYoutuber, String pwdYoutuber, String linkChannel) {
        this.nameYoutuber = nameYoutuber;
        this.firstnameYoutuber = firstnameYoutuber;
        this.channelNameYoutube = channelNameYoutube;
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

    public BigInteger getSubscribersCount() {
        return subscribersCount;
    }

    public void setSubscribersCount(BigInteger subscribersCount) {
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

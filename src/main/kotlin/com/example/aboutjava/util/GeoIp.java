package com.example.aboutjava.util;

import java.io.Serializable;
import java.util.StringJoiner;

public class GeoIp implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String ip;
    private final String country;
    private final String city;
    private final String postal;
    private final String timezone;
    private final String latitude;
    private final String longitude;

    public GeoIp(String ip, String country, String city, String postal, String timezone,
            String latitude, String longitude) {
        this.ip = ip;
        this.country = country;
        this.city = city;
        this.postal = postal;
        this.timezone = timezone;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getIpAddress() {
        return ip;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getPostal() {
        return postal;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GeoIp.class.getSimpleName() + "[", "]")
                .add("ip='" + ip + "'")
                .add("country='" + country + "'")
                .add("city='" + city + "'")
                .add("postal='" + postal + "'")
                .add("timezone='" + timezone + "'")
                .add("latitude='" + latitude + "'")
                .add("longitude='" + longitude + "'")
                .toString();
    }
}

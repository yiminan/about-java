package com.example.aboutjava.util.geoip;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import java.io.IOException;
import java.net.InetAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class GeoIpUtil {

    private static final Logger log = LoggerFactory.getLogger(GeoIpUtil.class);

    private static final DatabaseReader dbReader;

    static {
        try {
            dbReader = new DatabaseReader
                    .Builder(GeoIpUtil.class.getClassLoader().getResourceAsStream("GeoLite2-City.mmdb"))
                    .build();
        } catch (IOException e) {
            throw new IllegalStateException("Geo IP data initialize failed", e);
        }
    }

    public static GeoIp getLocation(String ip) {
        try {
            CityResponse response = dbReader.city(InetAddress.getByName(ip));
            String country = response.getCountry().getIsoCode();
            String cityName = response.getCity().getName();
            String postal = response.getPostal().getCode();
            String timezone = response.getLocation().getTimeZone();
            String latitude = response.getLocation().getLatitude().toString();
            String longitude = response.getLocation().getLongitude().toString();
            return new GeoIp(ip, country, cityName, postal, timezone, latitude, longitude);
        } catch (IOException e) {
            log.error("Unknown Host", e);
        } catch (GeoIp2Exception e) {
            log.error("Failed to get GeoIP", e);
        }
        return null;
    }
}

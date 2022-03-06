package com.teste.dev.controller;
import com.teste.dev.model.GeolocationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.teste.dev.utils.Haversine.haversineMetros;


@RestController
@RequestMapping("/distance")
//@Profile(value = {"prod,test"})
public class LocationController {

    @GetMapping()
    public ResponseEntity<?> getDistance(@RequestBody GeolocationResponse geolocationResponse){
        try {
            return new ResponseEntity<>(haversineMetros(geolocationResponse.getGeoLocationInit().getLat(),geolocationResponse.getGeoLocationInit().getLng(),
                    geolocationResponse.getGeoLocationEnd().getLat(),geolocationResponse.getGeoLocationEnd().getLng()), HttpStatus.OK);
        }catch (Exception e){
            return
            ResponseEntity.status(HttpStatus.FORBIDDEN).body("Verifique se não tem valores nulos");
        }

    }


}

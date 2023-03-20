package com.qirara.rest.nekoservice.nekoservice.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.qirara.rest.nekoservice.nekoservice.payload.response.MerchantDynamicFilterResponse;
import com.qirara.rest.nekoservice.nekoservice.payload.response.MerchantResponse;
import com.qirara.rest.nekoservice.nekoservice.payload.response.WebResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;
import java.util.Arrays;
import java.util.List;


// filter are divided into 2 types
// this - Static Filter
// Dynamic Filtering
@RestController
@RequestMapping(path = "/api/")
public class FilterController {

    // static filter, devine in MerchantResponse
    @GetMapping(path = "/merchant", produces = "application/json")
    public ResponseEntity<WebResponse<MerchantResponse>> getMerchantStatic() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new WebResponse<>(
                        HttpStatus.OK.value(),
                        HttpStatus.OK.getReasonPhrase(),
                        new MerchantResponse(
                                "Kaguya shinomiya sama",
                                "kaguyachan@gmail.com",
                                "secret-password"
                        )
                ));
    }

    // static filter, devine in MerchantResponse
    @GetMapping(path = "/merchant-list", produces = "application/json")
    public ResponseEntity<WebResponse<List<MerchantResponse>>> getAllMerchantStatic() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new WebResponse<>(
                        HttpStatus.OK.value(),
                        HttpStatus.OK.getReasonPhrase(),
                        Arrays.asList(
                                new MerchantResponse(
                                        "Kaguya shinomiya sama",
                                        "kaguyachan@gmail.com",
                                        "secret-password"
                                ),
                                new MerchantResponse(
                                        "Hayasaka AI",
                                        "hayasakaai@gmail.com",
                                        "secret-password"
                                )

                        )
                ));
    }

    // dynamic filter example
    @GetMapping(path = "/merchant-dynamic",produces = MediaType.APPLICATION_JSON_VALUE)
    public MappingJacksonValue getMerchantDynamic() {

        WebResponse<MerchantDynamicFilterResponse> merchantResponseWebResponse = new WebResponse<>(
                HttpStatus.OK.value(),
                HttpStatus.OK.getReasonPhrase(),
                new MerchantDynamicFilterResponse(
                        "Kaguya shinomiya sama",
                        "kaguyachan@gmail.com",
                        "secret-password"
                )
        );

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(merchantResponseWebResponse);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("BeanMerchantFilter", filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    // dynamic filter example
    @GetMapping(path = "/merchant-dynamic-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public MappingJacksonValue getMerchantDynamicAll() {

        WebResponse<List<MerchantDynamicFilterResponse>> merchantResponseWebResponse = new WebResponse<>(
                HttpStatus.OK.value(),
                HttpStatus.OK.getReasonPhrase(),
               Arrays.asList(
                       new MerchantDynamicFilterResponse(
                               "Kaguya shinomiya sama",
                               "kaguyachan@gmail.com",
                               "secret-password"
                       ),
                       new MerchantDynamicFilterResponse(
                               "hayasaka ai",
                               "hayasakaaichan@gmail.com",
                               "secret-password"
                       )
               )
        );


        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(merchantResponseWebResponse);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("BeanMerchantFilter", filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }


}

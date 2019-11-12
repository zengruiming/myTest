package com.ruiming.webclient.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class PostService {
    private static Logger log= LoggerFactory.getLogger(com.ruiming.webclient.controller.Test.class);
    public void testWithCookie(){
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("ic","UKXR64");
        Mono<String> resp = WebClient.create().post()
                .uri("https://mini1.91quzou.com/activity/inviteVideo/receive.do")
                .headers(httpHeaders -> {
                    httpHeaders.add("minitype", "QUZOUMINI");
                    httpHeaders.add("source","2001");
                    httpHeaders.add("appname","MINI");
                    httpHeaders.add("cache-control","no-cache");
                    httpHeaders.add("appversion","3.3.0");
                    httpHeaders.add("appid","QUZUOO2C01YTQYOH9Q100207N063H7ES2Z43");
                    httpHeaders.add("appmuid","00000000-0974-ac6b-0000-00004eae1b41");
                    httpHeaders.add("referer","https://servicewechat.com/wx9681faeb5e00cdf0/38/page-frame.html");
                    httpHeaders.add("appbundleid","QUZOU_MINI");
                    httpHeaders.add("accesstoken","+NEflO3uj02MBMS5Y1lDrWp6h2nk+NkrJvSsGhwGPyfs4wcVLp9cgApfWcz6kQlck+vttQl74CMPo9HibM6F9tPtHGhWTxf0SgaTS0fuBntA0NzEEDZJbQWwD57Capn1p9ey43QoDRqJEhPWJSynhlBINYoWs0Sw9ABu0ZMUSJVatUNmk8Gu7Q==");
                    httpHeaders.add("appmode","PROD");
                })
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(formData))
                .retrieve().bodyToMono(String.class);
        log.info("result:{}",resp.block());
    }
}

package com.SpringOauth2.SpringOauth2;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/image-proxy")
public class ImageProxyController {

    @GetMapping
    public ResponseEntity<byte[]> fetchImage(@RequestParam String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET, null, byte[].class);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG); // Adjust format if needed
        return new ResponseEntity<>(response.getBody(), headers, HttpStatus.OK);
    }
}

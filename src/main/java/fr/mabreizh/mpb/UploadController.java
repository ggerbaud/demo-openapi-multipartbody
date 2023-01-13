package fr.mabreizh.mpb;

import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.core.async.publisher.Publishers;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.multipart.CompletedPart;
import io.micronaut.http.server.multipart.MultipartBody;
import org.reactivestreams.Publisher;

import static io.micronaut.http.MediaType.MULTIPART_FORM_DATA;
import static io.micronaut.http.MediaType.TEXT_PLAIN;

@Controller
public class UploadController {

    @Post(value = "whole-body", consumes = MULTIPART_FORM_DATA, produces = TEXT_PLAIN)
    public Publisher<String> uploadFile(@Body MultipartBody body) {
        return Publishers.map(body, CompletedPart::getName);
    }
}

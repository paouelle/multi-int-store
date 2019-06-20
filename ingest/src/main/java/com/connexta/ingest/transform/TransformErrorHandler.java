package com.connexta.ingest.transform;

import java.io.IOException;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

public class TransformErrorHandler extends DefaultResponseErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransformErrorHandler.class);

    @Override
    protected void handleError(ClientHttpResponse response, HttpStatus statusCode) throws IOException {
        String statusText = response.getStatusText();
        HttpHeaders headers = response.getHeaders();
        byte[] body = getResponseBody(response);
        Charset charset = getCharset(response);
        switch (statusCode.series()) {
        case CLIENT_ERROR:
            //We give them a badly formed request, or their API doesn't like our stuff
            //Return an error somehow because this is the user's fault- stop being a bad user!
            LOGGER.info("Less bad thing happened.");
            break;
        case SERVER_ERROR:
            //We can't connect to transform service (incorrectly configured url?)
            //The service is down (retry?)
            LOGGER.info("More bad thing happened.");
            break;
        default:
            LOGGER.info("A pretty bad thing happened, not sure what to do here.");
            //throw new UnknownHttpStatusCodeException(statusCode.value(), statusText, headers, body, charset);
        }
    }
}

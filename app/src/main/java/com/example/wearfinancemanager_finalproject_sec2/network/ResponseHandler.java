package com.example.wearfinancemanager_finalproject_sec2.network;

import retrofit2.Response;
import java.io.IOException;

public class ResponseHandler<T> {
    public static <T> T handleResponse(Response<T> response) throws IOException {
        if (response.isSuccessful()) {
            return response.body();
        } else {
            throw new IOException("Error code: " + response.code());
        }
    }
}
